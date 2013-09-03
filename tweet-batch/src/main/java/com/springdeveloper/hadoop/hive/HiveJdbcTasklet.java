/*
 * Copyright 2013 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.springdeveloper.hadoop.hive;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.jdbc.core.JdbcTemplate;

public class HiveJdbcTasklet implements Tasklet {

	private static final Log log = LogFactory.getLog(HiveJdbcTasklet.class);

	private JdbcTemplate template;
	
	private String outputPath;
	
	public void setJdbcTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public void setOutputPath(String outputPath) {
		this.outputPath = outputPath;
	}

	public RepeatStatus execute(StepContribution stepContribution, ChunkContext context)
			throws Exception {

		log.info("Hive JDBC Task Running");
		
		String tableDdl = "create external table if not exists tweetdata (value STRING) LOCATION '/tweets/input'";
		String query = "select r.retweetedUser, '\t', count(r.retweetedUser) as count " +
					" from tweetdata j " +
					" lateral view json_tuple(j.value, 'retweet', 'retweetedStatus') t as retweet, retweetedStatus " + 
					" lateral view json_tuple(t.retweetedStatus, 'fromUser') r as retweetedUser " +
					" where t.retweet = 'true' " +
					" group by r.retweetedUser order by count desc limit 10";
		String results = "insert overwrite directory '" + outputPath + "/hiveout'";
		
		template.execute(tableDdl);

		template.execute(results + " " + query);

		return null;
	}
}

package com.springdeveloper.hadoop.batch;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

public class BatchApp {

	private static final Log log = LogFactory.getLog(BatchApp.class);

	public static void main(String[] args) throws Exception {
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("classpath:/META-INF/spring/application-context.xml");
		log.info("Batch TweetCount Application Running");
		context.registerShutdownHook();

		JobLauncher jobLauncher = context.getBean(JobLauncher.class);
		Job job = context.getBean(Job.class);

		jobLauncher.run(
				job,
				new JobParametersBuilder()
						.addString("mr.input", "/tweets/input")
						.addString("mr.output", "/tweets/output")
						.addString("localData", "data/nbatweets-small.txt")
						.addDate("date", new Date()).toJobParameters());
		context.close();
	}
}

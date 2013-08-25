package com.springdeveloper.hadoop;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;


public class TweetCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	
	private final static IntWritable ONE = new IntWritable(1);
	private final ObjectMapper mapper = new ObjectMapper(new JsonFactory());
	
	@SuppressWarnings("unchecked")
	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		
		Map<String, Object> tweet = mapper.readValue(value.toString(), 
				new TypeReference<HashMap<String,  Object>>(){});
		Map<String, Object> entities = (Map<String, Object>) tweet.get("entities");
		List<Map<String, Object>> hashTagEntries = null;
		
		if (entities != null) {
			hashTagEntries = (List<Map<String, Object>>) entities.get("hashTags");
		}
		
		if (hashTagEntries != null && hashTagEntries.size() > 0) {
			for (Map<String, Object> hashTagEntry : hashTagEntries) {
				String hashTag = hashTagEntry.get("text").toString();
				context.write(new Text(hashTag), ONE);
			}
		}
	}

}

package com.springdeveloper.batch.item;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.file.LineMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.util.Assert;

public class HashTagMapper implements LineMapper<Map<String, Object>> {

	public Map<String, Object> mapLine(String line, int lineNum) throws Exception {
		Assert.notNull(line, "Expecting line not to be null");
		String[] tokens = line.split("\t");
		if (tokens.length != 2) {
			throw new DataIntegrityViolationException("Expecting 2 tokens in input line: " + line);
		}
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("hashtag", tokens[0]);
		data.put("count", tokens[1]);
		return data;
	}

}

package com.springdeveloper.batch.item;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.ItemWriteListener;

public class MyJdbcListener implements ItemWriteListener<Map<String, Object>> {

	private static final Log log = LogFactory.getLog(MyJdbcListener.class);

	public void afterWrite(List<? extends Map<String, Object>> m) {
	}

	public void beforeWrite(List<? extends Map<String, Object>> m) {
		log.info("Writing to JDBC :: " + m);
	}

	public void onWriteError(Exception e,
			List<? extends Map<String, Object>> l) {
	}

}

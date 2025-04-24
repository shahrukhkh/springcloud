package com.khan.app.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.khan.app.entity.StkInfo;

public class JsonUtil {

	public static StkInfo convertToObject(String msg) {
		
		try {
			return new ObjectMapper().readValue(msg, StkInfo.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String convertToString(StkInfo stk) {
		try {
			return new ObjectMapper().writeValueAsString(stk);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

}

package com.cos.hotspot.config;

import java.text.ParseException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



public class Utils {
	
	public static JSONObject jsonParser (String str) throws ParseException {
		JSONParser parser = new JSONParser();
		
		Object obj = null;
		
		try {
			obj = parser.parse(str);
			
		} catch (org.json.simple.parser.ParseException e) {
			e.printStackTrace();
		}
		
		org.json.simple.JSONObject jsonObject = (org.json.simple.JSONObject) obj;
		
		return jsonObject;
		
    }

}

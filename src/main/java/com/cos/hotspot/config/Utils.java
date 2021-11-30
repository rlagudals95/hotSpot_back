package com.cos.hotspot.config;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.validation.Validator;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



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
	
	 
	 
	 
	public static void getMeta(String url) throws IOException{
		
		Document doc = Jsoup.connect(url).get();
		System.out.println("doc : "+doc);
		String keywords = doc.select("meta[name=keywords]").first().attr("content");  
//		System.out.println("Meta keyword : " + keywords);  
//		String description = doc.select("meta[name=description]").get(0).attr("content");  
//		Elements images = doc.select("img[src~=(?i)\\.(png|jpe?g|gif)]");  
	}
	
//	public static void getMeta(String url) throws IOException{
//
//		for (int i =1; i < 10; i++) {
//			String CawlingUrl = "https://section.blog.naver.com/Search/Post.nhn?pageNo="+ i + "&rangeType=ALL&orderBy=sim&keyword=" + url;
//			
//			Document doc = Jsoup.connect(CawlingUrl).get();
//			System.out.println("doc : "+doc);
//			String ogImage = doc.select("meta[property=og:image]").first().attr("content");
//			
//			System.out.println("ogImage : "+ogImage);
//			/*
//			 * String keywords = doc.select("meta[name=keywords]").first().attr("content");
//			 * System.out.println("Meta keyword : " + keywords);
//			 */  
//	}
		
		
		
	
}



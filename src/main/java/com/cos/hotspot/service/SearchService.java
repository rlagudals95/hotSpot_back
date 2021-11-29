package com.cos.hotspot.service;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.ClientEndpointConfig.Builder;

import org.apache.tomcat.util.json.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import com.cos.hotspot.config.NaverCrawler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.cos.hotspot.config.Utils;

@SuppressWarnings("unused")
@Service("searchService")
public class SearchService {
	
	public static String main(String url) throws IOException {
        System.out.println("검색어 : "+ url);
     
        String result = "";
        try {
	        NaverCrawler crawler = new NaverCrawler();
	        String _url = URLEncoder.encode(url, "UTF-8");
	        String response = crawler.search("Qjcu2eErcOe9ypZkNwbQ", "2S8N_LMwCP", _url);
	        
	        result = response;
	        
	        org.json.simple.JSONObject obj = Utils.jsonParser(response);
	        
	        JSONArray items = (JSONArray) obj.get("items");
	        
	        JSONObject jsonObj = (JSONObject) items.get(0);
	        System.out.println("items:" +items.getClass());
	        for (int i = 0; i < items.size(); i++) {              
	            JSONObject explrObject = (JSONObject) items.get(i);  
	            String link = (String) explrObject.get("link");
	            System.out.println("link : "+link);
	        }      
	        
	        
        } catch (Exception e) {
        	e.printStackTrace();
        }
        System.out.println("검색결과"+result);
        return result;
	};
	
	public static String getMeta(String url) throws IOException{
		
		Map<String, Object> returnMap = new HashMap<String,Object>();
		Document document = Jsoup.connect(url).get();

	
		System.out.println("크롤링 : "+ document);
		
		String test = "";
		
		
		return "";
	}
	

	
}
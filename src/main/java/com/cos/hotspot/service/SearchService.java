package com.cos.hotspot.service;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
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
	
	public Map<String, Object> main(String url) throws IOException {
        System.out.println("검색어 : "+ url);
     
        String result = "";
        Map<String, Object> responseData = new HashMap<String, Object>();
        
        try {
	        NaverCrawler crawler = new NaverCrawler();
	        String _url = URLEncoder.encode(url, "UTF-8");
	        String response = crawler.search("Qjcu2eErcOe9ypZkNwbQ", "2S8N_LMwCP", _url);
	        
	        
	        
	        org.json.simple.JSONObject obj = Utils.jsonParser(response);
	        //System.out.println("result: "+result);
	        JSONArray items = (JSONArray) obj.get("items");
	        JSONObject jsonObj = (JSONObject) items.get(0);
	        
	        ArrayList thumb_list = new ArrayList();
	        
	        //System.out.println("items:" +items.getClass());
	        for (int i = 0; i < items.size(); i++) {              
	            JSONObject explrObject = (JSONObject) items.get(i);  
	            String link = (String) explrObject.get("link");
	            String thumb = Utils.getMeta(link);
	            thumb_list.add(thumb);
	            
	        }   
	        responseData.put("result", obj);
	        responseData.put("thumb_list", thumb_list);
	        //System.out.println("썸네일  : "+thumb_list);
	        // .substring(0,thumb_list.length() -1 )
	        //String thumbStr = "," +"thumbs_list :"+ "["+  String.join("", thumb_list) +"]" + "}";
	        //thumbStr = response.substring(0,response.length() -1 ) + thumbStr;
	        //System.out.println("썸네일  : "+ response);
	        
	        
        } catch (Exception e) {
        	e.printStackTrace();
        }
        System.out.println("responseData  : "+responseData);
        return responseData;
	};
	
	
}
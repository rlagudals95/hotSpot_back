package com.cos.hotspot.service;

import java.net.URLEncoder;

import org.springframework.stereotype.Service;

import com.cos.hotspot.config.NaverCrawler;

@Service("searchService")
public class SearchService {
	
	public static String main(String url) {
              
	    String result = "";
        try {
	        NaverCrawler crawler = new NaverCrawler();
	        String _url = URLEncoder.encode(url, "UTF-8");
	        String response = crawler.search("Qjcu2eErcOe9ypZkNwbQ", "2S8N_LMwCP", _url);
	        
	        result = response;
	       
        } catch (Exception e) {
        	e.printStackTrace();
        }
        System.out.println(result);
        return result;
	}
}
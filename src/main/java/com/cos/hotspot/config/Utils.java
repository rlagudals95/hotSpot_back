package com.cos.hotspot.config;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.validation.Validator;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



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
 
	public static String getMeta(String url) throws IOException{
		// 네이버 블로그 url로 document가져오기
		Document doc = Jsoup.connect(url).get();
	
		// iframe 태그에 있는 진짜 블로그 주소 가져오기
		Elements iframes = doc.select("iframe#mainFrame");
		String src = iframes.attr("src");
		//진짜 블로그 주소 document 가져오기
		String url2 = "http://blog.naver.com"+ src;
		Document doc2 = Jsoup.connect(url2).get();
		//System.out.println("주소 확인용 : " +url2);
		//System.out.println("doc2 : "+doc2);
		// 블로그에서 원하는 블로그 페이지 가져오기
		String[] blog_logNo = src.split("&");
		String[] logNo_split = blog_logNo[1].split("=");
		String logNo = logNo_split[1];
		
		// 찾고자 하는 블로그 본문 가져오기
		String real_blog_addr = "div#post-view" + logNo;
		
		Elements blog_element = doc2.select(real_blog_addr);
		// 블로그 썸네일 가져오기
		String og_image = doc2.select("meta[property=og:image]").get(0).attr("content");
		//System.out.println("og_image : " + og_image);
		return og_image;
	}

	
	public static void selenium(String url) {
		WebDriver driver = null;
			try {
				// drvier 설정 - 저는 d드라이브 work 폴더에 있습니다.
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\hotSpot_back\\hotspot\\src\\main\\resources\\static\\selenium\\chromedriver.exe");
				// Chrome 드라이버 인스턴스 설정1
				driver = new ChromeDriver();
				
				// 블로그 URL로 접속
				driver.get(url);
				
				driver.switchTo().defaultContent(); // you are now outside both frames
				driver.switchTo().frame("cq-cf-frame");
				// now continue step 6
				driver.findElement(By.xpath("//button[text()='OK']")).click(); 
				// 대기 설정
				
		} catch (Throwable e) {
		e.printStackTrace();
		} finally {
			driver.close();
		}
	}
		
}



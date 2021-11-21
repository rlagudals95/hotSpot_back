package com.cos.hotspot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.hotspot.service.SearchService;


@RestController
public class SearchController {
	
	@Autowired
	private SearchService naverService;
	
	// 유저 혹은 어드민이 접근 가능
	@PostMapping("/search/{url}")
	public String search(@PathVariable("url") String url) {
		//System.out.println("principal : "+principal.getUsername());
			
		return naverService.main(url);
	}	
}

package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.TestDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/test/*")
@Log4j
public class TestController {
	
	
	@GetMapping("/test01")
	public String test01Get() {
	log.info("test01...");
	
	return "/sample/test01";
	}
	
	
	@PostMapping("/test01Post")
	public String test01Post(@RequestParam("title")String title,
			@RequestParam("content") String content) {
		log.info("~~~~~~~~~~~~~");
		log.info("content :" + content);
		log.info("title :" + title);
		log.info("~~~~~~~~~~~~~");
		return "/sample/ex04";
		
	}
	
	@PostMapping("/test02Post")
	public String test02Post(@RequestParam("title")String title,
			@RequestParam("content") String content, Model model) {
		
		TestDTO dto = new TestDTO();
		
		dto.setTitle(title);
		dto.setContent(content);
		
		log.info("--------------");
		log.info(dto);
		log.info("--------------");
	
		model.addAttribute("test",dto);
		
		return "/sample/test02";
	}
	
	@PostMapping("/test03Post")
	public String test03Post(@RequestParam("title") String title,
			@RequestParam("content") String content) {
	
		
		
		return "/sample/test03";
	}
	
	

}

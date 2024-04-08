package kr.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")

public class BoardController {
	
	@GetMapping("/board01")
	public String board01Get() {
		
		log.info("boardGet01...");
		
		return "/board/board01";
	}
	
	@PostMapping("/board01")
	public String board01Post(@RequestParam("name")String name,
			@RequestParam("title")String title,
			@RequestParam("content")String content) {
		
		log.info("-------------------");
		log.info(name);
		log.info(title);
		log.info(content);
		log.info("-------------------");
		
		
		
		return "/board/board01Result";
	}

}

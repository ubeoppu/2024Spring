package kr.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.com.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequiredArgsConstructor
@RequestMapping("/board/*")

public class BoardController {
	
	//생성자 주입
	private final BoardService service;
	
	@GetMapping("/list")
	public void getBoardList(Model model) {
		log.info("list..");
		log.info("???왜안찍혀");
		model.addAttribute("list", service.BoardList());
	}
	
	@GetMapping("/insert")
	public void insertBoard() {
		
	}
	

}

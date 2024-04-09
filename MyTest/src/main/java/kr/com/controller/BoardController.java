package kr.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.com.dto.BoardDTO;
import kr.com.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor

public class BoardController {
	
	//생성자 주입
	private final BoardService service;
	
	@GetMapping("/board01")	
	public String board01Get() {
		
		log.info("boardGet01...");
		
		return "/board01";
	}
	
	@PostMapping("/board01insert")
	public String board01Post(@RequestParam("name")String name,
			@RequestParam("title")String title,
			@RequestParam("content")String content,
			Model model) {
		
		log.info("-------------------");
		log.info(name);
		log.info(title);
		log.info(content);
		log.info("-------------------");
		
		BoardDTO dto = BoardDTO.builder()
				.name(name)
				.title(title)
				.content(content)
				.build();
		
		service.insertBoard(dto);
		
		
		
		return "/board/board01Result";
	}
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("list...");
		model.addAttribute("list", service.selectBoardList());
		
	}
	

}

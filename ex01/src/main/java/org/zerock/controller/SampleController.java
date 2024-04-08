package org.zerock.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.Data.SampleDTO;
import org.zerock.domain.TodoDTO;

import com.google.gson.Gson;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	
	//java.util.date 사용하려면 필요!
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	@RequestMapping("")
	public void basic() {
		log.info("basic..");
	}
	
	@RequestMapping(value= "/basic", method = {RequestMethod.GET})
	public void basicGet() {
		log.info("basic Get...");
	}
	
	@RequestMapping(value= "/basic", method = {RequestMethod.POST})
	public void basicGetPost() {
		log.info("basic post...");
	}
	
	@GetMapping("/basic2")
	public void basicGet2() {
		log.info("basic get2...");
	}

	@PostMapping("/basic2")
	public void basicPost2() {
		log.info("basic Post2...");
	}
	
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		log.info(dto);
		return "ex01";
	}
	
	@PostMapping("/ex01")
	public String ex01_(SampleDTO dto) {
		log.info(dto);
		return "ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name,@RequestParam("age")int age) {
		log.info(name);
		log.info(age);
		return "ex02";
	}
	@PostMapping("/ex02")
	public String ex02_(@RequestParam("name") String name,@RequestParam("age")int age) {
		log.info(name);
		log.info(age);
		return "ex02";
	}
	
	@GetMapping("/ex03")
	public String ex03(TodoDTO dto) {
		log.info(dto);
		log.info(dto.getTitle());
		log.info(dto.getDueDate());
		return "ex03";
	}
	
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, int page, Model model) {
		log.info("dto : " + dto);
		log.info("page :" + page);
		model.addAttribute("sample", dto);
		model.addAttribute("page", page);
		
		
		return "/sample/ex04";
	}
	
	@GetMapping("/ex044")
	public String ex04_(@RequestParam("age")int age,Model model, RedirectAttributes rttr) {
		
		rttr.addFlashAttribute("age", age); //값을 한 번만 전달
		
		return "redirect:/sample/ex01";
		
	}
	
	@GetMapping("/ex05") //sample/ex05 => WEB-INF/view/sample/ex05.jsp
	public void ex05() {
		log.info("ex05");
	}
	
	@GetMapping("/ex06")
	@ResponseBody 
	public SampleDTO ex06() {
		SampleDTO sampleDTO = new SampleDTO();
		
		sampleDTO.setName("aaaa");
		sampleDTO.setAge(22);
		
		return sampleDTO;
	}
	
	@GetMapping("/ex07")
	public ResponseEntity<String>ex07(){
		log.info("/ex07..");
		
		//{"name":"홍길동"}
		String msg = "{\"name\" : \"홍길동\"}";
		
		SampleDTO dto = new SampleDTO();
		
		dto.setName("홍길동");
		dto.setAge(49);
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json; charset=UTF-8");
		
		return new ResponseEntity<>(msg, header, HttpStatus.OK);
	}	
		
		@GetMapping("/ex08")
		public ResponseEntity<String>ex08(){
			log.info("/ex08..");
			
			SampleDTO dto = new SampleDTO();
			dto.setName("홍길동");
			dto.setAge(49);
			
			Gson gson = new Gson();
			String jsonStr = gson.toJson(dto);
			
			log.info(jsonStr);
			
			HttpHeaders header = new HttpHeaders();
			header.add("Content-Type", "application/json; charset=UTF-8");
			
			return new ResponseEntity<>(jsonStr, header, HttpStatus.OK);
	}
		
		@GetMapping("/exUpload") //localhost:8181/sample/exUpload => (void) /WEB-INF/views/sample/exUpload.jsp
		public void exUpload() {
			log.info("exUpload......");
		}
		
		@PostMapping("/exUploadPost")
		public void exUploadPost(ArrayList<MultipartFile>files) {
		files.forEach(file -> {
		log.info("----------------------");	
		log.info("name : " + file.getOriginalFilename());
		log.info("size : " +file.getSize());
		});	
		}
}

package org.zerock.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class CommonController {
	
	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
		
		log.info("-----------------------");
		log.info(auth);
		log.info("-----------------------");
		
		model.addAttribute("msg", "접근 권한이 없습니다 ㅠ-ㅠ");
	}
	
	@GetMapping("/customLogin")//
	public void loginInput(String error, String logout, Model model) {
		
		if(error != null) {
			model.addAttribute("error", "아이디 or 비밀번호가 틀렸습니다");
		}
		
		if(logout != null) {
			model.addAttribute("logout", "로그아웃!!!");
		}
		
	}
	
	@GetMapping("/customLogout")
	public void logoutGET() {
		log.info("custom logout...");
	}

}

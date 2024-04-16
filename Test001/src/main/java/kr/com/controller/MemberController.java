package kr.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.com.domain.MemberVO;
import kr.com.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member/*")
@Log4j
public class MemberController {
	
	//생성자 주입
	private final MemberService service;
	
	@GetMapping("/register")
	public void registerMemberGet() {
		log.info("register...get...");
	}
	
	@PostMapping("/register")
	public String registerMemberPost(@ModelAttribute("vo")MemberVO vo, RedirectAttributes rttr) {
		log.info("register...post");
		
		service.registerMember(vo);
		rttr.addFlashAttribute("message", "회원가입을 환영합니다.");
		
		return "/main";
		
	}

}

package kr.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.com.domain.MemberVO;
import kr.com.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequiredArgsConstructor
@RequestMapping("/member/*")
public class MemberController {
	
	//생성자 주입
	private final MemberService service;
	
	@GetMapping("/register")
	public String registerPage() {
		log.info("회원 가입 페이지로 이동");
		
		return "/member/memberRegister";
	}
	
	@GetMapping("/test")
	public void testPage() {
		
	}
	@GetMapping("/mailCheck")
	@ResponseBody
	public void mailCheck(String email) {
		System.out.println("이메일 인증 요청이 들어옴!");
		System.out.println("이메일 인증 이메일 : " + email);
	}
	
	@PostMapping("/register")
	public String registerMember(MemberVO vo, RedirectAttributes rttr) {
		log.info("PostRegister");
		
		log.info(service.createMember(vo));
		
		rttr.addFlashAttribute("message", "회원가입을 환영합니다");
		
		return "redirect:/member/memberLogin";
				
	}

}

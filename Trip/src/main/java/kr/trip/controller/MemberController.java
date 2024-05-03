package kr.trip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.trip.domain.AuthVO;
import kr.trip.domain.MemberVO;
import kr.trip.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequiredArgsConstructor
public class MemberController {

   private final MemberService memberService;
   
   @Autowired
   private BCryptPasswordEncoder bc;
   
	@GetMapping("/customLogin")
	public void loginInput(String error, String logout, Model model) {
		
		log.info("error : " + error);
		log.info("logout : " + logout);
		
		if(error != null) {
			model.addAttribute("error", "아이디 or 비번이 틀립니다.");
		}
		
		if(logout != null) {
			model.addAttribute("logout", "로그아웃!!!!");
		}
	}
   
   
   @GetMapping("/join")
   public void join() {
      
   }
   
   
   @PostMapping("/join")
   @Transactional
   public String join(MemberVO member, RedirectAttributes rttr) {
      
      member.setPwd(bc.encode(member.getPwd()));
      
      memberService.register(member);
      memberService.insertAuth(new AuthVO(member.getMember_email(),"ROLE_MEMBER"));
      
      return "redirect:/customLogin";
   }
   
   
   
}
package kr.trip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.trip.service.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/admin")
@Log4j
@RequiredArgsConstructor
public class AdminController {
	
	private final AdminService adminservice; 
	
	@GetMapping("/main")
	public void main() {}
	
	
	@GetMapping("/member")
	public void getMemberList(Model model) {
	model.addAttribute("list",adminservice.getListMember());	
	}
	
	@PostMapping("/member")
	public String deleteMember(@RequestParam("member_email")String member_email, RedirectAttributes rttr) {
		log.info(member_email);
		
		adminservice.deleteMember(member_email);
		
		return "redirect:/admin/list";
	}
	@GetMapping("/help")
	public void getHelpList(Model model) {
		model.addAttribute("list", adminservice.getListHelp());
	}
	
	@GetMapping("/helpa")
	public void readHelpA(Model model) {
		
		model.addAttribute("list", )
	}
		

}

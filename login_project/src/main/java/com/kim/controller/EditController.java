package com.kim.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kim.model.User;
import com.kim.service.UserService;

@Controller
public class EditController {
	
	@Resource(name = "userService")
	private UserService userService;
	
	User user;
	
	@RequestMapping(value="/edit", method = RequestMethod.GET)
	public String toUserEditView(@RequestParam("userId") String userId, Model model) {
		this.user = new User();
		
		try {
			user = this.userService.getUser(userId);
			model.addAttribute("user", user);
			return "editForm";
			
		}catch (EmptyResultDataAccessException e) {
			model.addAttribute("user", user);
			model.addAttribute("errMsg", "사용자 정보가 존재하지 않습니다.");
			return "editForm";
		}
	}
	
	@RequestMapping(value="/edit", method = RequestMethod.POST)
	public String onSubmit(@Valid User user, BindingResult result, Model model) throws Exception{
		if(result.hasErrors()) {
			model.addAllAttributes(result.getModel());
			return "editForm";
		}
		if(this.userService.updateUser(user) != 0) {
			model.addAttribute("user", user);
			model.addAttribute("message", "다음과 같이 회원님의 정보가 수정되었습니다.");
			return "joinSuccess";
		}
		else {
			model.addAttribute("errMsg", "사용자 정보수정에 실패하였습니다.");
			return "editForm";
		}
	}
	
}

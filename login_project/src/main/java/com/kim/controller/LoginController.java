package com.kim.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kim.model.User;
import com.kim.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String toLoginView(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String onSubmit(@Valid User user, BindingResult result, Model model) {
		
		if(result.hasFieldErrors("id")||result.hasFieldErrors("pass")) {
			model.addAllAttributes(result.getModel());
			return "login";
		}
		
		try {
			User loginUser = this.userService.getUser(user.getId());
			
			if(user.getPass().equals(loginUser.getPass())) {
				model.addAttribute("loginUser", loginUser);
				if("admin".equals(loginUser.getRole())) {
					return "redirect:/adminPage";
				}else {
					return "loginOK";
				}
			}else {
				result.reject("error.password.user","패스워드가 일치하지 않습니다.");
				model.addAllAttributes(result.getModel());
				return "login";
			}
		}catch (EmptyResultDataAccessException e) {
			result.reject("error.id.user", "아이디가 존재하지 않습니다.");
			model.addAllAttributes(result.getModel());
			return "login";
		}
		
	}
	
	@RequestMapping(value="/findId", method = RequestMethod.GET)
	public String toFindIdForm(Model model) {
		model.addAttribute("user", new User());
		return "findIdForm";
	}
	
	@RequestMapping(value="/findId", method = RequestMethod.POST)
	public String findIdSubmit(@Valid User user, BindingResult result, Model model) {
		
		if(result.hasFieldErrors("name")||result.hasFieldErrors("email")) {
			model.addAllAttributes(result.getModel());
			return "findIdForm";
		}
		
		try {
			User findUser = this.userService.findId(user.getName(), user.getEmail());
			
			model.addAttribute("findUser", findUser);
			return "findIdSuccess";
			
		}catch (EmptyResultDataAccessException e) {
			model.addAttribute("errMsg", "이름이나 이메일 정보가 일치하지않습니다. 확인 후 다시 시도하여 주십시오.");
			return "findIdForm";
		}
		
	}
	
	@RequestMapping(value="/findPass", method = RequestMethod.GET)
	public String toFindPassForm(Model model) {
		model.addAttribute("user", new User());
		return "findPassForm";
	}
	
	@RequestMapping(value="/findPass", method = RequestMethod.POST)
	public String findPassSubmit(@Valid User user, BindingResult result, Model model) {
		
		if(result.hasFieldErrors("id")||result.hasFieldErrors("email")) {
			model.addAllAttributes(result.getModel());
			return "findPassForm";
		}
		
		try {
			User findUser = this.userService.findPass(user.getId(), user.getEmail());
			
			model.addAttribute("findUser", findUser);
			return "findPassSuccess";
			
		}catch (EmptyResultDataAccessException e) {
			model.addAttribute("errMsg", "아이디나 이메일 정보가 일치하지않습니다. 확인 후 다시 시도하여 주십시오.");
			return "findPassForm";
		}
		
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		
		return "redirect:login";
	}

}

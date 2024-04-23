package com.kim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kim.model.User;
import com.kim.service.UserService;

@Controller
public class AdminPageController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/adminPage")
	public String getAdminPAge(ModelMap model) {
		List<User> userList = userService.getUserList();
		System.out.println(userList);
		model.addAttribute("userList", userList);
		return "adminPage";
	}
	
}

package com.kim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kim.model.User;
import com.kim.service.UserService;

@Controller
public class ListController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/list")
	public String getList(ModelMap model) {
		List<User> userList = this.userService.getUserList();
		model.addAttribute("userList", userList);
		return "list";
	}
	
}

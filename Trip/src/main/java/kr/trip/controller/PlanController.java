package kr.trip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.trip.service.PlanService;
import lombok.RequiredArgsConstructor;
@RequestMapping("/plan")
@Controller
@RequiredArgsConstructor
public class PlanController {
	
	private final PlanService service;
	
	@GetMapping("/plan1")
	public void plan1(Model model) {
	model.addAttribute("list",service.getContentAreaList("경주"));
	model.addAttribute("areaname", "경주");
	}
	
	

}

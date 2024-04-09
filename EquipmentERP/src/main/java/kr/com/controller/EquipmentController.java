package kr.com.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.com.dto.EquipmentVO;
import kr.com.service.EquipmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/Equipment/*")
@Log4j
@RequiredArgsConstructor

public class EquipmentController {

	private final EquipmentService service;

	@GetMapping("/loginForm")
	public void loginForm() {
	}
	
	@GetMapping("/insertEquipment")
	public String InsertEquipment() {

		return "/Equipment/insertEquipment";
	}

	@PostMapping("/insertEquipment")
	public String InsertEquipmentPost(@RequestParam("EquipmentCode") int EquipmentCode,
			@RequestParam("EquipmentName") String EquipmentName, @RequestParam("MechanicName") String MechanicName,
			Model model) {

		EquipmentVO vo = EquipmentVO.builder().EquipmentCode(EquipmentCode).EquipmentName(EquipmentName)
				.MechanicName(MechanicName).build();

		int result = service.InsertEquipment(vo);
		log.info("insertEquipmentPost...");
		log.info(result);

		return "/Equipment/insertSuccess";

	}

	@GetMapping("/EquipmentList")
	public String selectEquipmentList(Model model) {

		List<EquipmentVO> list = service.SelectEquipmentList();

		model.addAttribute("list", list);

		return "Equipment/EquipmentList";
	}

	  @PostMapping("/deleteEquipment") 
	  public String deleteEquipmentPost(@RequestParam("EquipmentCode")int EquipmentCode) {
	  boolean flag = service.DeleteEquipment(EquipmentCode);
	  log.info(flag);
	  
	  return "Equipment/EquipmentList";
			  }
	  
	 
}

package kr.trip.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.trip.domain.ContentVO;
import kr.trip.domain.TravelContentVO;
import kr.trip.service.PlanService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
@RequestMapping("/plan")
@Controller
@RequiredArgsConstructor
@Log4j
public class PlanController {
	
	private final PlanService service;
	
	
	@GetMapping("/plan1")
	public void plan1(Model model) {
	model.addAttribute("list",service.getContentAreaList("경주"));
	model.addAttribute("areaname", "경주");
	}
	
	@ResponseBody
	@PostMapping(value="/insert", consumes ="application/json",
			produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String>insert(@RequestBody TravelContentVO plan){
		log.info("insert..." + plan);
		
		return service.insertTravelContent(plan) == 1 ? new ResponseEntity<String>("result", HttpStatus.OK) :
			                                            new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ResponseBody
	@DeleteMapping(value="/delete/{tcontent_id}", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String>delete(@PathVariable("tcontent_id")int tcontent_id){
		log.info("delete..." + tcontent_id);
		
		return service.deleteContent(tcontent_id) == 1 ? new ResponseEntity<String>("result", HttpStatus.OK) :
			                                             new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ResponseBody
	@GetMapping(value="/content/{plan_id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<ContentVO>>getContent(
			@PathVariable("plan_id")int plan_id
			){
		log.info("getContent.." + plan_id);
		
		List<ContentVO> result = service.getListContent(plan_id);
		
		log.info("getResult" + result);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@ResponseBody
	@DeleteMapping(value="/drop/{plan_id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String>drop(@PathVariable("plan_id")int plan_id){
		
		log.info("drop.."+plan_id);
		
		return service.deleteContentAll(plan_id) != 0 ? new ResponseEntity<String>("result", HttpStatus.OK) :
			                                            new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

	
	

}

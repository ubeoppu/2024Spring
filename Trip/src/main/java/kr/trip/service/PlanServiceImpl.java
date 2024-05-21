package kr.trip.service;

import java.util.List;

import org.apache.maven.doxia.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.trip.domain.ContentVO;
import kr.trip.domain.TravelContentVO;
import kr.trip.mapper.PlanMapper;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class PlanServiceImpl implements PlanService{
	
	@Autowired
	private PlanMapper mapper;

	@Override
	public List<ContentVO> getContentAreaList(String areaname) {
		log.info(areaname);
		return mapper.getContentAreaList(areaname);
	}

	@Override
	public int insertTravelContent(TravelContentVO vo) {
		log.info("insertTravelContent..." + vo);
		return mapper.insertTravelContent(vo);
	}


	@Override
	public int deleteContent(int tContent_id) {
		return mapper.deleteContent(tContent_id);
	}

	@Override
	public int deleteContentAll(int plan_id) {
		log.info("drop" + plan_id);
		return mapper.deleteContentAll(plan_id);
	}
	
}

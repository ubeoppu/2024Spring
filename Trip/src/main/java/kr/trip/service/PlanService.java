package kr.trip.service;

import java.util.List;

import kr.trip.domain.ContentVO;
import kr.trip.domain.TravelContentVO;

public interface PlanService {
	public List<ContentVO>getContentAreaList(String areaname);

	public int insertTravelContent(TravelContentVO vo);
	
	
	public int deleteContent(int tContent_id);
	
	public int deleteContentAll(int plan_id);
}

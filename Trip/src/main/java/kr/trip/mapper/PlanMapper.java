package kr.trip.mapper;

import java.util.List;

import kr.trip.domain.ContentVO;
import kr.trip.domain.TravelContentVO;

public interface PlanMapper {

	public List<ContentVO>getContentAreaList(String areaname);
	
	public int insertTravelContent(TravelContentVO vo);
	
	public List<ContentVO>getListContent(int plan_id);
	
	public int deleteContent(int tContent_id);
}

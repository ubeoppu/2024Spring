package kr.trip.mapper;

import java.util.List;

import kr.trip.domain.AreaVO;
import kr.trip.domain.ContentVO;
import kr.trip.domain.TravelContentVO;

public interface PlanMapper {

	public List<ContentVO>getContentAreaList(String areaname);
	
	public int insertTravelContent(TravelContentVO vo);
	
	
	public int deleteContent(int tContent_id);
	
	public int deleteContentAll(int plan_id);
	
	public AreaVO getAreaContent(String areaname);
}

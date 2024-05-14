package kr.trip.mapper;

import java.util.List;

import kr.trip.domain.ContentVO;

public interface PlanMapper {

	public List<ContentVO>getContentAreaList(String areaname);
}

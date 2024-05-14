package kr.trip.service;

import java.util.List;

import kr.trip.domain.ContentVO;

public interface PlanService {
	public List<ContentVO>getContentAreaList(String areaname);

}

package kr.trip.service;

import java.util.List;

import kr.trip.domain.Criteria;
import kr.trip.domain.HelpVO;

public interface HelpService {
	
	//Paging
	public List<HelpVO> getListWithPaging(Criteria cri);
	//List
	public List<HelpVO> getListHelp();
	//C
	public boolean insertHelp(HelpVO vo);
	//R
	public HelpVO readHelp(int help_id);
	//U
	public boolean updateHelp(HelpVO vo);
	//D
	public boolean deleteHelp(int help_id);

}

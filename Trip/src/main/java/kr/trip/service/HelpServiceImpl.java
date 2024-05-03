package kr.trip.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.trip.domain.Criteria;
import kr.trip.domain.HelpVO;
import kr.trip.mapper.HelpMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@RequiredArgsConstructor
@Log4j
public class HelpServiceImpl implements HelpService{

	//생성자 주입
	private final HelpMapper helpmapper;

	@Override
	public List<HelpVO> getListWithPaging(Criteria cri){
		
		int pageNum = cri.getPageNum();
		
		if(pageNum <= 0) {
			
			pageNum = 1;
		}
		pageNum = (pageNum - 1) * 10;
		
		cri.setPageNum(pageNum);
		
		return helpmapper.getListWithPaging(cri);
	}

	@Override
	public List<HelpVO> getListHelp() {
		return helpmapper.getListHelp();
	}

	@Override
	public boolean insertHelp(HelpVO vo) {
		return   helpmapper.insertHelp(vo) == 1;
	}

	@Override
	public HelpVO readHelp(int help_id) {
		return helpmapper.readHelp(help_id);
	}

	@Override
	public boolean updateHelp(HelpVO vo) {
		return helpmapper.updateHelp(vo) == 1;
	}

	@Override
	public boolean deleteHelp(int help_id) {
		return helpmapper.deleteHelp(help_id) == 1;
	} 
}

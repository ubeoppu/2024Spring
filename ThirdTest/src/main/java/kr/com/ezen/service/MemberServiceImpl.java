package kr.com.ezen.service;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.com.ezen.dto.MemberVO;
import kr.com.ezen.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@RequiredArgsConstructor

public class MemberServiceImpl implements MemberService{

	private final MemberMapper mapper;
	
	@Override
	public int insertMember1(MemberVO vo) {
		mapper.insertMember(vo);
		
		return 0;
	}

	@Override
	public List<MemberVO> selectAllMember() {
		mapper.selectMemberList();
		
		return null;
	}

}

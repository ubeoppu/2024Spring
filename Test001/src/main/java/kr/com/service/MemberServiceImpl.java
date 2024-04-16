package kr.com.service;

import org.springframework.stereotype.Service;

import kr.com.domain.MemberVO;
import kr.com.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@RequiredArgsConstructor
@Log4j

public class MemberServiceImpl implements MemberService{

   //생성자 주입	
	private final MemberMapper mapper;
	
	@Override
	public void registerMember(MemberVO vo) {
		log.info("registerMemberService...");
        mapper.insertMember(vo);
	}

	@Override
	public boolean removeMember(String userId) {
		log.info("removeMemberService...");
		
		return mapper.deleteMember(userId) == 1;
	}

}

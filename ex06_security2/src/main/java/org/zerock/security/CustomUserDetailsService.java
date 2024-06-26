package org.zerock.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.zerock.domain.MemberVO;
import org.zerock.mapper.MemberMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
//@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService{  //사용자 정보를 담는 인터페이스를 구현하는 클래스.
	
	@Autowired
	private MemberMapper mapper;
	
	@Override	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		log.info("------------------------------------------");
		log.info(username);	
		log.info("------------------------------------------");
		
		MemberVO vo = mapper.read(username);
		
		log.info(vo);
		
		return vo;
	}

}
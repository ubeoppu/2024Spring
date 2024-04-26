package kr.com.dao;

import org.apache.ibatis.session.SqlSession;

import kr.com.domain.MemberVO;

public class MemberDAOImpl implements MemberDAO{

	private SqlSession session;
	private static String namespace = "kr.com.mapper.MemberMapper.";
	
	@Override
	public int updateMailKey(MemberVO MemberVO) throws Exception {
		 return session.update(namespace + "updateMailAuth", MemberVO);
	}

	@Override
	public int updateMailAuth(MemberVO MemberVO) throws Exception {
		return session.update(namespace + "updateMailAuth", MemberVO);
	}

	@Override
	public int emailAuthFail(String id) throws Exception {
		return session.selectOne(namespace + "emailAuthFail", id);
	}

}

package kr.com.dao;

import kr.com.domain.MemberVO;

public interface MemberDAO {

    int updateMailKey(MemberVO MemberVO) throws Exception;
    int updateMailAuth(MemberVO memberVO) throws Exception;
    int emailAuthFail(String id) throws Exception;
}

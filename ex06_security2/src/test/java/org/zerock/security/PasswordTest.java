package org.zerock.security;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.AuthVO;
import org.zerock.domain.MemberVO;
import org.zerock.mapper.MemberMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	                   "file:src/main/webapp/WEB-INF/spring/security-context.xml"})
@Log4j
public class PasswordTest {
	
	@Autowired
	private BCryptPasswordEncoder pwEncoder;
	
	@Autowired
	private MemberMapper memberMapper;
	
	/*
	 * @Autowired private DataSource source;
	 */
	
	
	@Test
	public void testInsertMember() {
		for(int i = 1; i <= 100; i++) {
			
			MemberVO memberVO = new MemberVO();
			
			memberVO.setUserid("user" + i);
			memberVO.setUserpw(pwEncoder.encode("1111"));
			memberVO.setName("USER" + i);
			
			List<AuthVO>authList = new ArrayList<AuthVO>();
			
			AuthVO userAuth = new AuthVO("user" + i, "ROLE_USER");
			authList.add(userAuth);
			
			if(i > 50) {
				AuthVO managerAuth = new AuthVO("user" + i , "ROLE_MEMBER");
				authList.add(managerAuth);
			}
			if(i > 90) {
				AuthVO adminAuth = new AuthVO("user" + i , "ROLE_ADMIN");
				authList.add(adminAuth);
			}
			
			memberVO.setAuthList(authList);
			
			memberMapper.insert(memberVO);
			
			authList.stream().forEach(authVO ->{
				memberMapper.insertAuth(authVO);
			});
		}
	}
	
	@Test
	public void testRead() {
		MemberVO vo = memberMapper.read("user99");
		log.info(vo);
	}
	
	@Test
	public void testInsertMember2() {
		String sql = "insert into tbl_member(userid,userpw, username) values (?,?,?)";
		
		for(int i =0; i < 100; i ++) {
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
			
				pstmt.setString(2, pwEncoder.encode("pw" + i));
				
				if(i < 80) {
					pstmt.setString(1, "user" + i);
					pstmt.setString(3, "username" + i);
				
				}else if(i < 90) {
					pstmt.setString(1, "manager" + i);
					pstmt.setString(3, "운영자" + i);
				}else {
					pstmt.setString(1, "admin" + i);
					pstmt.setString(1, "admin" + i);
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(pstmt != null) pstmt.close();
					if(con != null)con.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@Test
	public void testPassword() {
		log.info(pwEncoder);
		
		String str = "12345";
		
		String encodeStr = pwEncoder.encode(str);
		
		log.info("-------------------------------------");
		log.info(encodeStr);
		log.info("-------------------------------------");
		
		boolean match =pwEncoder.matches("$2a$10$UGfrxEy.p.5N0DyoPuXEj.gv.j/1pyFL6lgoaQPldu2wFuK661MPS", encodeStr);
		log.info("-------------------------------------");
		log.info(match);
		log.info("-------------------------------------");
	}

}

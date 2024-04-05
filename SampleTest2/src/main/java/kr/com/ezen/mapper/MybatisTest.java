package kr.com.ezen.mapper;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MybatisTest {
	
	@Autowired
	private SqlSessionFactory sessionFactory;
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Test
	public void testConnection() {
		
		SqlSession session = sessionFactory.openSession();
		log.info("session:" + session);
	}
	
	@Test
	public void testGetTime() {
		
		log.info(memberMapper.getTime());
		
	}
	
	@Test
	public void testGetTime2() {
		
		log.info(memberMapper.getTime2());
	}

}

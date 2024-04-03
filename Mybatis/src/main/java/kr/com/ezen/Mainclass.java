package kr.com.ezen;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Mainclass {

	public static void main(String[] args) {
		
		String resource = "kr/com/ezen/mybatis-config.xml";
		
		try {
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession session = sqlSessionFactory.openSession(true);
		
		MapperInterface mapper = session.getMapper(MapperInterface.class);
		
		MemberVO vo = new MemberVO();
		
		vo.setId(5);
		vo.setName("임재현");
		vo.setPhone("010-2478-1234");
		vo.setAddress("경기도 비밀");
		
//		mapper.updateMember(vo);
		
//		mapper.deleteMember(1);
//		
//		int result = mapper.insertMember(vo);
//		System.out.println("성공이면 " + result);
		
//		vo = mapper.selectMemberOne(1);
		
		List<MemberVO>list = new ArrayList<MemberVO>();
		
		list = mapper.selectMemberList();
		
		for(MemberVO mVo : list) { //대입받을 변수 : 배열
			System.out.println(mVo);
		}
			
		}catch(Exception e) {
		e.printStackTrace();	
		}
	}

}

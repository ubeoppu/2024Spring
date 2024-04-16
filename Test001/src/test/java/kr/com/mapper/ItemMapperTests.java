package kr.com.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.com.domain.ItemVO;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ItemMapperTests {
	
	@Autowired
	private ItemMapper mapper;

	@Test
	public void insertItemTest() {
		log.info("test...insert Item");
		ItemVO vo = ItemVO.builder()
				.iname("짜장면 밀키트")
				.ex("이연복 쉐프가 직접 개발한 짜장면 밀키트")
				.price(9000)
				.inventory(40)
				.build();
		
		mapper.insertItem(vo);
		
		log.info(vo);
	}
	
	@Test
	public void deleteItemTest() {
		log.info("test...delete Item");
		
		int ino = 1;
		
		mapper.deleteItem(ino);

	}
}

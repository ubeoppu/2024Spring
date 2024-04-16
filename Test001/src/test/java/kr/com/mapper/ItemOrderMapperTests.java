package kr.com.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.com.domain.ItemOrderVO;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ItemOrderMapperTests {
	
	@Autowired
	private ItemOrderMapper mapper;
	
	@Test
	public void insertItemOrderTest() {
		log.info("test...itemOrderInsert");
		
		ItemOrderVO vo = ItemOrderVO.builder()
				.userId("gudwn3477")
				.ino(3)
				.quantity(1)
				.build();
		mapper.insertItemOrder(vo);
	}
	
	@Test
	public void deleteItemOrderTest() {
		log.info("test...itemOrderDelete");
		
		int ono = 2;
		mapper.deleteItemOrder(ono);
	}

}

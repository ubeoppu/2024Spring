package kr.com.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.com.dto.EquipmentVO;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j

public class EquipmentMapperTests {
	
	//필드 주입
	@Autowired
	private EquipmentMapper mapper;
	
	@Test
	public void InsertEquipment() {
		EquipmentVO vo = EquipmentVO.builder()
				.EquipmentCode(1)
				.EquipmentName("K77")
				.MechanicName("김성준")
				.build();
		int result = mapper.InsertEquipment(vo);
		log.info("--------------------");
		log.info(vo);
		log.info(result);
		log.info("--------------------");
		
	}
	
	@Test
	public void SelectOneByCodeEquipment() {
		int EquipmentCode = 1;
		
		EquipmentVO vo = mapper.SelectOneByCodeEquipment(EquipmentCode);
		
		log.info(vo);
		
		
	}
}

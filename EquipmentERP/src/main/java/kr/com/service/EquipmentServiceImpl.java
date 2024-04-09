package kr.com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kr.com.dto.EquipmentVO;
import kr.com.mapper.EquipmentMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EquipmentServiceImpl implements EquipmentService{
	
	//생성자 주입
	private final EquipmentMapper mapper;

	@Override
	public int InsertEquipment(EquipmentVO vo) {
		int result = mapper.InsertEquipment(vo);
		return result;
	}

	@Override
	public EquipmentVO SelectOneByCodeEquipment(int EquipmentCode) {
		return mapper.SelectOneByCodeEquipment(EquipmentCode);
	}

	@Override
	public List<EquipmentVO> SelectEquipmentList() {
		List<EquipmentVO>list = new ArrayList<EquipmentVO>();
		list = mapper.SelectEquipmentList();
		return list;
	}

	@Override
	public boolean UpdateEquipment(EquipmentVO vo) {
		return mapper.UpdateEquipment(vo);
	}

	@Override
	public boolean DeleteEquipment(int EquipmentCode) {
		return mapper.DeleteEquipment(EquipmentCode);
	}

}

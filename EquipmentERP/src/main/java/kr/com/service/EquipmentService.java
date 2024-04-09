package kr.com.service;

import java.util.List;

import kr.com.dto.EquipmentVO;

public interface EquipmentService {
	
	public int InsertEquipment(EquipmentVO vo);
	
	public EquipmentVO SelectOneByCodeEquipment(int EquipmentCode);
	
	public List<EquipmentVO>SelectEquipmentList();
	
	public boolean UpdateEquipment(EquipmentVO vo);
	
	public boolean DeleteEquipment(int EquipmentCode);
}

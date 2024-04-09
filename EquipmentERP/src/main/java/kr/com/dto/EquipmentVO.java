package kr.com.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/*
CREATE TABLE Equipment(
EquipmentCode Number(10) primary key,
EquipmentName varchar2(90),
mechanicName varchar2(12)
);
*/

@AllArgsConstructor
@Data
@Builder
public class EquipmentVO {
	
	private int EquipmentCode;
	private String EquipmentName;
	private String MechanicName;
}

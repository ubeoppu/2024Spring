package kr.com.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

//CREATE TABLE ITEM(
//INO NUMBER(20) NOT NULL PRIMARY KEY,
//INAME VARCHAR(50) NOT NULL,
//EX VARCHAR(500) NOT NULL,
//PRICE NUMBER(10) NOT NULL,
//INVENTORY NUMBER(10)
//);
@Data
@Builder
@AllArgsConstructor

public class ItemVO {
	
	private int ino;
	private String iname;
	private String ex;
	private int price;
	private int inventory;
}

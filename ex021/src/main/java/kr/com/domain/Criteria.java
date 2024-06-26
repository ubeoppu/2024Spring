package kr.com.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Criteria {
	
	private int pageNum; //몇개의 페이지로 구성
	private int amount; //양

	private String  type;
	private String keyword;
	
	public Criteria() {
		this(1, 10);
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	public String[]getTypeArr(){
		return type == null ? new String[] {} : type.split("");
	}
}

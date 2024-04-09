package kr.com.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class BoardDTO {
	
	
	private String name;
	private String title;
	private String content;

}

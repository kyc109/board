package kr.co.don.common.dto;

import lombok.Data;

@Data
public class ResponseDTO {

	public int code = 1;
	public String msg = "정상적으로 성공하였습니다.";
	
}

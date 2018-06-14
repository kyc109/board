package kr.co.don.board.dto;

import java.util.Date;

import lombok.Data;

@Data
public class BoardLikeDTO {

	private Integer likeId=null;
	private Integer docId=null;
	private Integer userId=null;
	
	private String likeYn=null;
	
	private Date regDt=null;
}

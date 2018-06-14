package kr.co.don.board.dto;

import java.util.Date;

import lombok.Data;

@Data
public class BoardCommentDTO {

	private Integer commentId = null; 
	private Integer docId = null;
	private Integer userId = null;

	
	private String name = null;
	private String comments = null;
	
	private Date regDt = null;
	
}

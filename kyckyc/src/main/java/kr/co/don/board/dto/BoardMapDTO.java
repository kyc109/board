package kr.co.don.board.dto;

import java.util.Date;

import lombok.Data;

@Data
public class BoardMapDTO {

	private Integer mapId = null;
	private Integer mapSort = null;
	private Integer parMapId = null;
	
	private String mapName = null;
	private String mapType = null;
	private String delYn = null;
	private String commentYn = null;
	private String fileYn = null;
	
	private Date regDt = null;
	
	
}

package kr.co.don.board.dto;

import kr.co.don.common.dto.PageDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BoardSearchDTO extends PageDTO {

	private Integer docId = null;
	private Integer mapId = null;
	private Integer userId = null;
	
	
	private String searchType = null;
	private String searchText = null;
	
	public String getParams() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("mapId="+this.mapId);
		sb.append("&searchType="+this.searchType);
		sb.append("&searchText="+this.searchText);
		sb.append("&page="+this.page);
		
		return sb.toString();
		
	}
}

package kr.co.don.board.dto;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class PopupDTO {
	private Integer popupId = 0; //팝업 고유키
	
	private String title = null;	//제목
	private String useYn = null;	//사용여부
	
	private Date regDate=null;		//등록일
	
	private List<MultipartFile> files = null;  	// 첨부파일
	
	private List<PopupFileDTO> fileList = null;
	
	private List<Integer> delfiles = null; // 삭제할 첨부파일 sno
	
}

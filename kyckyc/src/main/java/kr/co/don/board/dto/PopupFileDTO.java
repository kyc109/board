package kr.co.don.board.dto;

import java.util.Date;

import lombok.Data;

@Data
public class PopupFileDTO {

	private Integer popupFileId=null;	//NUMBER(8,0)	파일 고유키
	private Integer popupId=0;;	//NUMBER(8,0)	팝업 고유키
	private long fileSize=0;	//NUMBER	파일 크기
	
	private String orgFileName=null;	//VARCHAR2(300 BYTE)	실제 파일 이름
	private String newFileName=null;	//VARCHAR2(300 BYTE)	가짜 파일 이름
	private String fileType=null;	//VARCHAR2(1 BYTE)	파일 타입
	private String filePath=null;	//VARCHAR2(100 BYTE)	파일 경로
	private String ext=null;	//VARCHAR2(5 BYTE)	파일 확장자
	
	private Date regDate = null;	//DATE	등록일
}

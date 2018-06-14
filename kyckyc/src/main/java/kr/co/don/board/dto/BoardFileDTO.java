package kr.co.don.board.dto;

import java.util.Date;

import lombok.Data;

@Data
public class BoardFileDTO {

	
//	DOC_ID			NUMBER(8,0)			No					1	�Խù�ID
//	FILE_SNO		NUMBER(2,0)			No					2	÷������_SNO
//	ORG_FILE_NAME	VARCHAR2(100 BYTE)	No					3	ORG_���ϸ�
//	NEW_FILE_NAME	VARCHAR2(100 BYTE)	No					4	NEW_���ϸ�
//	FILE_TYPE		VARCHAR2(10 BYTE)	Yes					5	����Ÿ��
//	FILE_SIZE		NUMBER				No					6	����ũ��
//	FILE_PATH		VARCHAR2(100 BYTE)	No					7	���ϰ��
//	FILE_EXT		VARCHAR2(10 BYTE)	Yes					8	Ȯ����
//	REG_DT			DATE				No		SYSDATE 	9	�����
	
	
	private long fileSize = 0;
	
	private Integer docId = null;
	private Integer fileSno = null;
	
	private String orgFileName = null;
	private String newFileName = null;
	private String fileType = null;
	private String filePath = null;
	private String fileExt = null;
	
	private Date	regDt = null;
	
	
	
}

package kr.co.don.board.dto;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kr.co.don.user.dto.UserDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BoardDocDTO extends UserDTO {
	private Integer cntRead = 0; //조회수
	private int cntFile=0; 		//파일수
	private String comments = null; //댓글수
	

	private Integer docId = null;             	// pk
	private Integer userId = null;
	private Integer mapId = null;
	private	Integer likeId=null;
	private Integer viewerId = null;
	
	private String mapName = null;
	private String title = null;				// 제목
	private String boardContents = null;		// 내용
	private String userName = null;             // 글 작성자 리스트에서 보기 필요
	private String likeYn=null;
	
	private List<MultipartFile> files = null;  	// 첨부파일

	private List<BoardFileDTO> fileList = null; // 첨부파일 목록
	
	private List<Integer> delfiles = null; // 삭제할 첨부파일 sno
	
	private Date regDt = null;
	
	
	
	
	
}

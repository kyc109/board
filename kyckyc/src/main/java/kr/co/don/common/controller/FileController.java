package kr.co.don.common.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.don.board.dto.BoardFileDTO;
import kr.co.don.board.service.IBoardFileService;
import kr.co.don.common.file.FileService;

@Controller
@RequestMapping("/file")
public class FileController {
	
	@Autowired private FileService fileService = null;
	@Autowired private IBoardFileService boardFileServiceImpl = null;
	
	
	@RequestMapping(value="/downloadFile.java6", method=RequestMethod.GET)
	public void downloadFile(HttpServletResponse response, HttpSession session, BoardFileDTO boardFileDTO) {
		
		
		BoardFileDTO fileDTO = new BoardFileDTO();  
		
		fileDTO = boardFileServiceImpl.view(boardFileDTO);
//		fileDTO.getDocId();
//		fileDTO.getFileSno();
//		
		fileService.downloadFile(response, session, fileDTO);
	}
}

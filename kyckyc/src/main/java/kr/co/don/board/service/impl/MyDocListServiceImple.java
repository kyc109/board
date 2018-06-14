package kr.co.don.board.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import kr.co.don.board.dao.IMyDocListDAO;
import kr.co.don.board.dto.BoardDocDTO;
import kr.co.don.board.dto.BoardFileDTO;
import kr.co.don.board.dto.BoardSearchDTO;

import kr.co.don.board.service.IBoardCommentService;
import kr.co.don.board.service.IBoardFileService;
import kr.co.don.board.service.IMyDocListService;
import kr.co.don.common.file.FileService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MyDocListServiceImple implements IMyDocListService {

	@Autowired private IMyDocListDAO myListDocDAOImpl=null;
	@Autowired private IBoardFileService boardFileServiceImpl = null;
	@Autowired private FileService fileService = null;
	@Autowired private IBoardCommentService boardCommentServiceImpl=null;
	
	@Override
	public List<BoardDocDTO> list(BoardSearchDTO search) {
		//총 게시물 개수
		int total = myListDocDAOImpl.selectCount(search);
		search.setTotal(total);
		
		//게시물 목록 가져오기
		List<BoardDocDTO> list = myListDocDAOImpl.selectList(search);
		
		for(BoardDocDTO docDTO : list) {
			//첨부파일 갯수가 0 이상 일떄만 첨부파일 목록을 가져온다
			if(docDTO.getCntFile() > 0) {
				// 3. 첨부파일 가져오기
				List<BoardFileDTO> fileList = boardFileServiceImpl.list(docDTO.getDocId());
				docDTO.setFileList(fileList);
			}
		}
		
		return list;
	}

	@Override
	public List<BoardDocDTO> listComment(Integer userId) {
		
		return myListDocDAOImpl.selectCommentList(userId);
	}
	

}
	


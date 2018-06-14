package kr.co.don.board.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import kr.co.don.board.dao.IBoardDocDAO;
import kr.co.don.board.dto.BoardDocDTO;
import kr.co.don.board.dto.BoardFileDTO;
import kr.co.don.board.dto.BoardSearchDTO;
import kr.co.don.board.service.IBoardCommentService;
import kr.co.don.board.service.IBoardDocService;
import kr.co.don.board.service.IBoardFileService;
import kr.co.don.board.service.IBoardLikeService;
import kr.co.don.common.file.FileService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardDocServiceImpl implements IBoardDocService {

	@Autowired private IBoardDocDAO boardDocDAOImpl = null;
	@Autowired private IBoardFileService boardFileServiceImpl = null;
	@Autowired private FileService fileService = null;
	@Autowired private IBoardCommentService boardCommentServiceImpl=null;
	@Autowired private IBoardLikeService boardLikeServiceImpl=null;
	
	@Override
	public List<BoardDocDTO> list(BoardSearchDTO search) {
		// 총 게시물 개수
		int total = boardDocDAOImpl.selectCount(search);
		search.setTotal(total);
		
		
		
		//게시물 목록 가져오기
		List<BoardDocDTO> list= boardDocDAOImpl.selectList(search);
			
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
	@Transactional
	public void writeData(BoardDocDTO boardDocDTO, HttpSession session) {
		// 1. 게시물 저장
		boardDocDAOImpl.insertData(boardDocDTO);
		List<MultipartFile> fileList = boardDocDTO.getFiles();
		BoardFileDTO boardFileDTO = null;
		
		// 2. 첨부파일 디스크에 저장
		
		if(fileList != null) {
			for (MultipartFile file : boardDocDTO.getFiles()) {
				log.debug("파일 이름 =============>" + file.getOriginalFilename());
				log.debug("파일 크기 =============>" + file.getSize());
			
				boardFileDTO = fileService.uploadSingleFile(file, session);
				
				// 3. 첨부파일 디비에 insert
				boardFileDTO.setDocId(boardDocDTO.getDocId());
				boardFileServiceImpl.write(boardFileDTO);
			}
			
		}
		
	}

	@Override
	@Transactional
	public BoardDocDTO view(BoardDocDTO _boardDocDTO) {
		// 1. 조회수 증가
		
		boardDocDAOImpl.updateCntRead(_boardDocDTO.getDocId());// 위 아래 둘다 써도 무상관
		
		// 2. 조회
		BoardDocDTO boardDocDTO = boardDocDAOImpl.selectData(_boardDocDTO); 
		
		
		// 3. 첨부파일 가져오기
		List<BoardFileDTO> fileList = boardFileServiceImpl.list(_boardDocDTO.getDocId());
		boardDocDTO.setFileList(fileList);
		
		return boardDocDTO;		
	}

	@Override
	public void editCntRead(int docId) {
		
		boardDocDAOImpl.updateCntRead(docId);		
	}

	@Override
	@Transactional
	public void editData(BoardDocDTO boardDocDTO, HttpSession session) {
		//1.첨부파일 등록
		BoardFileDTO boardFileDTO = null;
		if(boardDocDTO.getFiles() != null) {
			//3.수정
			for (MultipartFile file : boardDocDTO.getFiles()) {
				log.debug("파일 이름 =============>" + file.getOriginalFilename());
				log.debug("파일 크기 =============>" + file.getSize());
				
				// 2. 첨부파일 디스크에 저장
				boardFileDTO = fileService.uploadSingleFile(file, session);
				
				// 3. 첨부파일 디비에 insert
				boardFileDTO.setDocId(boardDocDTO.getDocId());
				boardFileServiceImpl.write(boardFileDTO);
			}
		}
		//2.삭제
		if( boardDocDTO.getDelfiles() != null) {
			for(Integer fileSno : boardDocDTO.getDelfiles()) {
				boardFileServiceImpl.remove(fileSno);
				log.debug("SNO=====>"+fileSno);
				
			
			}
			boardDocDAOImpl.updateData(boardDocDTO);
		}
	}
	
	//파일삭제
	@Override
	@Transactional
	public void remove(Integer docId) {
		// TODO Auto-generated method stub
		//1.첨부파일
		boardFileServiceImpl.removeComment(docId);
		//2.댓글
		boardCommentServiceImpl.remove(docId);
		//좋아요
		boardLikeServiceImpl.remove(docId);
		
		//4.게시물
		boardDocDAOImpl.deleteData(docId);
		
	}

				
}

package kr.co.don.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.don.board.dao.IBoardFileDAO;
import kr.co.don.board.dto.BoardFileDTO;
import kr.co.don.board.service.IBoardFileService;

@Service
public class BoardFileServiceImpl implements IBoardFileService{

	@Autowired
	IBoardFileDAO boardFileDAO = null;
	
	@Override
	public void write(BoardFileDTO boardFileDTO) {
		boardFileDAO.insertData(boardFileDTO);
	}

	@Override
	public void remove(Integer fileSno) {
		boardFileDAO.delete(fileSno);
	}

	@Override
	public BoardFileDTO view(BoardFileDTO boardFileDTO) {
		return boardFileDAO.select(boardFileDTO);
	}

	@Override
	public List<BoardFileDTO> list(Integer docId) {
		return boardFileDAO.selectList(docId);
	}

	@Override
	public BoardFileDTO viewByDocId(Integer docId) {
		return boardFileDAO.selectByDocId(docId);
	}

	@Override
	public BoardFileDTO viewByFileSno(Integer fileSno) {
		return boardFileDAO.selectByFileSno(fileSno);
	}

	@Override
	public void removeComment(Integer docId) {
		// TODO Auto-generated method stub
		boardFileDAO.deleteComment(docId);
	}

	
	
	
}

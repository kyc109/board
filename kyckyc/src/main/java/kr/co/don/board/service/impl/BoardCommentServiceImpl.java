package kr.co.don.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.don.board.dao.IBoardCommentDAO;
import kr.co.don.board.dto.BoardCommentDTO;
import kr.co.don.board.service.IBoardCommentService;

@Service
public class BoardCommentServiceImpl implements IBoardCommentService {

	@Autowired
	private IBoardCommentDAO boardCommentDAOImpl = null;
	
		
	@Override
	public void writeComment(BoardCommentDTO boardCommentDTO) {
		boardCommentDAOImpl.insertComment(boardCommentDTO);
	}

	@Override
	public void removeComment(int commentId) {
		boardCommentDAOImpl.deleteComment(commentId);
	}

	@Override
	public List<BoardCommentDTO> viewComment(Integer docId) {
		return boardCommentDAOImpl.selectList(docId);
	}

	@Override
	public void remove(Integer docId) {
		// TODO Auto-generated method stub
		boardCommentDAOImpl.deleteId(docId);
	}

}

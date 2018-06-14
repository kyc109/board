package kr.co.don.board.dao;

import java.util.List;

import kr.co.don.board.dto.BoardCommentDTO;

public interface IBoardCommentDAO {

	public List<BoardCommentDTO> selectList(Integer docId);
	
	public void insertComment(BoardCommentDTO boardCommentDTO);
	
	public void deleteComment(int commentId);
	
	public void deleteId(Integer docId);
}

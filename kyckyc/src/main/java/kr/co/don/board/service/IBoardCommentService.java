package kr.co.don.board.service;

import java.util.List;

import kr.co.don.board.dto.BoardCommentDTO;

public interface IBoardCommentService {

	public void writeComment(BoardCommentDTO boardCommentDTO);
	
	public void removeComment(int commentId);
	
	public List<BoardCommentDTO> viewComment(Integer docId);
	
	public void remove(Integer docId);
}

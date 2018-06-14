package kr.co.don.board.service;

import kr.co.don.board.dto.BoardLikeDTO;

public interface IBoardLikeService {
	
	public void write(BoardLikeDTO boardLikeDTO);
	
	public void remove(Integer docId);
}

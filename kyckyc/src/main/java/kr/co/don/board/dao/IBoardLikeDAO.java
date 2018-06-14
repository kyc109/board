package kr.co.don.board.dao;

import kr.co.don.board.dto.BoardLikeDTO;

public interface IBoardLikeDAO {

	public void insertData(BoardLikeDTO boardLikeDTO);
	
	public void deleteDate(Integer docId);
}

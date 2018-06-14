package kr.co.don.board.dao;

import java.util.List;

import kr.co.don.board.dto.BoardMapDTO;

public interface IBoardMapDAO {

	public void insertData(BoardMapDTO boardMapDTO);
	
	public List<BoardMapDTO> selectList();
	
	public BoardMapDTO selectOne(Integer mapId);
	
}

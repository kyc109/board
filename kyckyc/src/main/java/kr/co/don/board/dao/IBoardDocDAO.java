package kr.co.don.board.dao;

import java.util.List;

import kr.co.don.board.dto.BoardDocDTO;
import kr.co.don.board.dto.BoardSearchDTO;

public interface IBoardDocDAO {

	
	
	public List<BoardDocDTO> selectList(BoardSearchDTO search);
	public int selectCount(BoardSearchDTO search);
	public void insertData(BoardDocDTO boardDocDTO);
	public BoardDocDTO selectData(BoardDocDTO boardDocDTO);

	public void updateCntRead(int docId);
	
	public void updateData(BoardDocDTO boardDocDTO);
	
	public void deleteData(Integer docId);
}

package kr.co.don.board.dao;

import java.util.List;

import kr.co.don.board.dto.BoardFileDTO;

public interface IBoardFileDAO {
	
	public void insertData(BoardFileDTO boardFileDTO);
	
	public void delete(Integer fileSno);
	
	public BoardFileDTO select(BoardFileDTO boardFileDTO);
	
	public List<BoardFileDTO> selectList(Integer docId);
	
	public BoardFileDTO selectByDocId(Integer docId);
	
	public BoardFileDTO selectByFileSno(Integer fileSno);
	
	public void deleteComment(Integer docId);
}

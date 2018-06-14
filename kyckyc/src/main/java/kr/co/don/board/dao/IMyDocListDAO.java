package kr.co.don.board.dao;

import java.util.List;

import kr.co.don.board.dto.BoardDocDTO;
import kr.co.don.board.dto.BoardSearchDTO;


public interface IMyDocListDAO {

	public List<BoardDocDTO> selectList(BoardSearchDTO search);
	
	public int selectCount(BoardSearchDTO search);
	
	public List<BoardDocDTO> selectCommentList(Integer userId);
}

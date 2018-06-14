package kr.co.don.board.service;

import java.util.List;

import kr.co.don.board.dto.BoardDocDTO;
import kr.co.don.board.dto.BoardSearchDTO;


public interface IMyDocListService {

	public List<BoardDocDTO> list(BoardSearchDTO search);
	
	public List<BoardDocDTO> listComment(Integer userId);
}

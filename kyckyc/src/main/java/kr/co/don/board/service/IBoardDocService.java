package kr.co.don.board.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import kr.co.don.board.dto.BoardDocDTO;
import kr.co.don.board.dto.BoardSearchDTO;

public interface IBoardDocService {

	public List<BoardDocDTO> list(BoardSearchDTO search);
	
	public void writeData(BoardDocDTO boardDocDTO, HttpSession session);
	
	public BoardDocDTO view(BoardDocDTO boardDocDTO);

	public void editCntRead(int docId);
	
	public void editData(BoardDocDTO boardDocDTO, HttpSession session);
	
	public void remove(Integer docId);
	
}

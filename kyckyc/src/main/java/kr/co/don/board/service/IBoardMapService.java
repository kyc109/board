package kr.co.don.board.service;

import java.util.List;

import kr.co.don.board.dto.BoardMapDTO;

public interface IBoardMapService {

	public void write(BoardMapDTO boardMapDTO);

	public List<BoardMapDTO> list();
	
	public BoardMapDTO view(Integer mapId);
	
}

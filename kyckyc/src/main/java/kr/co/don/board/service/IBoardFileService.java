package kr.co.don.board.service;

import java.util.List;

import kr.co.don.board.dto.BoardFileDTO;

public interface IBoardFileService {
	
	public void write(BoardFileDTO boardFileDTO);
	
	public void remove(Integer fileSno);
	
	public BoardFileDTO view(BoardFileDTO boardFileDTO);
	
	public List<BoardFileDTO> list(Integer docId);
	
	public BoardFileDTO viewByDocId(Integer docId);
	
	public BoardFileDTO viewByFileSno(Integer fileSno);
	
	public void removeComment(Integer docId);
}

		
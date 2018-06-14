package kr.co.don.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.don.board.dao.IBoardMapDAO;
import kr.co.don.board.dto.BoardMapDTO;
import kr.co.don.board.service.IBoardMapService;

@Service
public class BoardMapServiceImpl implements IBoardMapService {

	@Autowired
	private IBoardMapDAO boardMapDAOImpl = null;
	
	@Override
	public void write(BoardMapDTO boardMapDTO) {
		boardMapDAOImpl.insertData(boardMapDTO);
	}

	@Override
	public List<BoardMapDTO> list() {
		return boardMapDAOImpl.selectList();
	}

	@Override
	public BoardMapDTO view(Integer mapId) {
		return boardMapDAOImpl.selectOne(mapId);
	}

	

	

}

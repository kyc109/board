package kr.co.don.board.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.don.board.dao.IBoardMapDAO;
import kr.co.don.board.dto.BoardMapDTO;
import kr.co.don.common.dao.BaseDaoSupport;

@Repository
public class BoardMapDAOImpl extends BaseDaoSupport implements IBoardMapDAO {

	@Override
	public void insertData(BoardMapDTO boardMapDTO) {
		this.getSqlSession().insert("BoardMap.insertData", boardMapDTO);
	}

	@Override
	public List<BoardMapDTO> selectList() {
		return this.getSqlSession().selectList("BoardMap.selectList");
	}

	@Override
	public BoardMapDTO selectOne(Integer mapId) {
		return this.getSqlSession().selectOne("BoardMap.selectOne", mapId);
	}

	
	
}

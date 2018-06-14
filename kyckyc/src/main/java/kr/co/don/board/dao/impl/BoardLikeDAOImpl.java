package kr.co.don.board.dao.impl;

import org.springframework.stereotype.Repository;

import kr.co.don.board.dao.IBoardLikeDAO;
import kr.co.don.board.dto.BoardLikeDTO;
import kr.co.don.common.dao.BaseDaoSupport;

@Repository
public class BoardLikeDAOImpl extends BaseDaoSupport implements IBoardLikeDAO {

	@Override
	public void insertData(BoardLikeDTO boardLikeDTO) {
		// TODO Auto-generated method stub
		this.getSqlSession().insert("BoardLike.insertData", boardLikeDTO);
	}

	@Override
	public void deleteDate(Integer docId) {
		// TODO Auto-generated method stub
		this.getSqlSession().delete("BoardLike.deleteDate", docId);
	}

}

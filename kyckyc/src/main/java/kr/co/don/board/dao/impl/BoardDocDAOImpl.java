package kr.co.don.board.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.don.board.dao.IBoardDocDAO;
import kr.co.don.board.dto.BoardDocDTO;
import kr.co.don.board.dto.BoardSearchDTO;
import kr.co.don.common.dao.BaseDaoSupport;

@Repository
public class BoardDocDAOImpl extends BaseDaoSupport implements IBoardDocDAO {

	@Override
	public List<BoardDocDTO> selectList(BoardSearchDTO search) {
		return this.getSqlSession().selectList("BoardDoc.selectList", search);
	}

	@Override
	public void insertData(BoardDocDTO boardDocDTO) {
		this.getSqlSession().insert("BoardDoc.insertData", boardDocDTO);
	}

	@Override
	public int selectCount(BoardSearchDTO search) {
		return this.getSqlSession().selectOne("BoardDoc.selectCount", search);
	}

	@Override
	public BoardDocDTO selectData(BoardDocDTO boardDocDTO) {
		return this.getSqlSession().selectOne("BoardDoc.selectData", boardDocDTO);
	}

	@Override
	public void updateCntRead(int docId) {
		this.getSqlSession().update("BoardDoc.updateCntRead", docId);
	}

	@Override
	public void updateData(BoardDocDTO boardDocDTO) {
		this.getSqlSession().update("BoardDoc.updateData", boardDocDTO);
	}

	@Override
	public void deleteData(Integer docId) {
		// TODO Auto-generated method stub
		this.getSqlSession().delete("BoardDoc.deleteDate", docId);
	}

	
	
	

	

}

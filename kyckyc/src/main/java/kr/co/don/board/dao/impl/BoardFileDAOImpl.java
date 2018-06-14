package kr.co.don.board.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.don.board.dao.IBoardFileDAO;
import kr.co.don.board.dto.BoardFileDTO;
import kr.co.don.common.dao.BaseDaoSupport;

@Repository
public class BoardFileDAOImpl extends BaseDaoSupport implements IBoardFileDAO {

	@Override
	public void insertData(BoardFileDTO boardFileDTO) {
		this.getSqlSession().insert("BoardFile.insertData", boardFileDTO);
	}

	@Override
	public void delete(Integer fileSno) {
		this.getSqlSession().delete("BoardFile.delete", fileSno);
	}

	@Override
	public BoardFileDTO select(BoardFileDTO boardFileDTO) {
		return this.getSqlSession().selectOne("BoardFile.select", boardFileDTO);
	}

	@Override
	public List<BoardFileDTO> selectList(Integer docId) {
		return this.getSqlSession().selectList("BoardFile.selectList", docId);
		 
	}

	@Override
	public BoardFileDTO selectByDocId(Integer docId) {
		return this.getSqlSession().selectOne("BoardFile.selectByDocId", docId);
	}

	@Override
	public BoardFileDTO selectByFileSno(Integer fileSno) {
		return this.getSqlSession().selectOne("BoardFile.selectByFileSno", fileSno);
	}

	@Override
	public void deleteComment(Integer docId) {
		// TODO Auto-generated method stub
		this.getSqlSession().delete("BoardFile.deleteComment", docId);
	}

}

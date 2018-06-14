package kr.co.don.board.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.don.board.dao.IMyDocListDAO;
import kr.co.don.board.dto.BoardDocDTO;
import kr.co.don.board.dto.BoardSearchDTO;

import kr.co.don.common.dao.BaseDaoSupport;

@Repository
public class MyDocListDAOImpl extends BaseDaoSupport implements IMyDocListDAO {

	@Override
	public List<BoardDocDTO> selectList(BoardSearchDTO search) {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectList("MyDocList.selectList", search);
	}
	
	
	@Override
	public int selectCount(BoardSearchDTO search) {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectOne("MyDocList.selectCount", search);
	}


	@Override
	public List<BoardDocDTO> selectCommentList(Integer userId) {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectList("MyDocList.selectCommentList", userId);
	}


	

}

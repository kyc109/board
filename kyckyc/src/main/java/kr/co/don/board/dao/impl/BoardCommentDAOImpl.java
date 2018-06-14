package kr.co.don.board.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.don.board.dao.IBoardCommentDAO;
import kr.co.don.board.dto.BoardCommentDTO;
import kr.co.don.common.dao.BaseDaoSupport;

@Repository
public class BoardCommentDAOImpl extends BaseDaoSupport implements IBoardCommentDAO {

		
	@Override
	public void insertComment(BoardCommentDTO boardCommentDTO) {
		this.getSqlSession().insert("BoardComment.insertComment", boardCommentDTO);
	}

	@Override
	public void deleteComment(int commentId) {
		this.getSqlSession().delete("BoardComment.deleteComment", commentId);
	}

	@Override
	public List<BoardCommentDTO> selectList(Integer docId) {
		return this.getSqlSession().selectList("BoardComment.selectList", docId);
	}

	@Override
	public void deleteId(Integer docId) {
		// TODO Auto-generated method stub
		this.getSqlSession().delete("BoardComment.deleteId", docId);
	}

}

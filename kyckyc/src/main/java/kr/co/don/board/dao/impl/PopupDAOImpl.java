package kr.co.don.board.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.don.board.dao.IPopupDAO;
import kr.co.don.board.dto.BoardSearchDTO;
import kr.co.don.board.dto.PopupDTO;
import kr.co.don.common.dao.BaseDaoSupport;

@Repository
public class PopupDAOImpl extends BaseDaoSupport implements IPopupDAO {

	@Override
	public void insertData(PopupDTO popupDTO) {
		this.getSqlSession().insert("Popup.insertData", popupDTO);

	}

	@Override
	public List<PopupDTO> selectList() {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectList("Popup.selectList");
	}

	@Override
	public PopupDTO selectOne(PopupDTO popupDTO) {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectOne("Popup.selectOne", popupDTO.getPopupId());
	}

	@Override
	public void update(PopupDTO popupDTO) {
		// TODO Auto-generated method stub
		this.getSqlSession().update("Popup.update", popupDTO);
	}

	@Override
	public void delete(Integer popupId) {
		// TODO Auto-generated method stub
		this.getSqlSession().delete("Popup.delete", popupId);
	}

}

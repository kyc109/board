package kr.co.don.board.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.don.board.dao.IPopupFileDAO;
import kr.co.don.board.dto.PopupFileDTO;
import kr.co.don.common.dao.BaseDaoSupport;

@Repository
public class PopupFileDAOImpl  extends BaseDaoSupport  implements IPopupFileDAO {

	@Override
	public void insertData(PopupFileDTO popupFileDTO) {
		// TODO Auto-generated method stub
		this.getSqlSession().insert("PopupFile.insertData", popupFileDTO);
	}

	@Override
	public List<PopupFileDTO> selectList(Integer popupId) {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectList("PopupFile.selectList", popupId);
	}

	@Override
	public void delete(Integer popupId) {
		// TODO Auto-generated method stub
		this.getSqlSession().delete("PopupFile.delete", popupId);
	}

}

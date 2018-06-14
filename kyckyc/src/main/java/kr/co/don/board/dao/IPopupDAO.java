package kr.co.don.board.dao;

import java.util.List;


import kr.co.don.board.dto.PopupDTO;

public interface IPopupDAO {
	
	public void insertData(PopupDTO popupDTO);
	
	public List<PopupDTO> selectList();
	
	public PopupDTO selectOne(PopupDTO popupDTO);
	
	public void update(PopupDTO popupDTO);
	
	public void delete(Integer popupId);
}

package kr.co.don.board.dao;

import java.util.List;

import kr.co.don.board.dto.PopupFileDTO;

public interface IPopupFileDAO {
	
	public void insertData(PopupFileDTO popupFileDTO);
	
	public List<PopupFileDTO> selectList(Integer popupId);
	
	public void delete(Integer popupId);
}

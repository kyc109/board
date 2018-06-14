package kr.co.don.board.service;

import java.util.List;

import kr.co.don.board.dto.PopupFileDTO;

public interface IPopupFileService {
	
	public void write(PopupFileDTO popupFileDTO);
	
	public List<PopupFileDTO> list(Integer popupId);
	
	public void remove(Integer popupId);
}

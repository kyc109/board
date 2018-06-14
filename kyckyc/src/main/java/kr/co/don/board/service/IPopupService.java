package kr.co.don.board.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import kr.co.don.board.dto.PopupDTO;

public interface IPopupService {
	
	public void write(PopupDTO popupDTO,HttpSession session);
	
	public List<PopupDTO> list();
	
	public PopupDTO view(PopupDTO popupDTO);
	
	public void edit(PopupDTO popupDTO);
	
	public void remove(Integer popupId);
}

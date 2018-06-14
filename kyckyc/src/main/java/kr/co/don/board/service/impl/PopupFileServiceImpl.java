package kr.co.don.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.don.board.dao.IPopupFileDAO;
import kr.co.don.board.dto.PopupFileDTO;
import kr.co.don.board.service.IPopupFileService;

@Service
public class PopupFileServiceImpl implements IPopupFileService {

	@Autowired private IPopupFileDAO popupFileDAO = null; 
	
	@Override
	public void write(PopupFileDTO popupFileDTO) {
		// TODO Auto-generated method stub
		popupFileDAO.insertData(popupFileDTO);
	}

	@Override
	public List<PopupFileDTO> list(Integer popupId) {
		// TODO Auto-generated method stub
		return popupFileDAO.selectList(popupId);
	}

	@Override
	public void remove(Integer popupId) {
		// TODO Auto-generated method stub
		popupFileDAO.delete(popupId);
	}

}

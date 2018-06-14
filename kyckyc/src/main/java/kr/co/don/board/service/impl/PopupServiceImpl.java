package kr.co.don.board.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import kr.co.don.board.dao.IPopupDAO;
import kr.co.don.board.dto.BoardDocDTO;
import kr.co.don.board.dto.BoardFileDTO;
import kr.co.don.board.dto.PopupDTO;
import kr.co.don.board.dto.PopupFileDTO;
import kr.co.don.board.service.IPopupFileService;
import kr.co.don.board.service.IPopupService;
import kr.co.don.common.file.FileService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PopupServiceImpl implements IPopupService {

	@Autowired private IPopupDAO popupDAOImpl=null;
	@Autowired private FileService fileService = null;
	@Autowired private IPopupFileService popupFileServiceImpl=null;
	
	@Override
	public void write(PopupDTO popupDTO,HttpSession session) {
		
		popupDAOImpl.insertData(popupDTO);
		List<MultipartFile> fileList = popupDTO.getFiles();
		PopupFileDTO popupFileDTO= null;
		
		// 2. 첨부파일 디스크에 저장
		
		if(fileList != null) {
			for (MultipartFile file : popupDTO.getFiles()) {
				log.debug("파일 이름 =============>" + file.getOriginalFilename());
				log.debug("파일 크기 =============>" + file.getSize());
				
				popupFileDTO = fileService.uploadPopupFile(file, session);
				
				// 3. 첨부파일 디비에 insert
				popupFileDTO.setPopupId(popupDTO.getPopupId());
				popupFileServiceImpl.write(popupFileDTO);
			}
			
		}
		
	}
	//게시물 갯수
	@Override
	public List<PopupDTO> list() {
		List<PopupDTO>list= popupDAOImpl.selectList();
		
		for(PopupDTO popupDTO : list) {
		List<PopupFileDTO> fileList = popupFileServiceImpl.list(popupDTO.getPopupId());
		popupDTO.setFileList(fileList);
		}
		return list; 
	}

	@Override
	public PopupDTO view(PopupDTO _popupDTO) {
		PopupDTO popupDTO= popupDAOImpl.selectOne(_popupDTO);
		// 3. 첨부파일 가져오기
				List<PopupFileDTO> fileList = popupFileServiceImpl.list(_popupDTO.getPopupId());
				log.debug("1차~~~~~~~~~~"+fileList);
				log.debug("1차~~~~~~~~~~"+_popupDTO);
				log.debug("1차~~~~~~~~~~"+popupDTO);
				log.debug("1차~~~~~~~~~~"+_popupDTO.getPopupId());
				popupDTO.setFileList(fileList);
				
		return popupDTO;
	}

	@Override
	public void edit(PopupDTO popupDTO) {
		
		popupDAOImpl.update(popupDTO);
	}

	@Override
	@Transactional
	public void remove(Integer popupId) {
		
		
		popupFileServiceImpl.remove(popupId);
		popupDAOImpl.delete(popupId);
	}

}

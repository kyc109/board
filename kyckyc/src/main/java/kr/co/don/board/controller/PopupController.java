package kr.co.don.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.don.board.dto.PopupDTO;
import kr.co.don.board.service.IPopupService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/popup/")
public class PopupController {
	
	@Autowired private IPopupService popupServiceImpl=null;
	
	
	@RequestMapping(value="/list.java6", method=RequestMethod.GET)
	public void popupList(Model model) {

		
		
		List<PopupDTO> list = popupServiceImpl.list();
		log.debug("ddddddsssssssssssssssssss========>"+list);
		model.addAttribute("list",list);
		
	}
	@RequestMapping(value="listView.java6",method=RequestMethod.GET)
	public void view(Model model,PopupDTO _popupDTO ) {
		
		PopupDTO popupDTO=popupServiceImpl.view(_popupDTO);
		log.debug("원오형~~~=========>"+popupDTO);
		
		model.addAttribute("view",popupDTO);
	}
	
	@RequestMapping(value="listWrite.java6",method=RequestMethod.GET)
	public void giWrite() {
		
	}
	
	@RequestMapping(value="listWrite.java6",method=RequestMethod.POST)
	public String doWrite(PopupDTO popupDTO,HttpSession session) {
		popupServiceImpl.write(popupDTO,session);
		return "redirect:./listView.java6?popupId="+popupDTO.getPopupId();
	}
	//삭제
	@RequestMapping(value = "/remove.java6", method = RequestMethod.GET)
	public String remove(Model model,Integer popupId) {
		popupServiceImpl.remove(popupId);
		
		return "redirect:./list.java6";
	}
}

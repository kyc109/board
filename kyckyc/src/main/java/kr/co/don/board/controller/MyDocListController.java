package kr.co.don.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.don.board.dto.BoardDocDTO;
import kr.co.don.board.dto.BoardSearchDTO;
import kr.co.don.board.service.IMyDocListService;
import kr.co.don.user.dto.UserDTO;

@Controller
@RequestMapping(value="/board/doc/")
public class MyDocListController {

	@Autowired private IMyDocListService myDocListServiceImpl=null;

	
	@RequestMapping(value="/myList.java6", method=RequestMethod.GET)
	public void list(Model model,HttpSession session, @ModelAttribute("search") BoardSearchDTO search) {
		
		UserDTO userDTO = (UserDTO)session.getAttribute("_user");
		Integer userId = userDTO.getUserId();
		search.setUserId(userId);
		
		//게시물 가져오기
		List<BoardDocDTO> list = myDocListServiceImpl.list(search);
		model.addAttribute("list",list);
	}
	@RequestMapping(value="/myCommentList.java6",method=RequestMethod.GET)
	public void myComment(Model model,HttpSession session) {
		UserDTO userDTO =  (UserDTO)session.getAttribute("_user");
		
		List<BoardDocDTO> list=myDocListServiceImpl.listComment(userDTO.getUserId());
		
		model.addAttribute("list",list);
		
	}
}

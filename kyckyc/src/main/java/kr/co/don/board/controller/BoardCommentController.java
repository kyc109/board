package kr.co.don.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.omg.CORBA.BAD_INV_ORDER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.don.board.dto.BoardCommentDTO;
import kr.co.don.board.service.IBoardCommentService;
import kr.co.don.common.dto.ResponseDTO;
import kr.co.don.user.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board/comment/")
public class BoardCommentController {

	@Autowired
	private IBoardCommentService boardCommentServiceImpl = null;
	
	@ResponseBody
	@RequestMapping(value = "/write.java6", method = RequestMethod.POST)
	public ResponseDTO doWrite(Model model, HttpSession session, BoardCommentDTO boardCommentDTO) {
		
		ResponseDTO responseDTO = new ResponseDTO();
		
		try {
			// 사용자 아이디 구하기
			UserDTO userDTO = (UserDTO)session.getAttribute("_user");
			boardCommentDTO.setUserId(userDTO.getUserId());
			
			//댓글 저장
			boardCommentServiceImpl.writeComment(boardCommentDTO);
		}catch (Exception e) {
			responseDTO.setCode(-1);
			responseDTO.setMsg("오류발생 문의 바람.");
		}
		return responseDTO;
	}
	//댓글 목록
	@RequestMapping(value = "/list.java6", method = RequestMethod.GET)
	public void list(Model model, Integer docId) {
		
		List<BoardCommentDTO> list = boardCommentServiceImpl.viewComment(docId);
		log.debug("list======>"+list);
		
		model.addAttribute("list",list);
			
	}
	
	@ResponseBody
	@RequestMapping(value = "/remove.java6", method = RequestMethod.POST)
	public String delete(Model model, Integer commentId) {
		
		
		boardCommentServiceImpl.removeComment(commentId);
		
		return "S";
		
	}
	
	
	
	
}

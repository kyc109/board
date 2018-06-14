package kr.co.don.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.don.board.dto.BoardLikeDTO;
import kr.co.don.board.service.IBoardLikeService;
import kr.co.don.common.dto.ResponseDTO;
import kr.co.don.user.dto.UserDTO;

@Controller
@RequestMapping("/board/like/")
public class BoardLikeController {
	
	@Autowired private IBoardLikeService boardLikeServiceImpl=null;
	
	@ResponseBody
	@RequestMapping(value="/like.java6",method=RequestMethod.POST)
	public ResponseDTO doWrite(BoardLikeDTO _boardLikeDTO , Model model, HttpSession session) {
		
		ResponseDTO responseDTO = new ResponseDTO();
		
		try {
			//1.사용자 아이디 구하기
			UserDTO userDTO = (UserDTO)session.getAttribute("_user"); 
			_boardLikeDTO.setUserId(userDTO.getUserId());
			//좋아요 실행
			boardLikeServiceImpl.write(_boardLikeDTO);
			
			responseDTO.setCode(9);
		}catch (Exception e) {
			responseDTO.setCode(-1);
			responseDTO.setMsg("오류발생 문의 바람.");
		}
		return responseDTO;
	}
}


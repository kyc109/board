package kr.co.don.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.don.board.dto.BoardDocDTO;
import kr.co.don.board.dto.BoardMapDTO;
import kr.co.don.board.service.IBoardMapService;

@Controller
@RequestMapping("/board/map/")
public class BoardMapController {

	@Autowired
	private IBoardMapService boardMapServiceImpl = null;
	
	
	//json으로 객체를 가지고 오기 위해 responsebody를 적어줌
	@ResponseBody
	@RequestMapping(value = "/list.java6", method = RequestMethod.GET)
	public List<BoardMapDTO> list() {
		
		return boardMapServiceImpl.list();
	}
	
}

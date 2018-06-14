package kr.co.don.main;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.don.board.dto.PopupDTO;
import kr.co.don.board.service.IPopupService;
import kr.co.don.common.dto.ResponseDTO;
import kr.co.don.user.dto.UserDTO;
import kr.co.don.user.service.IUserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class JoinController {

	@Autowired private IUserService userServiceImpl = null;
	@Autowired private IPopupService popupServiceImpl=null;
	
	//나의 정보수정
	@RequestMapping(value = "/edit.java6", method=RequestMethod.GET)
	public void goEdit(Model model ,HttpSession session) {
		UserDTO userDTO = (UserDTO)session.getAttribute("_user");
		log.debug("goJoin======>확인" +userDTO);
		userDTO = userServiceImpl.view(userDTO.getUserId());
		
		model.addAttribute("userDTO",userDTO);
	}
    //정보수정
	@ResponseBody
	@RequestMapping(value = "/edit.java6", method=RequestMethod.POST)
	public String doEdit(UserDTO _userDTO ,HttpSession session) {
		UserDTO userDTO = (UserDTO)session.getAttribute("_user");
		
		_userDTO.setUserId(userDTO.getUserId());
		log.debug("UserDTO======>"+_userDTO);
		
		userServiceImpl.edit(_userDTO);
		session.setAttribute("_user", _userDTO);
		
		return "S";
	}
	//팝업
	@RequestMapping(value="/popup/popupDialog.java6",method=RequestMethod.GET)
	public void popupDialog(Model model) {
		
		List<PopupDTO> list =popupServiceImpl.list();
		log.debug("ddddddddddddddddddd"+list);
		
		model.addAttribute("list",list);
	}
	
	
	//회원가입 페이지로 이동
	
	@RequestMapping(value = "/join.java6", method=RequestMethod.GET)
	public void goJoin() {
		log.debug("goJoin======>확인");
	}
		
	//회원가입
	
	@ResponseBody
	@RequestMapping(value = "/join.java6", method=RequestMethod.POST)
	public String doJoin(UserDTO userDTO) {
		log.debug("UserDTO======>"+userDTO);
		
		
		userServiceImpl.write(userDTO);
		
		return "S";
	}
	//아이디 중복체크
	
	@ResponseBody
	@RequestMapping(value = "/check/id.java6", method=RequestMethod.GET)
	public ResponseDTO checkId(String loginId) {
		log.debug("loginId=====>"+ loginId);
		
		ResponseDTO responseDTO = new ResponseDTO();
		
		try {
		 int result = userServiceImpl.checkLoginId(loginId);
		 responseDTO.setCode(result);
		 if (result == 1) {
			 responseDTO.setMsg("아이디 사용가능");
		 }else {
			 responseDTO.setMsg("사용중인 아이디");
		 }
		}catch (Exception e) {
			responseDTO.setCode(-1);
			responseDTO.setMsg("에러가 발생했습니다. 관리자에게 문의하세요.");
		}
		return responseDTO;
	}
	//핸드폰 중복 체크
	@ResponseBody
	@RequestMapping(value = "/check/phone.java6", method = RequestMethod.GET)
	public ResponseDTO checkPhone(String phone) {
		
		log.debug("phone======>"+phone);
		
		ResponseDTO responseDTO = new ResponseDTO();
		
		try {
			int result = userServiceImpl.checkPhone(phone);
			responseDTO.setCode(result);
			if (result == 1) {
				responseDTO.setMsg("핸드폰 사용가능");
			}else {
				responseDTO.setMsg("사용중인 핸드폰");
			}
		}catch (Exception e) {
			responseDTO.setCode(-1);
			responseDTO.setMsg("에러가 발생했습니다. 관리자에게 문의하세요.");
		}
		
		return responseDTO;
	}
	//이메일 중복 체크
	@ResponseBody
	@RequestMapping(value = "/check/email.java6", method = RequestMethod.GET)
	public ResponseDTO checkEmail(String email) {
		
		ResponseDTO responseDTO = new ResponseDTO();
		
		try {
			
			int result = userServiceImpl.checkEmail(email);
			responseDTO.setCode(result);
			if (result == 1) {
				responseDTO.setMsg("이메일 사용가능");
			}else {
				responseDTO.setMsg("사용중인 이메일");
			}
		}catch (Exception e) {
			e.printStackTrace();
			responseDTO.setCode(-1);
			responseDTO.setMsg("오류발생 문의 바람.");
		}
		log.debug("responseDTO===>"+responseDTO);
		return responseDTO;
	}
}

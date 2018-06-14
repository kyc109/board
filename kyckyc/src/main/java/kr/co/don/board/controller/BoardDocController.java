package kr.co.don.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.HtmlUtils;

import kr.co.don.board.dto.BoardDocDTO;
import kr.co.don.board.dto.BoardMapDTO;
import kr.co.don.board.dto.BoardSearchDTO;
import kr.co.don.board.service.IBoardDocService;
import kr.co.don.board.service.IBoardFileService;
import kr.co.don.board.service.IBoardMapService;
import kr.co.don.user.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board/doc/")
public class BoardDocController {
	
	@Autowired private IBoardDocService boardDocServiceImpl = null;
	@Autowired private IBoardMapService boardMapServiceImpl = null;
	@Autowired private IBoardFileService boardFileServiceImpl = null;
	
	
	//게시판 목록
	
	@RequestMapping(value = "/list.java6", method = RequestMethod.GET)
	public void list(Model model, @ModelAttribute("search") BoardSearchDTO search) {
	
		log.debug("search======>"+search);
		
		//통합맵 정보 가져오기
		BoardMapDTO boardMapDTO = boardMapServiceImpl.view(search.getMapId());	
		model.addAttribute("boardMapDTO", boardMapDTO);
		
		//게시판 목록 가져오기
		List<BoardDocDTO> list = boardDocServiceImpl.list(search);
		model.addAttribute("list", list);
		
		
		//model.addAttribute("mapId", mapId);
		
		
	}
	//게시판 글쓰기
		@RequestMapping(value = "/write.java6", method = RequestMethod.GET)
		public void goWrite (Model model, @ModelAttribute("search") BoardSearchDTO search) {
			BoardMapDTO boardMapDTO = boardMapServiceImpl.view(search.getMapId());	
			model.addAttribute("boardMapDTO", boardMapDTO);
			
		}
		
		//게시판 저장
		@RequestMapping(value = "/write.java6", method = RequestMethod.POST)
		public String doWrite (Model model, HttpSession session, BoardDocDTO boardDocDTO, @ModelAttribute("search") BoardSearchDTO search) {
			UserDTO userDTO = (UserDTO)session.getAttribute("_user");
			boardDocDTO.setUserId(userDTO.getUserId());
/*			Integer userId = userDTO.getUserId(); 
			boardDocDTO.setUserId(userId);
*/
			log.debug("ffffffffff=================>"+userDTO);
			
		/*	log.debug("유저 정보 =============>"+userDTO);
			log.debug("파일 갯수 =============>"+boardDocDTO.getFiles().size());
		*/	
			 String title= HtmlUtils.htmlEscape(boardDocDTO.getTitle());
			 boardDocDTO.setTitle(title);
			
			if(boardDocDTO.getFiles()!=null) {
				// 첨부파일이 넘어오는지 확인
				for (MultipartFile file : boardDocDTO.getFiles()) {
					log.debug("파일 이름 =============>" + file.getOriginalFilename());
					log.debug("파일 크기 =============>" + file.getSize());
				}
				
			}
			
			
			boardDocServiceImpl.writeData(boardDocDTO, session);
			return "redirect:./view.java6?docId="+boardDocDTO.getDocId()+"&"+search.getParams();
			
		}
		//조회
		//카운트 
		@RequestMapping(value = "/view.java6", method = RequestMethod.GET)
		public void view (Model model, 
				HttpSession session,
				@ModelAttribute("search") BoardSearchDTO search,BoardDocDTO _boardDocDTO) {
			// 1. 통합맵 정보 가져오기
			BoardMapDTO boardMapDTO = boardMapServiceImpl.view(search.getMapId());
			model.addAttribute("boardMapDTO", boardMapDTO);
			
			//2-1.로그인 한 사용자 ID 구하기(좋아요)
			UserDTO userDTO = (UserDTO)session.getAttribute("_user");
			_boardDocDTO.setViewerId(userDTO.getUserId());
			// 2. 조회
			BoardDocDTO boardDocDTO = boardDocServiceImpl.view(_boardDocDTO);
			log.debug("======> boardDocDTO=====> " +boardDocDTO);
			model.addAttribute("view", boardDocDTO);
			
					
		}
		
		//게시판 수정 이동
		@RequestMapping(value = "/edit.java6", method = RequestMethod.GET)
		public void goEdit (Model model, 
				HttpSession session,
				@ModelAttribute("search") BoardSearchDTO search, 
				BoardDocDTO _boardDocDTO) {
			//1. 통합맵 정보 가져오기
			BoardMapDTO boardMapDTO = boardMapServiceImpl.view(search.getMapId());	
			model.addAttribute("boardMapDTO", boardMapDTO);
			
			//2-1.로그인 한 사용자 ID구하기(뷰어)
			UserDTO userDTO = (UserDTO)session.getAttribute("_user");
			_boardDocDTO.setViewerId(userDTO.getUserId());
			//2. 조회
			BoardDocDTO boardDocDTO = boardDocServiceImpl.view(_boardDocDTO);
			model.addAttribute("view", boardDocDTO);
			
			
		}
		
		//게시판  수정 저장
		@RequestMapping(value = "/edit.java6", method = RequestMethod.POST)
		public String doEdit (Model model, HttpSession session, BoardDocDTO boardDocDTO, @ModelAttribute("search") BoardSearchDTO search) {
			UserDTO userDTO = (UserDTO)session.getAttribute("_user");
			log.debug("=============>"+userDTO);
			
			Integer userId = userDTO.getUserId(); 
			boardDocDTO.setUserId(userId);
			
			
			
			
			//html를 HtmlUtils.htmlEscape 에 넣어서String으로 변환 , 다시 DTO에 넣어서 출력 
			 String title= HtmlUtils.htmlEscape(boardDocDTO.getTitle());
			 boardDocDTO.setTitle(title);
			//HtmlUtils.htmlEscape(arg0)
			
			boardDocServiceImpl.editData(boardDocDTO,session);
			
			return "redirect:./view.java6?docId="+boardDocDTO.getDocId()+"&"+search.getParams();
		}
		//삭제
		@ResponseBody
		@RequestMapping(value = "/remove.java6", method = RequestMethod.POST)
		public String remove(Model model,Integer docId) {
			
			boardDocServiceImpl.remove(docId);
			
			return "S";
		}
//		@RequestMapping(value="myList.java6", method=RequestMethod.GET)
//		public void myList() {
//			
//		}
}

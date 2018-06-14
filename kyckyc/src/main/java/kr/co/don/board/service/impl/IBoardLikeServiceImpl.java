package kr.co.don.board.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.don.board.dao.IBoardLikeDAO;
import kr.co.don.board.dto.BoardLikeDTO;
import kr.co.don.board.service.IBoardLikeService;

@Service
public class IBoardLikeServiceImpl implements IBoardLikeService {

	@Autowired private IBoardLikeDAO boardLikeDAOImpl=null;
	
	//등록(좋아요 아니면 싫어요)
	@Override
	public void write(BoardLikeDTO boardLikeDTO) {
		//likeYn ==> Y,N
		
		//무관심 처리
		if(boardLikeDTO.getLikeYn() == null ||boardLikeDTO.getLikeYn().equals("")) {
			this.remove(boardLikeDTO.getLikeId());
		}else {
			
			boardLikeDAOImpl.insertData(boardLikeDTO);
		}
		
	}
	//데이터 삭제
	@Override
	public void remove(Integer likeId) {
		// TODO Auto-generated method stub
		boardLikeDAOImpl.deleteDate(likeId);
	}

}

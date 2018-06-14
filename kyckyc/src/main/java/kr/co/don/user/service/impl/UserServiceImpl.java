package kr.co.don.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.don.user.dao.IUserDAO;
import kr.co.don.user.dto.UserDTO;
import kr.co.don.user.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDAO userDAOImpl = null;
	
	@Override
	public void write(UserDTO userDTO) {
		userDAOImpl.insertData(userDTO);
	}

	@Override
	public UserDTO view(int userId) {
		return userDAOImpl.selectOne(userId);
	}

	@Override
	public void edit(UserDTO userDTO) {
		userDAOImpl.updateData(userDTO);
	}

	@Override
	public void remove(UserDTO userDTO) {
		userDAOImpl.deleteData(userDTO);
	}

	@Override
	public int checkLoginId(String loginId) {
		int cnt = userDAOImpl.selectCountByLoginId(loginId);
		//사용 불가
		if (cnt > 0 ) {
			return 0;
		//사용가능
		}else {
			
			return 1;
		}
	}

	@Override
	public int checkPhone(String phone) {
		int cnt = userDAOImpl.selectCountPhone(phone);
		
		//폰 사용불가
		if (cnt > 0 ) {
			return 0;
		//폰 사용가능	
		}else {
			return 1;
		}
			
	}

	@Override
	public int checkEmail(String email) {
		
		int cnt = userDAOImpl.selectCountEmail(email);
		
		if (cnt > 0 ) {
			return 0;
		}else {
			return 1;
		}
		
	}

	@Override
	public UserDTO viewByLoginId(String loginId) {
		return userDAOImpl.selectByLoginId(loginId);
	}
}

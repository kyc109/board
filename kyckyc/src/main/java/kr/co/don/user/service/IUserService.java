package kr.co.don.user.service;

import kr.co.don.user.dto.UserDTO;

public interface IUserService {

	public void write(UserDTO userDTO);
	public UserDTO view (int userId);
	public void edit(UserDTO userDTO);
	public void remove(UserDTO userDTO);
	
	public int checkLoginId (String loginId);
	public int checkPhone (String phone);
	public int checkEmail (String email);
	
	public UserDTO viewByLoginId(String loginId);
}

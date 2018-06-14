package kr.co.don.user.dao;

import kr.co.don.user.dto.UserDTO;

public interface IUserDAO {

	public void insertData(UserDTO userDTO);
	public UserDTO selectOne(int userId);
	public void updateData(UserDTO userDTO);
	public void deleteData(UserDTO userDTO);

	public int selectCountByLoginId(String loginId);
	public int selectCountPhone(String phone);
	public int selectCountEmail(String email);
	
	public UserDTO selectByLoginId(String loginId);
	
}

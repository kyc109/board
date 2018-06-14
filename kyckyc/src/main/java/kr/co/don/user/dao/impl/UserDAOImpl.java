package kr.co.don.user.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.don.common.dao.BaseDaoSupport;
import kr.co.don.user.dao.IUserDAO;
import kr.co.don.user.dto.UserDTO;

@Repository
public class UserDAOImpl extends BaseDaoSupport implements IUserDAO {

	@Override
	public void insertData(UserDTO userDTO) {
		
//		SqlSession sqlSession = this.getSqlSession();
//		sqlSession.insert("User.inserData", userDTO);
		
		this.getSqlSession().insert("User.insertData", userDTO);
	}

	@Override
	public UserDTO selectOne(int userId) {
		return this.getSqlSession().selectOne("User.selectOne", userId);
	}

	@Override
	public void updateData(UserDTO userDTO) {
		this.getSqlSession().update("User.updateData", userDTO);
	}

	@Override
	public void deleteData(UserDTO userDTO) {
		this.getSqlSession().delete("User.deleteData", userDTO);
	}

	@Override
	public int selectCountByLoginId(String loginId) {
		return this.getSqlSession().selectOne("User.selectCountByLoginId", loginId);
	}

	@Override
	public int selectCountPhone(String phone) {
		return this.getSqlSession().selectOne("User.selectCountPhone", phone);
	}

	@Override
	public int selectCountEmail(String email) {
		return this.getSqlSession().selectOne("User.selectCountEmail", email);
	}

	@Override
	public UserDTO selectByLoginId(String loginId) {
		return this.getSqlSession().selectOne("User.selectByLoginId", loginId);
	}



	
}

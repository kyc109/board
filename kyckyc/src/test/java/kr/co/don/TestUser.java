package kr.co.don;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.don.user.dto.UserDTO;
import kr.co.don.user.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
"file:src/main/webapp/WEB-INF/spring/root-context.xml"})


public class TestUser {

	@Autowired
	private IUserService userServiceImpl = null;
	
	@Test
	public void write () {
		UserDTO userDTO = new UserDTO();
		
		userDTO.setUserId(9999);
		userDTO.setLoginId("kyc269");
		userDTO.setLoginPw("123789");
		userDTO.setName("블랙보드");
		userDTO.setPhone("001-2241-1111");
		userDTO.setEmail("ggaman@gmail.com");
		userDTO.setStatus(9);
		userDTO.setRole("USER");
		
		userServiceImpl.write(userDTO);
		
	}
	@Test
	public void view() {
		UserDTO userDTO = userServiceImpl.view(120);
		System.out.println(userDTO.toString());
		
	}
	@Test
	public void edit() {
		UserDTO userDTO = new UserDTO();
			userDTO.setUserId(211);
			userDTO.setLoginPw("re12212");
			userDTO.setName("블러드");
			userDTO.setPhone("090-0000-0001");
			userDTO.setEmail("blood@pee.com");
			
			userServiceImpl.edit(userDTO);
	}
	@Test
	public void remove() {
		UserDTO userDTO = new UserDTO();
		userDTO.setUserId(214);
		
		userServiceImpl.remove(userDTO);
		
		
	}
		
		
	
		
}

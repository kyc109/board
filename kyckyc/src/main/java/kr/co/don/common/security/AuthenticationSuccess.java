package kr.co.don.common.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import kr.co.don.user.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthenticationSuccess extends AbstractAuthenticationTargetUrlRequestHandler implements AuthenticationSuccessHandler {
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		UserDetail userDetail = (UserDetail)authentication.getPrincipal();
		UserDTO userDTO = userDetail.getUser();
		userDTO.setLoginPw("");
		HttpSession session = request.getSession(true);
		session.setAttribute("_user", userDTO);
		
		getRedirectStrategy().sendRedirect(request, response,  "/main/index.java6" );
		
		log.debug("인증성공 ===>");
	}
}

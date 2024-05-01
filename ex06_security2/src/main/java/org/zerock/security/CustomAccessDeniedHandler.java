package org.zerock.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomAccessDeniedHandler implements AccessDeniedHandler{@Override  //권한 거부 당했을 시 핸들러
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		
	log.error("--------------------------------------------");
	log.error("Access Denied Handler");
	log.error("Redirect...");
	log.error("--------------------------------------------");
	
	response.sendRedirect("/accessError");
	}

}

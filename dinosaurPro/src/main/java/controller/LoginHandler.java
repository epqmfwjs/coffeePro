package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.LoginService;

public class LoginHandler implements CommandHandler {
	
	private LoginService loginService = new LoginService();
	@Override
	public String Start(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		//model로 메소드호출하여 값 전달 후 결과 받아서 FrontController로 보낼 return값 저장  
		String returnPage = null;
		try {
			returnPage = loginService.loginTest(request.getParameter("id"), request.getParameter("pwd"), request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnPage;
	}

}

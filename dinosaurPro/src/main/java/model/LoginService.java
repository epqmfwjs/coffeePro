package model;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dinoServlet.MemberDAO;

public class LoginService {

	String returnPage;
	String result = null;
	public String loginTest(String Uid, String Upw,
			HttpServletRequest request, HttpServletResponse response) throws IOException{
		MemberDAO memberDAO = new MemberDAO();
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);	
		boolean result;

		try {			 
			result = memberDAO.select(Uid,Upw);
		
			 if (result == true) {
			session.setAttribute("AUTH_USER_ID", request.getParameter("id"));
			session.setAttribute("AUTH_USER_PWD", request.getParameter("pwd"));
			session.setAttribute("AUTH_USER_NAME", request.getParameter("name"));
				returnPage="index.jsp";
		    
			}else{
			 session.setAttribute("errMSG", "아이디나 비밀번호가 일치하지않습니다.");
			 out.println("<script>alert('로그인실패'); location.href='/dinosaurPro/mainDino/management/login.jsp';</script>");
			 out.flush();
				returnPage="login.jsp";
				}
			}catch (Exception e) {
			e.printStackTrace();
				}
		return returnPage;
	}
}



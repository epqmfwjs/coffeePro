package controller;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dinoServlet.MemberDTO;
import dinoServlet.MemberDAO;


public class EditHandler implements CommandHandler {
	
	@Override 
	public String Start(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		HttpSession session = request.getSession(false);
		MemberDAO memberDAO = new MemberDAO();
		PrintWriter out = response.getWriter();
		boolean result;
		String returnPage = null;
		//String Uid = request.getParameter("PutId");
		String Upwd = request.getParameter("EditPwd");
		String Unm = request.getParameter("EditName");
		
		String sId = (String)session.getAttribute("AUTH_USER_ID");
		String sPwd = (String)session.getAttribute("AUTH_USER_PWD");
		
		result = memberDAO.select(sId,sPwd);

		if (result==true) {
			memberDAO.update(Unm,Upwd,sId);
			returnPage = "myPage.jsp";
			 out.println("<script>alert('회원정보 변경완료'); location.href='/dinosaurPro/myPage.jsp';</script>");
			 out.flush();
		}else {
			System.out.println("비밀번호 틀림");
          	 session.setAttribute("errMSG2", "아이디나 비밀번호가 일치하지않습니다.");
			 out.println("<script>alert('변경실패'); location.href='/dinosaurPro/myPage.jsp';</script>");
			 out.flush();
		}
		return returnPage; 
	}
}

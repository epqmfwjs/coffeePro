package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dinoServlet.MemberDAO;
import dinoServlet.MemberDTO;


public class JoinHandler implements CommandHandler {
	
	@Override 
	public String Start(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		String Uid = request.getParameter("PutId");
		String Upwd = request.getParameter("PutPwd");
		String Unm = request.getParameter("PutName");
		String returnPage = null;
		MemberDTO joinDTO = null;
		try { 
			joinDTO = new MemberDTO(Uid,Upwd,Unm);
			MemberDAO memberDAO = new MemberDAO();		
			returnPage = memberDAO.insert(joinDTO); //DAO에 insert메소드 호출
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return returnPage; 
	}
}

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dinoServlet.MemberDAO;
import dinoServlet.MemberDTO;
import model.DeleteService;


public class DeleteMemberHandler implements CommandHandler {
	
	@Override
	public String Start(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException,IOException{
		HttpSession session = request.getSession(false);
		
		DeleteService deleteService = new DeleteService();
		String returnPage = null;
		
		String Uid = request.getParameter("deleteId");
		String Upwd = request.getParameter("deletePwd");
	    String sId = (String) session.getAttribute("AUTH_USER_ID");
	    String sPwd = (String) session.getAttribute("AUTH_USER_PWD");
		
	    returnPage = deleteService.deleteAction(Uid, Upwd, sId, sPwd, request, response);

		return returnPage; 
	}
}

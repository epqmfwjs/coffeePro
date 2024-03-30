package model;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dinoServlet.MemberDAO;

public class DeleteService {
	public DeleteService() {};
	public String deleteAction(String Uid,String Upwd,String sId,String sPwd,HttpServletRequest request, HttpServletResponse response) 
			throws IOException{
		MemberDAO memberDAO = new MemberDAO();
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		boolean resultSelect;
		boolean resultDelete = false;
		String returnPage = null;
		
		resultSelect = memberDAO.select(sId,sPwd);
		
		if (resultSelect == true) {
			resultDelete = memberDAO.delete(Uid,Upwd,sId);
		} else {
	       	 session.setAttribute("errMSG1", "아이디나 비밀번호가 일치하지않습니다.");
			 out.println("<script>alert('탈퇴실패'); location.href='/dinosaurPro/mainDino/management/delete.jsp';</script>");
			 out.flush();
	        }
			if(resultDelete == true) {
				returnPage = "okDelete.jsp";
			}else {
		       	 session.setAttribute("errMSG1", "아이디나 비밀번호가 일치하지않습니다.");
				 out.println("<script>alert('삭제실패'); location.href='/dinosaurPro/mainDino/management/delete.jsp';</script>");
				 out.flush();
			}

	return returnPage;
	}

}

package model;

import java.sql.SQLException;

import dinoServlet.MemberDAO;
import dinoServlet.MemberDTO;

public class JoinService {
	MemberDTO joinDTO = new MemberDTO();
//	JoinDAO joinDAO = new JoinDAO();
	String returnPage;
	public String joinTest(String Uid, String Upw, String Unm) {
//		//System.out.println("Handler"+request.getParameter("PutName")+request.getParameter("PutId")+request.getParameter("PutPwd"));
//		JoinDAO jd = new JoinDAO();
//		try {
//			jd.insert(joinDTO);
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}
//		
		
		
		String returnPage = "index.jsp";
		System.out.println("여기까지옴");
		System.out.println(joinDTO.getDbId1());
		if (joinDTO.getDbId1().equals(Uid)) {
			returnPage="index.jsp";
	}else {
			returnPage="join.jsp";
		}
		return returnPage;  
	}
}

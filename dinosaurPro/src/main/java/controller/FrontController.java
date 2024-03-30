package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private Map<String, CommandHandler> map = new HashMap<String, CommandHandler>();
	public void init(ServletConfig config) throws ServletException {
		map.put("/LoginHandler", new LoginHandler());
		map.put("/JoinHandler", new JoinHandler());
		map.put("/DeleteMemberHandler", new DeleteMemberHandler());
		map.put("/EditHandler", new EditHandler());
	} 
	public void destroy() { 
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); 
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();

		String viewPage = null;
		//요청URI 분석 후 substring 처리부분					
		String requestURI = request.getRequestURI().toString();
		String command = requestURI.substring(request.getContextPath().length());
				
		//map이용  LoginHandler 생성후  메소드 호출해서 결과 값 받아서 최종보여줄 viewPage 저장
		if(requestURI.indexOf(request.getContextPath())==0) {
			CommandHandler handler = map.get(command);
			viewPage = handler.Start(request, response);
			System.out.println(viewPage);
		}				
			request.getRequestDispatcher(viewPage).forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

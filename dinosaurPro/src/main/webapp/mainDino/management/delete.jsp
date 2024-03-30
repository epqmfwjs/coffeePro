<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1><strong>정말로 탈퇴하시겠습니까?</strong></h1>
<hr/>
			<%// 로그인 실패시 에러메세지 관련 부분
			String model = (String) session.getAttribute("errMSG1");
			if(model != null){
				
				out.println(model + "<hr/>");
				session.invalidate();
			}
			%>
<form action="<%=request.getContextPath() %>/DeleteMemberHandler" method = "post">
				
					아이디<br/><input type="text" name="deleteId" id="deleteId" placeholder="아이디" required="required"/><br/>
					비밀번호<br/><input type="password" name="deletePwd" id="deletePwd" placeholder="비밀번호" required="required"/><br/>
		 
		 		<br/>	<input type="submit" value="탈퇴"/>
			</form>
</body>
</html>
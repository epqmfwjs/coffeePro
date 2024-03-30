<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dinosaur Library</title>

<link href="<%=request.getContextPath()%>/css/login.css" rel="stylesheet" type="text/css">
	
</head>
<body>
	<a href="<%=request.getContextPath()%>/index.jsp">
	<img alt="Logo(Home)" src="<%=request.getContextPath() %>/img/dinoLogo.png" class="logo">
	</a><br/><hr/>
		<div class= "login">
			<%// 로그인 실패시 에러메세지 관련 부분
			String model = (String) session.getAttribute("errMSG");
			if(model != null){
				
				out.println(model + "<hr/>");
				session.invalidate();
			}
			%>
		
			<form action="<%=request.getContextPath() %>/LoginHandler" method = "post">
				<h1><strong>Dinosaur Library</strong></h1>
					아이디<br/><input type="text" name="id" id="id" placeholder="아이디" required="required"/><br/>
					비밀번호<br/><input type="password" name="pwd" id="pwd" placeholder="비밀번호" required="required"/><br/>
		 
		 		<br/>	<input type="submit" value="로그인"/>
		 				<input type="button" value="회원가입"/>
			</form>
		</div>
</body>
</html>
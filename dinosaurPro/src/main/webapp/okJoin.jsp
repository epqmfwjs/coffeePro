<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="<%=request.getContextPath()%>/index.jsp">
	<img alt="Logo(Home)" src="<%=request.getContextPath() %>/img/dinoLogo.png" class="logo">
</a>
<%
	if(session.getAttribute("AUTH_USER_ID") != null){
%>
	<div align="right" style="color:white;">
	  <strong><%= session.getAttribute("AUTH_USER_NAME") %></strong> 님 안녕하세요
		<form action="<%=request.getContextPath() %>/Logout">
			<input type="submit" value="로그아웃"  class="login-button" onclick="alert('로그아웃되었습니다.')"/>
		</form>
	</div>

<%}else{%>
	<div>
		<form action="<%= request.getContextPath()%>/mainDino/management/login.jsp" name="loginFrm" method="post">
			<input type="submit" value="로그인" class="login-button"/>
		</form>
	</div>
<%}%>
<h1>회원가입을 축하합니다</h1>
</body>
</html>
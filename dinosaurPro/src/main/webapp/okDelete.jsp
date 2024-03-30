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
<%session.invalidate();%>
<h1>회원탈퇴가 완료되었습니다.</h1>
</body>
</html>
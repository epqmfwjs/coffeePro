<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원가입</h1>
<form action="<%=request.getContextPath() %>/JoinHandler" method="post">
이름 : <input type="text" name="PutName" id="INname"><br/>
아이디 : <input type="text" name="PutId" id="PutId"><br/>
비밀번호 : <input type="password" name="PutPwd" id="PutPwd"><br/>
<input type="submit" value="가입">
</form>
</body>
</html>
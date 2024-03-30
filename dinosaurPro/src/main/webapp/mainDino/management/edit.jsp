<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
			<form action="<%=request.getContextPath() %>/EditHandler"  method = "post">

					이름<br/><input type="text" name="EditName" id="EditName" placeholder="이름" required="required"/><br/>
					비밀번호<br/><input type="password" name="EditPwd" id="EditPwd" placeholder="비밀번호" required="required"/><br/>

		 		<br/>	<input type="submit" value="변경"/>
			</form>

</body>
</html>
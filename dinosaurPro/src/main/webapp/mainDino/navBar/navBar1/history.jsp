<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Dinosaur Library</title>

<link href="<%=request.getContextPath()%>/css/mainP.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/css/storeP.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/css/sideBar.css" rel="stylesheet" type="text/css">

</head>
<body>
<a href="<%=request.getContextPath()%>/index.jsp">
	<img alt="Logo(Home)" src="<%=request.getContextPath() %>/img/dinoLogo.png" class="logo">
</a>
<%
	if(session.getAttribute("AUTH_USER_ID") != null){
%>
	<div align="right">
	  <strong><%= session.getAttribute("AUTH_USER_NAME") %></strong> 님 안녕하세요
		<form action="<%=request.getContextPath() %>/Logout">
			<input type="submit" value="로그아웃"  class="login-button" onclick="alert('로그아웃되었습니다.')"/>
		</form>
	</div>
<%}else{%>
	<div>
		<form action="<%= request.getContextPath()%>/mainDino/login.jsp" name="loginFrm" method="post">
			<input type="submit" value="로그인" class="login-button"/>
		</form>
	</div>
 
<%}%>
	<nav>
		<ul>
			<li class="dropdown">
				<div class="dropdown-menu">History of Dinosaurs</div>
				<div class="dropdown-content">
					<a href="<%=request.getContextPath()%>/mainDino/navBar/navBar1/history.jsp">History</a>
					<a href="<%=request.getContextPath()%>/mainDino/navBar/navBar1/triassic.jsp">triassic Period</a>
					<a href="<%=request.getContextPath()%>/mainDino/navBar/navBar1/jurassic.jsp">jurassic Period</a>
					<a href="<%=request.getContextPath()%>/mainDino/navBar/navBar1/cretaceous.jsp">cretaceous Period</a>
				</div>
			</li>	
			<li class="dropdown">
				<div class="dropdown-menu">Types of Dinosaurs</div>
				<div class="dropdown-content">
					<a href="#">menu2-1</a>
					<a href="#">menu2-2</a>
					<a href="#">menu2-3</a>
					<a href="#">menu2-4</a>
				</div>
			</li>	
			<li class="dropdown">
				<div class="dropdown-menu">Game Play</div>
				<div class="dropdown-content">
					<a href="#">menu3-1</a>
					<a href="#">menu3-2</a>
					<a href="#">menu3-3</a>
					<a href="#">menu3-4</a>
				</div>
			</li>	
			<li class="dropdown">
				<div class="dropdown-menu">Store</div>
				<div class="dropdown-content">
					<a href="<%=request.getContextPath()%>/mainDino/navBar/navBar4/doll.jsp">Dino Doll</a>
					<a href="#">Dino Figure</a>
					<a href="#">Dino Book</a>
				</div>
			</li>
			<li class="dropdown">
				<div class="dropdown-menu">Download</div>
				<div class="dropdown-content">
					<a href="#">menu5-1</a>
					<a href="#">menu5-2</a>
					<a href="#">menu5-3</a>
					<a href="#">menu5-4</a>
				</div>
			</li>
			<li class="dropdown">
				<div class="dropdown-menu">Communication</div>
				<div class="dropdown-content">
					<a href="#">User Community</a>
					<a href="#">QnA</a>
					<a href="#">menu6-3</a>
					<a href="#">menu6-4</a>
				</div>
			</li>
			<li class="home"><a href="<%=request.getContextPath()%>/index.jsp">Home</a></li>	
		</ul>
	</nav>

	<aside class="side-bar">
  <section class="side-bar__icon-box">
    <section class="side-bar__icon-1">
      <div></div>
      <div></div>
      <div></div>
    </section>
  </section>
<%
	if(session.getAttribute("AUTH_USER_ID") != null){
%>

  <ul>
    <li>
      <a href="#"><Strong>ID </Strong><i class="fa-solid fa-cat"></i><%= session.getAttribute("AUTH_USER_ID") %></a>
    </li>
    <li>
      <a href="#">회원메뉴</a>
      <ul>
        <li><a href="#">회원정보</a></li>
        <li><a href="#">최근구매내역</a></li>
        <li><a href="#">장바구니</a></li>
        <li><a href="#">관심목록</a></li>
      </ul>
    </li>
    <li>
      <a href="#">알림</a>
      <ul>
        <li><a href="#">공지사항</a></li>
        <li><a href="#">이벤트</a></li>
        <li><a href="#">알림메시지</a></li>
      </ul>
    </li>
    <li>
      <a href="<%=request.getContextPath() %>/Logout" onclick="alert('로그아웃되었습니다.')">로그아웃</a>
    </li>
  </ul>
  <%}else{%>
    <li>
      <a href="#"></a>
      <ul>
        <li><a href="<%= request.getContextPath()%>/mainDino/management/login.jsp">로그인</a></li>
        <li><a href="#">회원가입</a></li>
        <li><a href="#"></a></li>
        <li><a href="#"></a></li>
      </ul>
    </li>
  </ul>
  <%}%>
</aside>
	<p><a href="<%=request.getContextPath()%>/mainDino/navBar/navBar1/history.jsp">
	<img alt="Store" src="<%=request.getContextPath() %>/img/storeLogo.png" class="storeLogo"></a></p>
	<p  style="color:white; font-size:35px;">History</p>   
	 
</body>
</html>
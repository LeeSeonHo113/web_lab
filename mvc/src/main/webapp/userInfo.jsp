<%@page import="site.metacoding.mvc.domain.MyUser"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원정보 페이지입니다.</h1>
<hr/>
<%
	MyUser myUser = (MyUser)request.getAttribute("myUser");
%>
아이디 : <%=myUser.getId() %><br/>
유저네임 : <%=myUser.getUsername() %><br/>
패스워드 : <%=myUser.getPassword() %><br/>
이메일 : <%=myUser.getEmail() %><br/>
</body>
</html>
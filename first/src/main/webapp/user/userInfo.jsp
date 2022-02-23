<%@page import="java.sql.ResultSet"%>
<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li><a href="/user/login.html">로그인 페이지</a></li>
		<li><a href="/user/join.html">회원가입 페이지</a></li>
		<li><a href="/user/userInfo.jsp">회원정보 페이지</a></li>
		<li><a href="/post/list.html">글 목록 페이지</a></li>
	</ul>
<%
	// request는 BufferedReader로 읽는 모든 정보를 자바 오브젝트로 바꾼 결정체(톰켓이 해줌)
	// getParameter() 쿼리스트링 파싱해주는 메서드
	
	// 1. 테이블 생성
	
	// 2. 쿼리스트링 파싱
	int id = Integer.parseInt(request.getParameter("id"));
	System.out.println("id : " + id);

	// 3. DB 연결 코드
	Connection conn = null;
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
	System.out.println("1. DB 연결 성공");

	// 4. SELECT로 id, name, phone 받기
	String sql = "SELECT id, name, phone FROM userInfo WHERE id = ?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setInt(1, id);
	
	ResultSet rs = pstmt.executeQuery();
	String name = null;
	String phone = null;
	while(rs.next()) {
		name = rs.getString("name");
		phone = rs.getString("phone");
	}
	// 5. 뿌려주기
	
%>
	<h1>회원정보 페이지입니다. - 인증 필요</h1>
	<h3>
		아이디 : <%=id %> 이름 : <%=name %> 전화번호 : <%=phone %>
	</h3>
	<hr />
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String root = request.getContextPath(); // root = '/membermvc'
%>
<%
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String emailid = request.getParameter("emailid");
	String emaildomain = request.getParameter("emaildomain");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<strong><%=name %></strong>님 회원 가입을 축하합니다.<br>
	가입 아이디는 <%=id %>이고 이메일은 <%=emailid %>@<%=emaildomain %> 입니다.<br>
	로그인 후 서비스를 이용할 수 있습니다.<br>
	<a href="<%=root %>/login/login.jsp">로그인</a>
</body>
</html>
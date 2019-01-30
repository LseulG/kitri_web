<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
if (request.getMethod().equals("POST")) {
	request.setCharacterEncoding("UTF-8");	// POST 경우
}

String name = request.getParameter("name");
String gender = request.getParameter("gender");

String color = gender.equals("남") ? "cyan" : "pink" ;
%>
<div align="center">
<font color="<%=color%>"><%=name%></font>님 안녕하세요.
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<a href="mailto:<%=emailid %>@<%=emaildomain %>"><%=name %>(<%=id %>)</a>님 환영합니다.<br>
이메일은 <%=emailid %>@<%=emaildomain %> 입니다.<br>		
</body>
</html>
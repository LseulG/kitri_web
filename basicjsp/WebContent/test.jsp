<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info="간단 테스트입니다."
	import="java.util.Random"
	import="java.io.*,java.sql.*"
%>
<!-- 여기 주석은 코드에서 보입니다. (html 주석) -->
<%-- 여기 주석은 코드에서 보이지 않습니다. (jsp 주석) --%>
<%-- /*자바 부분은 자바 주석으로 가능합니다.*/ (java 주석)--%>    
<%!
String name;

Random ra;
InputStream in;
Connection conn;

public void init() {
	name = "슬슬슬";
}

/*
public void init() {
	name = "슬슬슬";
}*/

 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
당신의 이름은 <% out.println(name); %>입니다.<br>
당신의 이름은 <% out.print(name); %>입니다.<br>
당신의 이름은 <% out.write(name); %>입니다.<br>
당신의 이름은 <%= name %>입니다.<br>
</div>
</body>
</html>
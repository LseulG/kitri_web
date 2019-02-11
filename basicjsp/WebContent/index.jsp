<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
String name;
public void init() {
	name = "슬슬슬";
}
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
Hello JSP!!! <br>
안녕 제이에스피~! <br>
안녕 <%= name %>~~!!!!
</div>
<div align="center">
<h3>JSP Test</h3>
<a href="/basicjsp/hello.jsp">Hello JSP</a><br>
<a href="/basicjsp/test.jsp">JSP Script Test</a><br>
<a href="/basicjsp/gugudan.jsp">구구단</a><br>
<a href="/basicjsp/param/form.jsp">파라미터전송.</a><br>
<a href="/basicjsp/param/multiform.jsp">멀티파라미터전송.</a><br>
<a href="/basicjsp/counter.jsp">카운터</a><br>
<a href="/basicjsp/dbcounter.jsp">DB카운터d</a><br>
</div>
</body>
</html>
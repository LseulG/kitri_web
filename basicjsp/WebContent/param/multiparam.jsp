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
String name = request.getParameter("name");
String age = request.getParameter("age");
String[] fruits = request.getParameterValues("fruit");

String color = age.equals("10") ? "orange" : "blue";
age = age.equals("60") ? age+"대이상" : age+"대";
%>
<div align="center">
	<font color="<%=color%>"><%=name%>(<%=age%>)</font>님이 좋아하는 과일은
<%
	if (fruits == null) {
		out.println("없습니다.");		
	} else {
		for (int i = 0; i<fruits.length; i++) {
			out.println(fruits[i]);
			if (i != fruits.length -1) {
				out.println(", ");								
			}
		}
	out.println("입니다.");						
	}		
%>

<% if (fruits == null) { %>
		없습니다.	
<%	} else {
		for (int i = 0; i<fruits.length; i++) { %>
			<%=fruits[i]%>
<%			if (i != fruits.length -1) {%>
				, 
				
<%			}
		} %>
	입니다.					
<%	}		
%>
</div>
</body>
</html>
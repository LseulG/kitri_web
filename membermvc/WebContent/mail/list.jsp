<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kitri.member.model.MemberDto"%>
<%
String root = request.getContextPath(); // root = '/membermvc'

MemberDto memberDto = (MemberDto) request.getAttribute("userInfo");
if(memberDto != null){
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<strong><%=memberDto.getName()%></strong>님 메일목록<br>
10. 안녕하세요 <br>
9. 하이 <br>
8. 안녕<br>
</body>
</html>
<%
} else {
	response.sendRedirect(root + "/user?act=mvlogin");
}
%>
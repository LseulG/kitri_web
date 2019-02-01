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
<a href="mailto:<%=memberDto.getEmailId() %>@<%=memberDto.getEmailDomain() %>"><%=memberDto.getName() %>(<%=memberDto.getId() %>)</a>님 환영합니다.<br>
이메일은 <%=memberDto.getEmailId() %>@<%=memberDto.getEmailDomain() %> 입니다.<br>		
</body>
</html>
<%
} else {
	response.sendRedirect(root + "/user?act=mvlogin");
}
%>
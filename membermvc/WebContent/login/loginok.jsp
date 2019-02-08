<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kitri.member.model.MemberDto"%>
<%
String root = request.getContextPath(); // root = '/membermvc'

MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
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
<a href="<%=root%>/user?act=mail">메일보기</a>	
<a href="<%=root%>/user?act=mvmodify">회원정보수정</a>	
<a href="<%=root%>/user?act=delete">회원탈퇴</a>	
<a href="<%=root%>/user?act=logout">로그아웃</a>	
</body>
</html>
<%
} else {
	response.sendRedirect(root + "/user?act=mvlogin");
}
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kitri.member.model.MemberDetailDto"%>
<%
String root = request.getContextPath(); // root = '/membermvc'

MemberDetailDto memberDetailDto = (MemberDetailDto) request.getAttribute("registerInfo");

if (memberDetailDto != null){
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<strong><%=memberDetailDto.getName() %></strong>님 회원 가입을 축하합니다.<br>
	가입 아이디는 <%=memberDetailDto.getId() %>이고 이메일은 <%=memberDetailDto.getEmailId() %>@<%=memberDetailDto.getEmailDomain() %> 입니다.<br>
	주소 : <%=memberDetailDto.getZipCode() %> <%=memberDetailDto.getAddress() %> <%=memberDetailDto.getAddressDetail() %><br>
	전화번호 : <%=memberDetailDto.getTel1() %>-<%=memberDetailDto.getTel2() %>-<%=memberDetailDto.getTel3() %><br>
	로그인 후 서비스를 이용할 수 있습니다.<br>
	<a href="<%=root %>/login/login.jsp">로그인</a>
</body>
</html>
<%
} else {
%>
<script>
alert("잘못된 URL 접근입니다.");
location.href = "<%=root%>/user";
</script>	
<%
}
%>
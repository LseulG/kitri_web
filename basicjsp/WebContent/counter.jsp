<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
int cnt;
int maxLength;

public void init(){
	cnt = 0;
	maxLength = 8;
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
	<%cnt++; %>
	당신은
	<%
	//String cntStr = Integer.toString(cnt);
	//String cntStr = cnt + "";
	String cntStr = String.valueOf(cnt);		
	for (int i=0; i<maxLength-cntStr.length(); i++) { 
	%><img src="/basicjsp/img/0.png" width="20"><% 	
	}		
	for (int i=0; i<cntStr.length(); i++) {
		char a = cntStr.charAt(i); 
		%><img src="/basicjsp/img/<%=a %>.png" width="20"><%	
	} %>번째 방문자 입니다.
</div>
</body>
</html>
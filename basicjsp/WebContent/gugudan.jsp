<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	int dan;
	int num;

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
	<h3>*** 구구단1 ***</h3>
	<table>
<% 	
	for (int i=2; i<10; i++){
		dan = i;
%>	
		<tr>
<%	
		for (int j=1; j<10; j++){
			num = j;
%>			
			<td>
			<% out.print(dan); %> * <% out.print(num); %> = <% out.print(dan*num); %>
			</td>
<%		}
%>
		</tr>
<%	}
%>
	</table>
	
	<h3>*** 구구단2 ***</h3>
	<table>
<% 	
	for (int i=2; i<10; i++){
		dan = i;	
		out.print("<tr>");	
		for (int j=1; j<10; j++){
			num = j;		
			out.print("<td>" + dan + "*" + num + "=" + dan*num + "</td>");	
		}
		out.print("</tr>");	
	}
%>
	</table>
	
	<h3>*** 구구단3 ***</h3>
	<table>
	<% for(int i=2; i<10; i++){
		dan = i; %>
		<tr>
		<% for(int j=1; j<10; j++){ 
			num = j;%>
			<td><%= dan %> * <%= num %> = <%= dan*num %></td>
		<% } %>
		</tr>
	<% } %>
	</table>
	</div>
</body>
</html>
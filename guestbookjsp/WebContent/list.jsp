<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String seq = request.getParameter("seq");
	String subject = request.getParameter("subject");
	String name = request.getParameter("name");
	String logtime = request.getParameter("logtime");
	String content = request.getParameter("content");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet\" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
	<script type="text/javascript">
	function pagewrite(){ 
		location.href="/guestbookservlet/write.html";	
	}
	</script>
</head>
<body>
	<div class="container" align="center">
		<h3>* 글목록 *</h3>
		<div class="col-lg-6" align="right">
			<button type="button" class="btn btn-outline-primary" onclick="javascript:pagewrite();">글쓰기</button>
		</div><br>
		<div class="col-lg-6" align="center">
			<table class="table table-condensed">
				<tr class="table-info"><td colspan="2"><%=seq %>. <%=subject%></td></tr>
				<tr><td>작성자: <%=name %></td>
					<td align="right">작성일: <%=logtime %></td></tr>
				<tr><td colspan="2"><%=content %></td></tr>
			</table><hr>
		</div><br>
	</div>
</body>
</html>
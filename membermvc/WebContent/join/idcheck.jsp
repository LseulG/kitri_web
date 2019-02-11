<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String root = request.getContextPath(); // root = '/membermvc'

String id = (String)request.getAttribute("id");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=root %>/css/style.css" type="text/css">
<script type="text/javascript">
function idcheck(){
	if(document.getElementById("id").value == "") {
		alert("검색 아이디 입력!");
		return;
	} else {
		document.idform.action = "<%=root%>/user";
		document.idform.submit();
	}
}

function iduse(id){
	opener.document.getElementById("id").value = id;
	self.close();
}
</script>
</head>
<body>
<div class="box3" align="center">
<form name="idform" method="get" action="" onsubmit="return false;">
<input type="hidden" name="act" value="idcheck">
<h3>아이디 중복 검사</h3>
<hr>

	<div class="div1" align="left">검색할 아이디를 입력하세요
	<div class="div2">
	<input type="text" name="id" id="id" onkeypress="javascript:if(event.keyCode == 13){ idcheck(); }">
	<input type="button" value="검색" onclick="javascript:idcheck();">
	</div>
<%
		if (id == null){
%>
		<div class="div3">
		<br>검색할 아이디를 입력하세요
		</div>
<%
		} else {
			int cnt = (Integer)request.getAttribute("cnt");
			
			if (cnt != 0) {
%>
			<div class="div3">
			<br><strong>"<%=id%>"</strong>는 이미 있는 아이디입니다.<br>
			</div>
<%
			} else {
%>		
			<div class="div3">
			<br><strong>"<%=id%>"</strong>는 사용가능한 아이디입니다.
			<input type="button" value="사용하기" onclick="javascript:iduse('<%=id%>');">
			</div>
<%
			}
		}
%>		
	</div>

</form>
</div>
</body>
</html>
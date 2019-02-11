<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String root = request.getContextPath(); // root = '/membermvc'

Cookie cookies[] = request.getCookies();
String sid = ""; /* null 말고 ""으로 */
String idck = "";
if (cookies != null) {
	for (Cookie cookie : cookies) {
		if (cookie.getName().equals("nid_sid"))	{
			sid = cookie.getValue();
			idck = "checked=\"checked\"";
			break;
		}
	}
}
%>
<!doctype html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="<%=root %>/css/style.css" type="text/css"> <!--"../css/style.css"-->
		<script type="text/javascript">
		function login() {
			var iderrorview = document.getElementById("idblank");;
			var passerrorview = document.getElementById("passblank");;
			//if(document.joinform.name.value == "") {
			if(document.getElementById("id").value.trim().length == 0) {
				iderrorview.innerHTML = "<font color='red'>아이디를 입력하세요.</font>";
				iderrorview.style = "display:";
				passerrorview.style = "display:none";
				return;
			} else if(document.getElementById("pass").value.trim().length == 0) {
				passerrorview.innerHTML = "<font color='red'>비밀번호를 입력하세요.</font>";
				passerrorview.style = "display:";
				iderrorview.style = "display:none" ;
				return;
			} else {
				document.getElementById("loginform").setAttribute("action", "<%=root %>/user");
				document.getElementById("loginform").submit();
			}
		}
			
		function mvjoin(){
			location.href = "<%=root %>/user?act=mvjoin";
		}

		</script>
	</head>

	<body>
	<div class="testbox box2">
		<h1>로그인</h1>
		<form name="loginform" id="loginform" method="post" action="">
		<input type="hidden" name="act" value="login">
		<hr>	
		<div class="accounttype" align = "left">
		<input type="checkbox" name="idsave" id="idsave" value="idsave" <%=idck %>>아이디저장<br>
		<input type="text" name="id" id="id" value="<%=sid %>" size="12" placeholder="ID"  required/>
		<div id="idblank" style="display: none;"></div>
		<input type="password" name="pass" id="pass" size="12" maxlength="12" placeholder="Password"  required/>
		<div id="passblank" style="display: none;"></div>
	    <br>
	    <input type="button" value="로그인" class="button" onclick="javascript:login();"/>&nbsp;&nbsp;
	    <input type="button" value="회원가입" class="button" onclick="javascript:mvjoin();"/>
	    </div>
		</form>  
	</div>
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String root = request.getContextPath(); // root = '/membermvc'
%>
<!doctype html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="<%=root %>/css/style.css" type="text/css">
		<script type="text/javascript">
			function join(){
				// 정규표현식 사용하기
				//if(document.joinform.name.value == "") {
				//if(document.getElementById("name").value == "") {
				if(document.getElementById("name").value.trim().length == 0) {
					alert("이름 입력!!!");
					return;
				} else if(document.getElementById("id").value.trim().length == 0) {
					alert("아이디 입력!!!");
					return;
				} else if(document.getElementById("pass").value.trim().length == 0) {
					alert("비밀번호 입력!!!");
					return;
				} else if(document.getElementById("pass").value != document.getElementById("passcheck").value) {
					alert("비밀번호 확인!!!");
					return;
				} else {
					document.getElementById("joinform").setAttribute("action","<%=root %>/user");
					document.getElementById("joinform").submit();
				}
			}	
		
			function openzip(){
				window.open("","","top=200, left=300, width=400, height=300, menubar=no, status=no, toolbar=no, location=no, scrollbars=yes");
			}
			
			function openidcheck(){
				window.open("","","top=200, left=300, width=400, height=180, menubar=no, status=no, toolbar=no, location=no, scrollbars=no");
			}
		</script>
	</head>
	
<body>
	<div class="testbox box1">
		<h1>회원가입</h1>
		<form name ="joinform" id = "joinform" method="post" action="">
		<input type="hidden" name="act" value="register">
		<hr>	
		<div class="accounttype" align = "left">
		필수입력<br>
		<input type="text" name="name" id="name" value="" size="12" placeholder="Name"  required/>
		<input type="text" name="id" id="id" value="" size="12" placeholder="ID"  required/>
		<input type="button" value="아이디중복검사">
	<!--    &nbsp;&nbsp;<font color="#3cb371">4~12</font>자이내 영문이나 숫자(영문은 대소문자를 구별하므로 주의해주세요</td>-->
		<input type="password" name="pass" id="pass" size="12" maxlength="12" placeholder="Password"  required/>
	<!--	&nbsp;&nbsp;<font color="#3cb371">6~12</font>자리의 영문(대소문자 구별)이나 숫자	-->
	    <input type="password" name="passcheck" id="passcheck" size="12" maxlength="12" placeholder="Check Password"  required/>
	    <br>
	    <select name="tel1" id="tel1">
				   <option value="">----</option>
			       <option value="010">010</option>
				   <option value="02">02</option>
				   <option value="031">031</option>
				   <option value="032">032</option>
				   <option value="041">041</option>
				   <option value="051">051</option>
				   <option value="061">061</option>
	    </select> -
	    <input type="text" name="tel2" id="tel2" value="" size="4" maxlength="4"  required/> -
	    <input type="text" name="tel3" id="tel3" value="" size="4" maxlength="4"  required/>
	    
	    
	    <input type="text" name="emailid" id="emailid" value="" placeholder="Email" required/> @
	    <!--<input type="text" name="direct" value="" size=12>-->
	    <select name="emaildomain" id="emaildomain">
	    <!--<option value="naver.com">직접입력</option>-->
	    <option value="naver.com">naver.com</option>
	    <option value="hanmail.net">hanmail.net</option>
	    </select>
	    <hr>
	    <div class="choice">선택입력 <br>
	    <input type="text" name="zipcode" id="zipcode" value="" maxlength="5">&nbsp;&nbsp;
	    <input type="button" value="우편번호검색">   
	    <input type="text" name="address" id= "address" value="" placeholder="Address" />
	    <input type="text" name="address_detail" id="address_detail" size="100" placeholder="Address2" />    
	    </div>
	    <br>
	    <input type="button" value="회원가입" class="button" onclick="javascript:join();"/>&nbsp;&nbsp;
	    <input type="reset" value="취소" class="button"/>
	    
	<!--
				<tr>
				 <td class="td2">주민등록번호<font color="red">*</font></td>
				 <td class="td4"><input type="text" name="reginum1" value="" size="12" maxlength="6"> -
				 <input type="text" name="reginum2" value="" size="12" maxlength="7"></td>
				</tr>
	
				<tr>
				 <td class="td1">닉네임(별명)<font color="red">*</font></td>
				 <td class="td3"><input type="text" name="nickname" value="" size="12">&nbsp;&nbsp; 실명을 사용하지 않는 서비스에서 사용되는 <font color="#3cb371">별명</font>입니다.<br>입력하지 않으실 경우 회원님의 이름이 등록됩니다.</td>
				</tr>
	-->
	<!--
	            <tr>
				 <td width="120" class="td1">비밀번호 재발급<font color="red">*</font><br>질문 선택</td>
				 <td class="td3">
				  <select name="question">
				   <option value="">가장 좋아하는 색상은?(예: 빨강)</option>
				   <option value="">어릴 적 단짝 친구의 이름은?</option>
				   <option value="">가장 좋아하는 음식은?</option>
				   <option value="">가장 여행하고 싶은 나라는?</option>
				   <option value="">기억에 남는 추억의 장소는?</option>
				   <option value="">가장 좋아하는 연예인은?</option>
				  <option value="">친구들에게 공개하지 않은 어릴 적 별명이 있다면?</option>
				  </select><br>
				  혹시 비밀번호를 잊어버리신 경우 여기에서 선택한 질문을 하게됩니다.
				 </td>
				</tr>
	
				<tr>
				 <td width="120" class="td2">비밀번호 재발급<font color="red">*</font><br>답변 입력</td> 
		         <td class="td4"><input type="text" name="answer" size="35"><br>
				 위에서 선택하신 질문에 대한 답변을 입력하세요.<br>
				 비밀번호를 잊어버리신 경우 이 답변을 이용하여 비밀번호를 재발급 받으실 수 있습니다.</td>
				</tr>
	-->
	<!--
				  유선전화&nbsp;<select name="tel1">
				   <option value="">----</option>
			       <option value="010">02</option>
				   <option value="010">031</option>
				   <option value="010">032</option>
				   <option value="010">033</option>
				   <option value="010">041</option>
				  </select> -
						<input type="text" name="tel2" value="" size="4" maxlength="4" > -
						<input type="text" name="tel3" value="" size="4" maxlength="4" >
						<input type="radio" name="location" value="집" checked>집
	        	        <input type="radio" name="location" value="회사">회사
						<br>휴대폰이나 유선전화 중에서 <font color="#3cb371">하나는 반드시 입력하셔야 합니다.</font>
	-->
	<!--			
				<tr>
				 <td class="td2">성별<font color="red">*</font></td> 
		         <td class="td4"><input type="radio" name="gender" value="남" checked>남자
	        	        <input type="radio" name="gender" value="여">여자</td>
				</tr>
	
				<tr>
				 <td class="td1">결혼여부<font color="red">*</font></td> 
		         <td class="td3"><input type="radio" name="married" value="미혼" checked>미혼 
					<input type="radio" name="married" value="기혼">기혼</td>
	        	   
				</tr>
	
				<tr>
				 <td class="td2">취미 & 관심사항</td>
				 <td class="td4"><input type="checkbox" name="컴퓨터">컴퓨터&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="게임">게임&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="음악">음악&nbsp;&nbsp;&nbsp;&nbsp;
					    <input type="checkbox" name="연예">연예&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="뉴스">뉴스&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="IT">IT&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="맛집">맛집&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="IT">맛집
				</tr>
	-->
	    </div>
	   </form>  
	</div>
	</body>
</html>
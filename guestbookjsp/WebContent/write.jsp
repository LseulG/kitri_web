<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		function contentwrite() {
			if (document.getElementById("name").value.trim().length == 0) {
				alert("작성자를 입력해주세요.");
				return;
			} 
 			else if (document.getElementById("subject").value.trim().length == 0) {
				alert("제목을 입력해주세요.")
				return;
			} else if (document.getElementById("content").value.trim().length == 0) {
				alert("내용을 입력해주세요.")
				return;
			} else {
				document.getElementById("writeform").setAttribute("action", "/guestbookservlet/write");
				document.getElementById("writeform").submit();
			} 
		}
		
		function pageback(){
			location.href="/guestbookservlet/index.html";
		}
	</script>
</head>

<body>
<div class="container" align="center">
	<div class="col-lg-6" align="center">
		<h3>* 글쓰기 *</h3><br>
		<form class="form-horizontal" name ="writeform" id = "writeform" method="post" action="">
			<div align="center" class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">작성자</label>
				<div class="col-sm-10"><input type="text" class="form-control" name="name" id="name" value="" placeholder="이름/별명"></div>
			</div>
			<div align="center" class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">제목</label>
				<div class="col-sm-10"><input type="text" class="form-control" name="subject" id="subject" value="" placeholder="제목"></div>
			</div>
			<div align="center" class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">내용</label>
				<div class="col-sm-10"><textarea class="form-control" rows="10" name="content" id="content" placeholder="내용"></textarea></div>
			</div>
			<div align="center" class="form-group">
				<button type="button" class="btn btn-outline-primary" onclick="javascript:contentwrite();">글쓰기</button>
				&nbsp;&nbsp;
				<button type="button" class="btn btn-outline-success" onclick="javascript:pageback();">돌아가기</button>
			</div>
		</form>
	</div>
</div>
</body>
</html>
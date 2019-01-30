<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		function pagewrite(){
			location.href="/guestbookservlet/write.html";
		}
		function pagelist(){
			location.href="/guestbookservlet/list";
		}
	</script>
</head>
</head>
<body>
<div class="container" align="center">
	<div class="col-lg-6" align="center">
	<h3>* 방명록 *</h3>
	<table class="table table-borderless">
		<tr>
			<td align="center">
				<button type="button" class="btn btn-outline-primary" onclick="javascript:pagewrite();">글쓰기</button>
				<button type="button" class="btn btn-outline-warning" onclick="javascript:pagelist();">글목록</button>
			</td>
		</tr>
	</table>
	</div>
</div>
</body>
</html>
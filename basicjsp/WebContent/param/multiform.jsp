<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
		<h3>JSP을 이용한 파라미터 전송.</h3>
		<form name="testform" method="GET" action="/basicjsp/param/multiparam.jsp">
		<table>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>연령</td>
				<td>
					<select name="age">
						<option value="10">10대
						<option value="20">20대
						<option value="30">30대
						<option value="40">40대
						<option value="50">50대
						<option value="60">60대 이상
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					좋아하는 과일?
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="checkbox" name="fruit" value="자몽">자몽
					<input type="checkbox" name="fruit" value="바나나">바나나
					<input type="checkbox" name="fruit" value="체리">체리
					<input type="checkbox" name="fruit" value="오렌지">오렌지
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="전송">
				</td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>
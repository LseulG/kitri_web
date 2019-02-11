<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,com.kitri.admin.board.model.BoardListDto"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.menu_list {
		width: 250px;
	}
	
	.menu_header {
		padding: 5px 10px;
		cursor: pointer;
		position: relative;
		font-weight: bold;
		background-color: #A566FF;
	}
	
	.menu_body {
		display: none;
		text-align: left;
	}
	
	.menu_body a {
		display: block;
		background-color: #B5B2FF;
		padding: 10px;
		color: black;
		text-decoration: none;
	}
	
	.menu_body a:hover {
		background-color: #C4FDFF;
		text-decoration: underline;
	}
	
	.test1 {
		font-size: 3px;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#menu p.menu_header").click(function() {
			$(this).next("div.menu_body").addClass("test1").slideDown(500).siblings("div.menu_body").slideUp("slow");
		});
	});
</script>
</head>
<body>
<div class="menu_list" id="menu">
<c:set var="root" value="${pageContext.request.contextPath}"/>
<c:set var="preCcode" value="0"/>
<c:if test="${boardmenu != null}">
	<c:forEach varStatus="i" var="boardListDto" items="${boardmenu}">
		<c:if test="${preCcode != boardListDto.ccode}">
			<p class="menu_header">${boardListDto.cname}</p>
			<div class="menu_body">
			<c:set var="preCcode" value="${boardListDto.ccode}"/>
		</c:if>
		
		<a href="${root}/${boardListDto.control}?act=mvwrite&bcode=${boardListDto.bcode}&pg=1&key=&word=">
			${boardListDto.bname}
		</a>
		
		<c:if test="${i.index < boardmenu.size()-1}">
			<c:if test="${preCcode != boardmenu.get(i.index+1).ccode}">
				</div>			
			</c:if>
		</c:if>
	</c:forEach>
</c:if>       
</div>
</body>
</html>


<%-- 기존 코드
<%
String root = request.getContextPath();

List<BoardListDto> boardmenu = (List<BoardListDto>) application.getAttribute("boardmenu");

int preCcode = 0;
if (boardmenu != null) {
	//for	(BoardListDto boardListDto : boardmenu) {
	int len = boardmenu.size();
	for (int i=0; i<len; i++){
		BoardListDto boardListDto = boardmenu.get(i);
		if (preCcode != boardListDto.getCcode()) {
%>        
			<p class="menu_header"><%=boardListDto.getCname() %></p>
			<div class="menu_body">
<%
			preCcode = boardListDto.getCcode();
		}
%>
		<a href="">
		&nbsp;&nbsp;<%=boardListDto.getBname() %>
		</a>
<%
		if (i < len-1) {
			if (preCcode != boardmenu.get(i+1).getCcode()){
%>
			</div>			
<%

			}
		}
	}
}
%>
</div>
</body>
</html>
--%>
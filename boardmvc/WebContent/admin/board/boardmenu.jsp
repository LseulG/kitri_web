<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,com.kitri.admin.board.model.BoardListDto"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
List<BoardListDto> boardmenu = (List<BoardListDto>) application.getAttribute("boardmenu");

int preCcode = 0;
if (boardmenu != null) {
	//for	(BoardListDto boardListDto : boardmenu) {
	int len = boardmenu.size();
	for (int i=0; i<len; i++){
		BoardListDto boardListDto = boardmenu.get(i);
		if (preCcode != boardListDto.getCcode()) {
%>        
<%=boardListDto.getCname() %><br>
<%
			preCcode = boardListDto.getCcode();
		}
%>			
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=boardListDto.getBname() %><br>
<%
	}
}
%>
</body>
</html>
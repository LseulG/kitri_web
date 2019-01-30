<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*, com.kitri.util.*"%>
<%!
int cnt;
int maxLength;

public void init(){
	cnt = 0;
	maxLength = 8;
	
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<%
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try{
		conn = DBConnection.makeConnection();
		String select = "select cnt from counter";
		
		pstmt = conn.prepareStatement(select);
		rs = pstmt.executeQuery();
		rs.next();
		cnt = rs.getInt("cnt");
		
		pstmt.close();
		String update = "update counter set cnt = cnt + 1";
		pstmt = conn.prepareStatement(update);
		pstmt.executeUpdate();	
	} catch (SQLException e) {
		// 내가 처리 해야 할 경우 작성. 아니면 알아서 처리 해준다.
		e.printStackTrace();
	} finally {
		DBClose.close(conn, pstmt, rs);
	}
%>
	당신은
	<%
	//String cntStr = Integer.toString(cnt);
	//String cntStr = cnt + "";
	String cntStr = String.valueOf(cnt);		
	for (int i=0; i<maxLength-cntStr.length(); i++) { 
	%><img src="/basicjsp/img/0.png" width="20"><% 	
	}		
	for (int i=0; i<cntStr.length(); i++) {
		char a = cntStr.charAt(i); 
		%><img src="/basicjsp/img/<%=a %>.png" width="20"><%	
	} %>번째 방문자 입니다.
</div>
</body>
</html>
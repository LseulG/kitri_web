<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kitri.util.*,java.sql.*,java.net.*" %>
<%
String root = request.getContextPath(); // root = '/membermvc'
%>
<%
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	
	int cnt = 0;
	
	String name = null;
	String emailid = null;
	String emaildomain = null;
	try {
		conn = DBConnection.makeConnection();
		
		String sql = "select name, emailid, emaildomain from member where id=? and pass=?";
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1,id);
		pstmt.setString(2,pass);
		
		rs = pstmt.executeQuery();
		
		if (rs.next()) {
			name = rs.getString("name");
			emailid = rs.getString("emailid");
			emaildomain = rs.getString("emaildomain");
			cnt = 1;
		}		
	} finally {
		DBClose.close(conn, pstmt, rs);
	}	
%>
	<%if (cnt != 0) {
			response.sendRedirect("/memberjsp/login/loginok.jsp?name="+URLEncoder.encode(name, "UTF-8")+"&id="+id+"&emailid="+emailid+"&emaildomain="+emaildomain);		
	}else {
			response.sendRedirect("/memberjsp/login/loginfail.jsp");		
	} %>
</body>
</html>
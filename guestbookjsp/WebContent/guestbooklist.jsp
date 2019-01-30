<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*,com.kitri.util.*"%>
<% 
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	int seq = 0;
	String name = null;
	String subject = null;
	String content = null;
	Date logtime = null;
	int cnt = 0;
	try {
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "html_user", "lim");
	
		String sql = "select seq,name,subject,content,logtime from guestbook order by seq desc";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
	
		while (rs.next()) {
			seq = rs.getInt("seq");
			name = rs.getString("name");
			subject = rs.getString("subject");
			content = rs.getString("content");
			logtime = rs.getDate("logtime");
	
			cnt++;
			
			out.println("<div class=\"col-lg-6\" align=\"center\">");
			out.println("<table class=\"table table-condensed\">");
			out.println("<tr class=\"table-info\"><td colspan=\"2\">" + seq + ". " + subject + "</td></tr>");
			out.println("<tr><td>작성자: " + name + "</td>");
			out.println("<td align=\"right\">작성일: " + logtime + "</td></tr>");
			out.println("<tr><td colspan=\"2\">" + content + "</td></tr>");
			out.println("</table><hr>");
			out.println("</div><br>");
	
		}	
	} finally {
		DBClose.close(conn, pstmt, rs);
	}
%>
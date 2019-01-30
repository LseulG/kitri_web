package com.kitri.guestbook;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/list")
public class GuestBookList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("driver loading error");
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!doctype html>");
		out.println("<html lang=\"ko\">");
		out.println(" <head>");
		out.println("  <meta charset=\"UTF-8\">");
		out.println("  <title>Document</title>");
		out.println("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css\">");
		out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>");
		out.println(" <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js\"></script>");
		out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js\"></script>");
		out.println("<script type=\"text/javascript\">");
		out.println("function pagewrite(){ location.href=\"/guestbookservlet/write.html\";	}");
		out.println("</script>");
		out.println(" </head>");
		out.println("<body>");
		out.println("<div class=\"container\" align=\"center\">");
		out.println("<h3>* 글목록 *</h3>");
		out.println("<div class=\"col-lg-6\" align=\"right\">");
		out.println("<button type=\"button\" class=\"btn btn-outline-primary\" onclick=\"javascript:pagewrite();\">글쓰기</button>");
		out.println("</div><br>");

//		2. logic
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
			// conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.18.33:1521:xe",
			// "kitri", "kitri");
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

			if (cnt == 0) {
				out.print("<font color=\"red\">"); // 실패
				out.print("작성된 글이 없습니다.<br>"); // 실패
				out.print("</font><br>"); // 실패
				out.print("<a href=\"/guestbookservlet/index.html\">첫화면</a>"); // 성공
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

//		3. response		
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}
}

package com.kitri.guestbook;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/write")
public class GuestBookWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("driver loading error");
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1. get data
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		content = content.replace("\r\n", "<br>");
		
//		2. logic
		Connection conn = null;
		
		PreparedStatement pstmt = null;
		
		int cnt = 0;
		try {
			//conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.18.33:1521:xe", "kitri", "kitri");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "html_user", "lim");

			String sql = "insert into guestbook(seq, name, subject, content, logtime) \n"
					+ "values(guestbook_seq2.nextval,?,?,?,sysdate) ";			
			pstmt = conn.prepareStatement(sql);
								
			int idx = 1;
			pstmt.setString(idx++, name);
			pstmt.setString(idx++, subject);
			pstmt.setString(idx++, content);
					
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
		out.println("function pagelist(){ location.href=\"/guestbookservlet/list\";	}");
		out.println("</script>");
		out.println(" </head>");
		out.println("<body>");
		out.println("<div class=\"container\" align=\"center\">");
		
		if (cnt != 0) {
			out.println("<h3>* 글작성 성공 *</h3>");
			out.println("<button type=\"button\" class=\"btn btn-outline-warning\" onclick=\"javascript:pagelist();\">글목록</button>");
		} else {			
			out.print("<font color=\"red\">"); //실패
			out.print("죄송합니다. 서버 문제로 서비스가 원활하지 않습니다."); //실패
			out.print("다음에 다시 이용해 주세요."); //실패
			out.print("</font>"); //실패
			out.println("<button type=\"button\" class=\"btn btn-outline-warning\" onclick=\"javascript:pagelist();\">글목록</button>");
		}
		
		out.println("</div>");		
		out.println("</body>");
		out.println("</html>");	
	}

}

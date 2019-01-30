package com.kitri.member;

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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
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
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
//		2. logic
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String name = null;
		String emailid = null;
		String emaildomain = null;
		int cnt = 0;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.18.33:1521:xe", "kitri", "kitri");

			String sql = "select id,name,emailid,emaildomain from member where id=? and pass=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				id = rs.getString("id");	
				name = rs.getString("name");	
				emailid = rs.getString("emailid");	
				emaildomain = rs.getString("emaildomain");	
				cnt = 1;
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
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");				
		out.println("<div align=\"center\">");
		
		if (cnt != 0) {
			out.print("<a href=\"\">"+ name + "(" + id + ")"+"</a>님 환영합니다.<br>"); //성공
			out.print("이메일은 "+ emailid +"@"+ emaildomain+"입니다.<br>"); //성공
			
		} else {			
			out.print("<font color=\"red\">"); //실패
			out.print("로그인에 실패하였습니다.<br>"); //실패
			out.print("아이디와 비밀번호를 확인해주세요."); //실패
			out.print("</font><br>"); //실패
			out.print("<a href=\"/memberservlet/login/login.html\">로그인</a>"); //성공
		}
		
		out.println("</div>");		
		out.println("</body>");
		out.println("</html>");	
	}
}

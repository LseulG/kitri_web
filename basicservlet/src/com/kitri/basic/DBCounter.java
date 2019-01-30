package com.kitri.basic;

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

@WebServlet("/dbcounter")
public class DBCounter extends HttpServlet {
	/*
	 * <DB>
	 * create table counter (cnt number);
	 * insert into counter values(1);
	 * commit; 
	 */
	private static final long serialVersionUID = 1L;
	int cnt;
	
	public void init() {
		// 제일 처음 딱 한번만 호출 됨.
		System.out.println("init 호출");
		cnt = 0;
		
		//1. Driver Loading
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("로딩 실패");
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 계속 새로고침, 방문 할때마다 호출
		System.out.println("doget 호출");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		try {
//			2. DB 접속 (Connection 생성)
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.18.33:1521:xe", "kitri", "kitri");

//			3. SQL 실행 준비. (PraparedStatement 생성)
			String select = "select cnt from counter";
			pstmt = conn.prepareStatement(select);
			
//			4. SQL 실행 (select : ResultSet 생성)
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt("cnt");	
			
			pstmt.close(); // 다음 쿼리를 위해 닫아줌			
			String update = "update counter set cnt = cnt + 1";
			pstmt = conn.prepareStatement(update);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("접속 실패");
			e.printStackTrace();
		} finally {
//			5. DB 접속 종료.
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
		
		// 당신은 X번째 방문자입니다.		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<div align=\"center\">");
		out.println("당신은 ");
		
		//out.println(cnt);
		String num = String.valueOf(cnt);		
		for (int i=0; i<8-num.length(); i++) {
			out.println("<img src=\"/basicservlet/img/0.png\" width=\"20\">");			
		}
		
		for (int i=0; i<num.length(); i++) {
			char a = num.charAt(i);
			out.println("<img src=\"/basicservlet/img/"+ a +".png\" width=\"20\">");			
		}
		
		out.println("번째 방문자입니다.");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");			
	}
}

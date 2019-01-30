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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
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
//		1. data get (이름, 아이디, 비번, 전번, 이메일, 주소, ....)
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String emailid = request.getParameter("emailid");
		String emaildomain = request.getParameter("emaildomain");
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		String tel3 = request.getParameter("tel3");
		String zipcode = request.getParameter("zipcode");
		String address = request.getParameter("address");
		String address_detail = request.getParameter("address_detail");
		
//		2. logic ( 1의 data를 DB insert)
		Connection conn = null;
		PreparedStatement pstmt = null;

		/*
		 * insert into member(id, name, pass, emailid, emaildomain, joindate) 
		 * value(?,?,?,?,?,sysdate)
		 * insert into member_detail(id, tel1, tel2, tel3, zipcode, address, address_detail) 
		 * value(?,?,?,?,?,?,?)
		 * >>>>
		 * insert all
		 * into member(id, name, pass, emailid, emaildomain, joindate) 
		 * value(?,?,?,?,?,sysdate)
		 * into member_detail(id, tel1, tel2, tel3, zipcode, address, address_detail) 
		 * value(?,?,?,?,?,?,?)
		 * select * from dual
		 * 
		 */
		int cnt = 0;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.18.33:1521:xe", "kitri", "kitri");

			String sql = "insert all \n" 
			+ "into member(id, name, pass, emailid, emaildomain, joindate) \n"
			+ "values(?,?,?,?,?,sysdate) \n"
			+ "into member_detail(id, tel1, tel2, tel3, zipcode, address, address_detail) \n"
			+ "values(?,?,?,?,?,?,?) \n"
			+ "select * from dual";			
			pstmt = conn.prepareStatement(sql);
						
			int idx = 1;
			pstmt.setString(idx++, id);
			pstmt.setString(idx++, name);
			pstmt.setString(idx++, pass);
			pstmt.setString(idx++, emailid);
			pstmt.setString(idx++, emaildomain);
			pstmt.setString(idx++, id);
			pstmt.setString(idx++, tel1);
			pstmt.setString(idx++, tel2);
			pstmt.setString(idx++, tel3);
			pstmt.setString(idx++, zipcode);
			pstmt.setString(idx++, address);
			pstmt.setString(idx++, address_detail);
			
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("DB connect error");
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
		// insert 성공
		// ㅇㅇㅇ님 회원 가입을 축하합니다.
		// 가입 아이디는 ㅇㅇㅇ이고 이메일은 ㅇㅇㅇ@ㅇㅇㅇ.ㅇㅇ입니다.
		// 로그인 후 서비스를 이용할 수 있습니다.
		// 로그인 (-> 로그인페이지 이동)
		
		// insert 실패
		// 죄송합니다. 서버 문제로 서비스가 원활하지 않습니다.
		// 다음에 다시 이용해 주세요.
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");				
		out.println("<div align=\"center\">");
		
		if (cnt != 0) {
			out.print("<strong>"+ name + "</strong>님 회원 가입을 축하합니다.<br>"); //성공
			out.print("가입 아이디는 "+ id +"이고 이메일은 "+ emailid +"@"+ emaildomain+"입니다.<br>"); //성공
			out.print("로그인 후 서비스를 이용할 수 있습니다.<br>"); //성공
			out.print("<a href=\"/memberservlet/login/login.html\">로그인</a>"); //성공
		} else {			
			out.print("<font color=\"red\">"); //실패
			out.print("죄송합니다. 서버 문제로 서비스가 원활하지 않습니다."); //실패
			out.print("다음에 다시 이용해 주세요."); //실패
			out.print("</font>"); //실패
		}
		
		out.println("</div>");		
		out.println("</body>");
		out.println("</html>");		
		
	}

}

package com.kitri.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/param")
public class ParameterTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET 방식 호출!!!");
		
//		 1. data get (이름(한글 처리), 성별) - get 방식은 한글 처리를 하나하나 다 처리해줘야함
		String name = new String(request.getParameter("name").getBytes("ISO-8859-1"), "UTF-8");
		String gender = request.getParameter("gender");
		
//		 2. logic (남:파랑, 여:주황) - 나중에 DB가 들어감.
		String color = "cyan";
		if (gender.equals("여")) {
			color = "pink";
		}
		
//		 3. response page (html) (xxx님 안녕하세요.)
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<div align=\"center\">");
		out.println("<font color=\"" + color + "\">" + name + "</font>님 안녕하세요.");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");	
	}
	
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST 방식 호출!!!");
		
//		 1. data get (이름, 성별)
		request.setCharacterEncoding("UTF-8"); // 한글 처리
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		
//		 2. logic (남:파랑, 여:주황) - 나중에 DB가 들어감.
		String color = "cyan";
		if (gender.equals("여")) {
			color = "pink";
		}
		
//		 3. response page (html) (xxx님 안녕하세요.)
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<div align=\"center\">");
		out.println("<font color=\"" + color + "\">" + name + "</font>님 안녕하세요.");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");	
	}
}


/*
 * Tomcat 7 이하 한글처리(GET 방식)
 * String name = request.getParameter("name");
 * byte b[] = name.getByte("ISO-8859-1");
 * name = new String(b, "UTF-8");
 */

/*
 * public static String isoToUtf(String tmp) {
	String utf = "";
	if (tmp != null) {
		utf = new String(tmp.getBytes("ISO-8859-1"), "UTF-8");
	}
	return utf;
	}
	
	위 메서드 만들어 놓고 한글 깨지는 곳에 호출.
 */














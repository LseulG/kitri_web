package com.kitri.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hs")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String name;
	public void init() {
		name = "슬슬슬";
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<div align=\"center\">");
		out.println("Hello Servlet!!!!!!!!!!!!!!!!!!!!");
		out.println("안녕 " + name + "!!!!<br>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");	
	}
}

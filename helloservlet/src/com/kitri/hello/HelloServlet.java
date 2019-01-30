package com.kitri.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<div align=\"center\">");
		out.println("Hello Servlet22222222 히히!!!!!!!!!!!!!!!!!!!!<br>");
		out.println("Hello Servlet22222222 히히!!!!!!!!!!!!!!!!!!!!");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");	
	}

}

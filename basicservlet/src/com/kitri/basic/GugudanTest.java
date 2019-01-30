package com.kitri.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gt")
public class GugudanTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		 1. data get 
		int dan = Integer.parseInt(request.getParameter("dan"));
		
//		 2. logic
		
//		 3. response page (html)
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");				
		out.println("<div align=\"center\">");
		out.println("<h3>*** " + dan +"단 ***</h3>");
		
		for (int i=1; i<10; i++) {
			out.println("<p>" + dan + " * " + i + " = " + dan*i + "</p>");			
		}

		out.println("</div>");		
		out.println("</body>");
		out.println("</html>");	
	
	}
}



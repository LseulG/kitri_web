package com.kitri.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ggd")
public class Gugudan extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<div align=\"center\">");
		out.println("<table>");
		out.println("<caption>구구단</caption>");
				
		for(int i=2; i<10; i++) {
			String color = i%2 == 0 ? "pink" : "cyan";
			
			out.println("	<tr>");				
			for(int j=1; j<10; j++) {			
//				if (i%2 == 0) {
//					out.println("		<td><font color=\"red\">"+i+"*"+j+"="+i*j+"</font></td>");					
//				} else {
//					out.println("		<td><font color=\"blue\">"+i+"*"+j+"="+i*j+"</font></td>");					
//				}
				out.println("		<td bgcolor=\""+color + "\" align= \"center\">" +i+"*"+j+"="+i*j+"</font></td>");					
			}
			out.println("	</tr>");
		}

		out.println("</table>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");	
	}

}
package com.kitri.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/multiparam")
public class MultiParameter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 응답 화면
		 * 10대 빨강, 아닐때는 파랑
		 * 이름(20대)님이 좋아하는 과일은 자몽, 체리, 오렌지입니다.
		 * 이름(20대)님이 좋아하는 과일은 자몽입니다.
		 * 이름(20대)님이 좋아하는 과일은 없습니다.
		 *  
		 */
	
//		 1. data get 
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		//int age = Integer.parseInt(request.getParameter("age"));
		String[] fruits = request.getParameterValues("fruit");
		
//		 2. logic
		String color = age.equals("10") ? "orange" : "blue";
		age = age.equals("60") ? age+"대이상" : age+"대";
		
//		 3. response page (html)
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");				
		out.println("<div align=\"center\">");
		out.println("<font color=\""+ color +"\">");		
		out.println(name + "(" + age + ")님이 좋아하는 과일은 ");					
		
//		if (fruits == null) {
//			out.println("없습니다.");		
//		} else {
//			out.println(fruits[0]);			
//			for (int i = 1; i<fruits.length; i++) {
//				out.println(", " + fruits[i]);			
//			}
//			out.println("입니다.");						
//		}
		
		if (fruits == null) {
			out.println("없습니다.");		
		} else {
			for (int i = 0; i<fruits.length; i++) {
				out.println(fruits[i]);
				if (i != fruits.length -1) {
					out.println(", ");								
				}
			}
			out.println("입니다.");						
		}
		
		out.println("</div>");		
		out.println("</body>");
		out.println("</html>");		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

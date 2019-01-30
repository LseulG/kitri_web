package com.kitri.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/counter")
public class Counter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int cnt;
	
	public void init() {
		// 제일 처음 딱 한번만 호출 됨.
		System.out.println("init 호출");
		cnt = 0;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 계속 새로고침, 방문 할때마다 호출
		System.out.println("doget 호출");
		cnt++;
		
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

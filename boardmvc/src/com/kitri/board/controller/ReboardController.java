package com.kitri.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.util.BoardConstance;
import com.kitri.util.PageMove;

@WebServlet("/reboard")
public class ReboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		
		int bcode = Integer.parseInt(request.getParameter("bcode"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		String key = request.getParameter("key");
		String word = request.getParameter("word");		
		
		String path = "/index.jsp";
		if ("mvwrite".equals(act)) {
			path = "reboard/write.jsp?bcode=" + bcode + "&key=" + key + "&word=" + word;
			PageMove.redirect(request, response, path);
		} else if ("".equals(act)) {
			
		} else if ("".equals(act)) {
			
		} else if ("".equals(act)) {
			
		} else if ("".equals(act)) {
			
		} else if ("".equals(act)) {
			
		} else if ("".equals(act)) {
			
		} else if ("".equals(act)) {
			
		} else if ("".equals(act)) {
			
		} else if ("".equals(act)) {
			
		} else {
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(BoardConstance.ENCODER);
		doGet(request, response);
	}

}

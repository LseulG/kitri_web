package com.kitri.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.member.model.MemberDetailDto;
import com.kitri.member.model.service.MemberService;
import com.kitri.member.model.service.MemberServiceImpl;
import com.kitri.util.SiteConstance;

@WebServlet("/user")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	MemberService memberService;
	
	public void init() {
		memberService = new MemberServiceImpl();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String root = request.getContextPath();
		
		String act = request.getParameter("act");
		
		if ("mvjoin".equals(act)) {
			response.sendRedirect(root + "/join/member.jsp");
		} else if ("mvlogin".equals(act)) {
			response.sendRedirect(root + "/login/login.jsp");
		} else if ("register".equals(act)) {
			MemberDetailDto memberDetailDto = new MemberDetailDto();
			
			memberDetailDto.setName(request.getParameter("name"));
			memberDetailDto.setId(request.getParameter("id"));
			memberDetailDto.setPass(request.getParameter("pass"));
			memberDetailDto.setEmailId(request.getParameter("emailid"));
			memberDetailDto.setEmailDomain(request.getParameter("emaildomain"));
			memberDetailDto.setTel1(request.getParameter("tel1"));
			memberDetailDto.setTel2(request.getParameter("tel2"));
			memberDetailDto.setTel3(request.getParameter("tel3"));
			memberDetailDto.setZipCode(request.getParameter("zipcode"));
			memberDetailDto.setAddress(request.getParameter("address"));
			memberDetailDto.setAddressDetail(request.getParameter("address_detail"));
			System.out.println(memberDetailDto);
			
			int cnt = memberService.register(memberDetailDto);
			String path = cnt != 0 ? "/join/registerok.jsp" : "/join/registerfail.jsp";
			
			response.sendRedirect(root + path);			
		} else {
			response.sendRedirect(root + "/index.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(SiteConstance.CHARSET);
		doGet(request, response);
	}

}

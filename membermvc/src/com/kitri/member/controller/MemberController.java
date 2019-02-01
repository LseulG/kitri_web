package com.kitri.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.member.model.MemberDetailDto;
import com.kitri.member.model.MemberDto;
import com.kitri.member.model.ZipCodeDto;
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
		} else if ("mvidcheck".equals(act)) {
			response.sendRedirect(root + "/join/idcheck.jsp");
		} else if ("idcheck".equals(act)) {
			String id = request.getParameter("id");
			int cnt = memberService.idCheck(id);
			System.out.println("검색한 아이디 : " + id + " , 카운터 : " + cnt);
							
			//response.sendRedirect(root + "/join/idcheck.jsp?id="+id+"&cnt="+cnt);
			
			request.setAttribute("id", id);
			request.setAttribute("cnt", cnt);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/join/idcheck.jsp");
			dispatcher.forward(request,response);
			
		} else if ("mvzip".equals(act)) {	// 검색창으로 이동
			response.sendRedirect(root + "/join/zipsearch.jsp");
		} else if ("zipsearch".equals(act)) {	// 검색해라
			String doro = request.getParameter("doro");
			List<ZipCodeDto> list = memberService.zipSearch(doro);
			System.out.println("검색 갯수 : " + list.size());
			
			// list를 가지고 이동해야 해서 response.sendRedirect 안씀
			request.setAttribute("ziplist", list);	
			request.setAttribute("doro", doro);	
			RequestDispatcher dispatcher = request.getRequestDispatcher("/join/zipsearch.jsp");
			dispatcher.forward(request,response);
			
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
		} else if ("mvmodify".equals(act)) {
			response.sendRedirect(root + "/.jsp");
		} else if ("modify".equals(act)) {
			response.sendRedirect(root + "/.jsp");
		} else if ("delete".equals(act)) {
			response.sendRedirect(root + "/.jsp");
		} else if ("login".equals(act)) {
			String id = request.getParameter("id");
			String pass = request.getParameter("pass");
			
			MemberDto memberdto = memberService.login(id, pass);	
			String path = memberdto != null ? "/login/loginok.jsp" : "/login/loginfail.jsp";
			request.setAttribute("userInfo", memberdto);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request,response);
			
		} else if ("logout".equals(act)) {
			response.sendRedirect(root + "/index.jsp");
		} else if ("".equals(act)) {
			response.sendRedirect(root + "/.jsp");
		} else {
			response.sendRedirect(root + "/.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(SiteConstance.CHARSET);
		doGet(request, response);
	}

}

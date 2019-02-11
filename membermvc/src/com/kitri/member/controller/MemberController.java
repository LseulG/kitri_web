package com.kitri.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kitri.member.model.MemberDetailDto;
import com.kitri.member.model.MemberDto;
import com.kitri.member.model.ZipCodeDto;
import com.kitri.member.model.service.MemberService;
import com.kitri.member.model.service.MemberServiceImpl;
import com.kitri.util.PageMove;
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
		
		String path = "/index.jsp";
		
		if ("mvjoin".equals(act)) {
			PageMove.redirect(request, response, "/join/member.jsp");
		} else if ("mvlogin".equals(act)) {
			PageMove.redirect(request, response, "/login/login.jsp");
		} else if ("mvidcheck".equals(act)) {
			PageMove.redirect(request, response, "/join/idcheck.jsp");
		} else if ("idcheck".equals(act)) {
			String id = request.getParameter("id");
			int cnt = memberService.idCheck(id);
			System.out.println("검색한 아이디 : " + id + " , 카운터 : " + cnt);
							
			//response.sendRedirect(root + "/join/idcheck.jsp?id="+id+"&cnt="+cnt);
			
			request.setAttribute("id", id);
			request.setAttribute("cnt", cnt);
			
			PageMove.forward(request, response, "/join/idcheck.jsp");
			
		} else if ("mvzip".equals(act)) {	// 검색창으로 이동
			PageMove.redirect(request, response,  "/join/zipsearch.jsp");
		} else if ("zipsearch".equals(act)) {	// 검색해라
			String doro = request.getParameter("doro");
			List<ZipCodeDto> list = memberService.zipSearch(doro);
			System.out.println("검색 갯수 : " + list.size());
			
			// list를 가지고 이동해야 해서 response.sendRedirect 안씀
			request.setAttribute("ziplist", list);	
			request.setAttribute("doro", doro);	
			PageMove.forward(request, response, "/join/zipsearch.jsp");
			
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
			if (cnt != 0) {
				path = "/join/registerok.jsp";
				request.setAttribute("registerInfo", memberDetailDto);
				PageMove.forward(request, response, path);
			} else {
				path = "/join/registerfail.jsp";
				PageMove.redirect(request, response, path);
			}
		} else if ("mvmodify".equals(act)) {
			HttpSession session = request.getSession();
			MemberDto memberDto = (MemberDto)session.getAttribute("userInfo");
			MemberDetailDto memberDetailDto = memberService.getMember(((MemberDto)session.getAttribute("userInfo")).getId());
			
			PageMove.redirect(request, response, "/join/modify.jsp");
		} else if ("modify".equals(act)) {
			// session 에서 id 가져오기			
			HttpSession session = request.getSession();
			MemberDto memberDto = (MemberDto)session.getAttribute("userInfo");
			
			
			PageMove.redirect(request, response, "/.jsp");
		} else if ("delete".equals(act)) {
			PageMove.redirect(request, response, "/.jsp");
		} else if ("login".equals(act)) {
			String id = request.getParameter("id");
			String pass = request.getParameter("pass");
			
			MemberDto memberdto = memberService.login(id, pass);
			
			if (memberdto != null) {
				// session
				HttpSession session = request.getSession();
				session.setAttribute("userInfo", memberdto);
				
				// cookie
				String idsave = request.getParameter("idsave");
				if ("idsave".equals(idsave)) {
					System.out.println("쿠키 굽는다~");
					Cookie cookie = new Cookie("nid_sid", id);
					cookie.setPath(root);
					cookie.setMaxAge(60*60*24*365*100); // 쿠키 만들어짐
					response.addCookie(cookie); // 이거 안쓰면 쿠키 아무 쓸모 없음 ~ 

					// 여러개 만들 수 있음!
//					Cookie cookie2 = new Cookie("nid_sid", id);
//					cookie2.setPath(root);
//					cookie2.setMaxAge(60*60*24*365*100); 
//					response.addCookie(cookie2);
				} else {
					Cookie cookies[] = request.getCookies();
					if (cookies != null) {
						for (Cookie cookie : cookies) {
							if (cookie.getName().equals("nid_sid"))	{
								cookie.setPath(root);
								cookie.setMaxAge(0); // 이 쿠키 없애라!
								response.addCookie(cookie);
								break;
							}
						}
					}
				}
				
				path = "/login/loginok.jsp";
			} else {
				path = "/login/loginfail.jsp";
			}
			
			PageMove.redirect(request,response,path);
		} else if ("logout".equals(act)) {
			HttpSession session = request.getSession();
			// session 지우는 방법 3가지
//			session.setAttribute("userInfo", null); 	// 1. null을 집어넣어라
//			session.removeAttribute("userInfo"); 		// 2. 지워라
			session.invalidate(); 				// 3. session 여러개일때 초기화. 즉 싹 다 지워라
			PageMove.redirect(request, response, "/index.jsp");
		} else if ("mail".equals(act)) {
			PageMove.redirect(request, response, "/mail/list.jsp");
		} else {
			PageMove.redirect(request, response, path);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(SiteConstance.CHARSET);
		doGet(request, response);
	}

}

package com.mg.jsp.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mg.jsp.member.model.dto.MgDTO;
import com.mg.jsp.member.model.service.MgService;

@WebServlet("/member/login")
public class MeberLogin extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/member/login.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		getEmail("namgyu1020@naver.com");
//		System.out.println("메일 보냄");
		
		String memberId = request.getParameter("memberId");
		String memberPwd = request.getParameter("memberPwd");
		
		System.out.println("memberId : " + memberId);
		System.out.println("memberPwd : " + memberPwd);
		
		MgDTO requestMember = new MgDTO();
		requestMember.setId(memberId);
		requestMember.setPwd(memberPwd);
		
		MgService memberService = new MgService();
		MgDTO loginMember = memberService.loginCheck(requestMember);
		
		System.out.println("loginMember : " + loginMember);
		
		if(loginMember != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", loginMember);
			
			response.sendRedirect(request.getContextPath());
		} else {
			request.setAttribute("message", "로그인실패!");
			request.getRequestDispatcher("/WEB-INF/views/common/faild").forward(request, response);
		}
		
	}

}

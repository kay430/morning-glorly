package com.jihunh.jsp.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jihunh.jsp.member.model.dto.MgDTO;
import com.jihunh.jsp.member.model.service.MgService;

@WebServlet("/admin/mainIndex")
public class AdminIndex extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/main/startAdmin.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adminId = request.getParameter("adminId");
		String adminPwd = request.getParameter("adminPwd");
		
		System.out.println("memberId : " + adminId);
		System.out.println("memberPwd : " + adminPwd);
		
		MgDTO requestMember = new MgDTO();
		requestMember.setId(adminId);
		requestMember.setPwd(adminPwd);
		
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
		

		String path = "/WEB-INF/views/main/startAdmin.jsp";
		request.getRequestDispatcher(path).forward(request, response);
		
	}


}

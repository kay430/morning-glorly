package com.jihunh.jsp.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jihunh.jsp.admin.model.dto.MgAdDTO;
import com.jihunh.jsp.admin.model.service.MgAdService;

@WebServlet("/admin")
public class LoginAdmin extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/admin/loginAdmin.jsp";
		request.getRequestDispatcher(path).forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adminId = request.getParameter("adminId");
		String adminPwd = request.getParameter("adminPwd");
		
		System.out.println("memberId : " + adminId);
		System.out.println("memberPwd : " + adminPwd);
		
		MgAdDTO requestMember = new MgAdDTO();
		requestMember.setId(adminId);
		requestMember.setPwd(adminPwd);
		
		MgAdService memberService = new MgAdService();
		MgAdDTO loginMember = memberService.loginCheck(requestMember);
		
		System.out.println("loginMember : " + loginMember);
		String path = "";
		if(loginMember != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", loginMember);
			path = "/WEB-INF/views/common/admin/successAd.jsp";	
			request.setAttribute("successCode", "loginAdmin");
		} else {
			//request.setAttribute("message", "failedLogin");
			path = "/WEB-INF/views/common/admin/errorLogin.jsp";
		}
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}

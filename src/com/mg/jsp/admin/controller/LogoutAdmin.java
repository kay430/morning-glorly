package com.mg.jsp.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mg.jsp.admin.model.dto.MgAdDTO;

@WebServlet("/admin/logout")
public class LogoutAdmin extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		MgAdDTO loginMember = (MgAdDTO) session.getAttribute("loginMember");
		System.out.println("세션에 있는 값 : " + loginMember);
		
		if(session != null) {
			request.getSession().invalidate();
			request.getSession(true);
		} 
		
		System.out.println("삭제 후  값 : " + loginMember);
		
		response.sendRedirect(request.getContextPath() + "/" + "admin");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}

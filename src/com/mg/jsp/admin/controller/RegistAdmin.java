package com.jihunh.jsp.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jihunh.jsp.admin.model.dto.MgAdDTO;
import com.jihunh.jsp.admin.model.service.MgAdService;

@WebServlet("/admin/regist")
public class RegistAdmin extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/admin/registAdmin.jsp";
		request.getRequestDispatcher(path).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberName = request.getParameter("adminName");
		String memberId = request.getParameter("adminId");
		String memberPwd = request.getParameter("adminPwd");
		String memberPno = request.getParameter("adminPno");
		String email = request.getParameter("email");
		
		MgAdDTO requestAdmin = new MgAdDTO();
		requestAdmin.setName(memberName);
		requestAdmin.setId(memberId);
		requestAdmin.setPwd(memberPwd);
		requestAdmin.setPno(memberPno);
		requestAdmin.setEmail(email);
		request.setAttribute("requestAdmin", requestAdmin);
		
		int result = new MgAdService().registMember(requestAdmin);
		
		String path = "";
		if(result > 0) {
			//path = "/WEB-INF/views/main/success.jsp";
			path = "/WEB-INF/views/admin/loginAdmin.jsp";
			//request.setAttribute("successCode", "insertMember");
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "회원 입구컷");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}

























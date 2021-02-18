package com.jihunh.jsp.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jihunh.jsp.member.model.dto.MgDTO;
import com.jihunh.jsp.member.model.service.MgService;


@WebServlet("/member/findId")
public class MemberFindId extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String path = "/WEB-INF/views/member/idFind.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//아이디찾기를 위한 멤버이름 과 핸드폰번호
		String memberName = request.getParameter("memberName");
		String memberPhone = request.getParameter("Phone2").replace("-", "");
		System.out.println("왓니");
		
		System.out.println("memberName : " + memberName);
		System.out.println("memberPhone : " + memberPhone);
		
		MgDTO requestMember = new MgDTO();
		requestMember.setId(memberName);
		requestMember.setPhone(memberPhone);
		
		MgService memberService = new MgService();
		
		MgDTO loginMember = memberService.findId(requestMember);
		
		System.out.println("loginMember : " + loginMember);
		
		
		
	}

}

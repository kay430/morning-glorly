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
		String phone = request.getParameter("Phone2").replace("-", "");
		
		System.out.println("memberName : " + memberName);
		System.out.println("phone : " + phone);
		MgDTO requestMember = new MgDTO();
		
		requestMember.setName(memberName);
		requestMember.setPhone(phone);
		
		MgService memberService = new MgService();
		MgDTO loginMember = memberService.findId(requestMember);
		
		System.out.println("아이디가져왓냐loginMember" + loginMember);
		
		String path = "";
		if(loginMember != null) {
			 path = "/WEB-INF/views/main/success.jsp";
	         request.setAttribute("successCode", "FindId");
	         request.setAttribute("loginMember", loginMember);
	         request.setAttribute("memberName", memberName);
	         System.out.println(loginMember);
	      } else {
	         path = "/WEB-INF/views/common/failed.jsp";
	         request.setAttribute("message", "잘못된정보입니다");
	      }
	      request.getRequestDispatcher(path).forward(request, response);
		}
		
		
		
	}



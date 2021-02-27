package com.mg.jsp.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mg.jsp.member.model.dto.MgDTO;
import com.mg.jsp.member.model.service.MgService;


@WebServlet("/mypage/quitMember")
public class MypageQuitMember extends HttpServlet {
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("여기야111");
		String path = "/WEB-INF/views/mypage/quitMember.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int memberNo = ((MgDTO) request.getSession().getAttribute("loginMember")).getNo();
		String memberId = request.getParameter("memberId");
		String memberPwd = request.getParameter("memberPwd");
		
		MgDTO requestMember = new MgDTO();
		requestMember.setNo(memberNo);
		requestMember.setId(memberId);
		requestMember.setPwd(memberPwd);
		System.out.println("!!!!");
		System.out.println("requestMember : " + requestMember);
		
		int result = new MgService().deleteMember(requestMember);
		
		String path = "";
		if(result > 0) {
			path = "/WEB-INF/views/main/success.jsp";
			request.setAttribute("successCode", "deleteMember");
			request.getSession().invalidate();
		} else {
			path = "/WEB-INF/views/main/failed.jsp";
			request.setAttribute("message", "회원 탈퇴에 실패하셨습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}

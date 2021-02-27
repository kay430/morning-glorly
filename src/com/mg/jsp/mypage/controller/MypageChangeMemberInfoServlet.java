package com.jihunh.jsp.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jihunh.jsp.member.model.dto.MgDTO;
import com.jihunh.jsp.member.model.service.MgService;

 
@WebServlet("/change/memberInfo")
public class MypageChangeMemberInfoServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/WEB-INF/views/mypage/changeMemberinfo.jsp";
		request.getRequestDispatcher(path).forward(request, response);
			System.out.println("정보수정페이지에왔니");
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("싫행잘댔나");
		HttpSession session = request.getSession();
		MgDTO loginMember = (MgDTO) session.getAttribute("loginMember");
		int memberNo = loginMember.getNo();
		
		String memberId = request.getParameter("memberId");
		String memberPwd = request.getParameter("memberPwd");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("zipCode") + "$" + request.getParameter("address1") + "$" + request.getParameter("address2");
		
		MgDTO changeInfo = new MgDTO();
		changeInfo.setNo(memberNo);
		changeInfo.setId(memberId);
		changeInfo.setPwd(memberPwd);
		changeInfo.setName(name);
		changeInfo.setPhone(phone);
		changeInfo.setEmail(email);
		changeInfo.setAddress(address);
		
		System.out.println("changeInfo : " + changeInfo);
		
		MgService memberService = new MgService();
		MgDTO changeMember = memberService.updateMember(changeInfo);
		
		System.out.println(changeMember);
		String path = "";
		if(changeMember != null) {
			path = "/WEB-INF/views/main/success.jsp";
			request.setAttribute("successCode", "updateMember");
			request.getSession().setAttribute("loginMember", changeMember);
		} else {	
			path = "/WEB-INF/views/main/failed.jsp";
			request.setAttribute("message", "회원 정보 수정 실패");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	
	}

}

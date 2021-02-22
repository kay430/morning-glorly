package com.jihunh.jsp.admin.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jihunh.jsp.admin.model.service.MemberService;
import com.jihunh.jsp.admin.model.service.NoticeService;
import com.jihunh.jsp.member.model.dto.MgDTO;

@WebServlet("/admin/member/manage/detail")
public class DetailMember extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		int pageNumNo = no;
		
		MgDTO mgDetail = new MemberService().viewMemberDetailInfo(no);
		
		System.out.println("주서온 글과 이미지 : " + mgDetail);
		
		String path = "";
		if(mgDetail != null) {
			path = "/WEB-INF/views/admin/DetailNotice.jsp";
			request.setAttribute("mgDetail", mgDetail);
			request.setAttribute("pageNumNo", pageNumNo);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "공지사항 상세 보기 조회에 실패하셨습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}

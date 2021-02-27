package com.mg.jsp.review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jihunh.jsp.member.model.dto.MgDTO;
import com.jihunh.jsp.review.dto.ReviewDTO;
import com.jihunh.jsp.review.service.ReviewService;

/**
 * Servlet implementation class CustomerReviewUpdateServlet
 */
@WebServlet("/review/update")
public class CustomerReviewUpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/review/reviewUpdate.jsp";
		request.getRequestDispatcher(path).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* 회원의 비밀번호가 일치하는 경우에는 회원의 정보를 수정한다.
		 * 회원 정보는 회원번호가 일치하는 회원의 속성값을 전달받은 모든 파라미터로 업데이트 한다.
		 * 정상적으로 회원 정보를 업데이트 한 경우에는 변경된 회원 정보를 DB에서 다시 조회해온다.
		 * 조회한 회원 정보를 session에 동일한 key로 담아준 후 success.jsp로 updateMember라는 코드를 보내 alert를 띄운 후
		 * 회원 정보를 수정하는 페이지로 (/member/update) 경로를 이동시킨다.
		 * */
		HttpSession session = request.getSession();
		MgDTO loginMember = (MgDTO) session.getAttribute("loginMember");
		
		System.out.println(loginMember);
		
		String reviewTitle = request.getParameter("title");
		String reviewBody = request.getParameter("body");
		
		ReviewDTO changeInfo = new ReviewDTO();
		changeInfo.setTitle(reviewTitle);
		changeInfo.setBody(reviewBody);
		changeInfo.setWriterMemberNo(loginMember.getNo());
		System.out.println("changeInfo : " + changeInfo);
		
		
		int result = new ReviewService().updateMemberNo(changeInfo);
		
		String path = "";
		if(result > 0) {
			path = "/WEB-INF/views/main/success.jsp";
			request.setAttribute("successCode", "updateMemberNo");
			} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "회원 정보 수정 실패");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
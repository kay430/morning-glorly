package com.jihunh.jsp.review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jihunh.jsp.member.model.dto.MgDTO;
import com.jihunh.jsp.review.dto.ReviewDTO;
import com.jihunh.jsp.review.service.ReviewService;


@WebServlet("/review/insert")
public class CustomerReviewInsert extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/WEB-INF/views/review/reviewinsert.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String body = request.getParameter("body");
		String writer = request.getParameter("writer");
		int writerMemberNo = ((MgDTO) request.getSession().getAttribute("loginMember")).getNo();
		
		System.out.println("title : " + title);
		System.out.println("body : " + body);
		System.out.println("writer : " + writer);
		System.out.println("writerMemberNo : " + writerMemberNo);
		
		ReviewDTO newReview = new ReviewDTO();
		newReview .setTitle(title);
		newReview .setBody(body);
		newReview .setWriterMemberNo(writerMemberNo);
		
		int result = new ReviewService().insertReview(newReview);
		System.out.println("여기와??");
		String path = "";
		if(result > 0) {
			path = "/WEB-INF/views/main/success.jsp";
			request.setAttribute("successCode", "insertNotice");
		} else {
			path = "/WEB-INF/views/main/failed.jsp";
			request.setAttribute("message", "리뷰등록에 실패하셨습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
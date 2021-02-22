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


@WebServlet("/review/detail")
public class ReviewSelectDetailservlet extends HttpServlet {
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		ReviewDTO reviewDetail = new ReviewService().selectReviewDetail(no);
		
		String path = "";
		if(reviewDetail != null) {
			path = "/WEB-INF/views/review/reviewDetail.jsp";
			request.setAttribute("notice", reviewDetail);
		} else {
			path = "/WEB-INF/views/main/failed.jsp";
			request.setAttribute("message", "리뷰 상세 보기 조회에 실패하셨습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}

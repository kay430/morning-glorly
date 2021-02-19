package com.jihunh.jsp.customerservice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jihunh.jsp.customerservice.model.dto.ReviewDTO;
import com.jihunh.jsp.customerservice.model.service.ReviewService;

/**
 * Servlet implementation class CustomerProductReviewServlet
 */
@WebServlet("/product/review")
public class CustomerProductReviewServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<ReviewDTO> reviewList = new ReviewService().selectAllReviewList();
		
		System.out.println("reviewList : " + reviewList);
		
		String path = "";
		if(reviewList != null) {
			path = "/WEB-INF/views/customerservice/review.jsp";
			request.setAttribute("reviewList", reviewList);
		} else {
			path = "/WEB-INF/views/main/failed.jsp";
			request.setAttribute("message", "공지사항 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}


package com.mg.jsp.admin.controller.review;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mg.jsp.common.paging.Pagenation;
import com.mg.jsp.review.dto.ReviewDTO;
import com.mg.jsp.review.dto.ReviewPageInfoDTO;
import com.mg.jsp.review.service.ReviewService;

@WebServlet("/admin/review")
public class ReviewAdmin extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String currentPage = request.getParameter("currentPage");

		int pageNo = 1;

		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}
		
		if(pageNo <= 0) {
			pageNo = 1;
		}
		
		System.out.println("current페이지 : " + currentPage);
		System.out.println("pageNo는? : " + pageNo);
		
		ReviewService reviewServ = new ReviewService();
		int totalCount = reviewServ.selectTotalCount();
		
		System.out.println("전체 게시물 수 : " + totalCount); 
		
		int limit = 10;
		int buttonAmount = 5;
		
		ReviewPageInfoDTO pageInfo = Pagenation.getPageInfoReview(pageNo, totalCount, limit, buttonAmount);
		
		System.out.println("pageInfo : " + pageInfo);
		
		List<ReviewDTO> reviewList = reviewServ.selectAllReviewList(pageInfo);
		for(ReviewDTO adminReview : reviewList) {
			System.out.println(adminReview);
		
		}
		

		String path = "";
		if(reviewList != null) {
			path = "/WEB-INF/views/admin/Review.jsp";
			request.setAttribute("reviewList", reviewList);
			request.setAttribute("pageInfo", pageInfo);
		} else {
			path = "WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "게시물 목록 조회 실패!");
		}
		request.getRequestDispatcher(path).forward(request, response);
	}
		
	/*
	 * String path = ""; 
	 * path = "/WEB-INF/views/admin/Review.jsp";
	 * request.getRequestDispatcher(path).forward(request, response);
	 * 
	 * }
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}

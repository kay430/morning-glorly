package com.jihunh.jsp.review.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jihunh.jsp.common.paging.Pagenation;
import com.jihunh.jsp.review.dto.ReviewDTO;
import com.jihunh.jsp.review.dto.ReviewPageInfoDTO;
import com.jihunh.jsp.review.service.ReviewService;

/**
 * Servlet implementation class CustomerProductReviewServlet
 */
@WebServlet("/product/review")
public class CustomerProductReviewServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String currentPage = request.getParameter("currentPage");
		
		int pageNo = 1;
		if(currentPage != null && !"".equals(currentPage)) {
			
			pageNo = Integer.parseInt(currentPage);
		}
		
		if(pageNo <= 0) {
			pageNo = 1;
		}
		
		System.out.println("currentPage : " + currentPage);
		System.out.println("pageNo : " + pageNo);
		
		/*여기부터 SQL익셉션*/
		ReviewService reviewService = new ReviewService();
		int totalCount = reviewService.selectTotalCount();
		//여기까지 익셉션 오류
		System.out.println("전체 게시물 수 : " + totalCount);
		// 무슨 오류여 여긴
		int limit = 10;
		int buttonAmount = 5;
		//
		ReviewPageInfoDTO reviewPageInfo = Pagenation.getPageInfoReview(pageNo, totalCount, limit, buttonAmount);
		
		System.out.println("pageInfo : " + reviewPageInfo );
		/*요기부터가 부적합열 인덱스 오류*/
		List<ReviewDTO> reviewList =reviewService.selectAllReviewList(reviewPageInfo);
		
		System.out.println("reviewList : " + reviewList);
		
		for(ReviewDTO reviewBoard : reviewList) {
			System.out.println(reviewBoard);
		}

		
		String path = "";
		if(reviewList != null) {
			path = "/WEB-INF/views/review/review.jsp";
			request.setAttribute("reviewList", reviewList);
			request.setAttribute("reviewPageInfo", reviewPageInfo);
		
			
		
		} else {
			path = "/WEB-INF/views/main/failed.jsp";
			request.setAttribute("message", "리뷰 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}


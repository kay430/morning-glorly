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
 * Servlet implementation class CustomerReviewSearchListservlet
 */
@WebServlet("/review/search")
public class CustomerReviewSearchListservlet extends HttpServlet {
//써치 용

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String searchCondition = request.getParameter("searchCondition");
		String searchValue = request.getParameter("searchValue");
		
		System.out.println("searchCondition : " + searchCondition);
		System.out.println("searchValue : " + searchValue);

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
		//페이징 처리 위해 전체 게시물스 필요 
		ReviewService reviewService = new ReviewService();
		int totalCount = reviewService.selectTotalCount();
		
		System.out.println("전체 게시물 수 : " + totalCount);
		
		int limit = 10;
		int buttonAmount = 5;
		
		ReviewPageInfoDTO reviewPageInfo = Pagenation.getPageInfoReview(pageNo, totalCount, limit, buttonAmount);
		
		System.out.println("pageInfo : " + reviewPageInfo );
		
		List<ReviewDTO> reviewList = reviewService.selectSearchReviewList(searchCondition, searchValue,reviewPageInfo);
		
		for(ReviewDTO review : reviewList) {
			System.out.println(review); 
		}
		String path = "";
		if(reviewList != null) {
			path = "/WEB-INF/views/review/review.jsp";
			request.setAttribute("reviewList", reviewList);
			request.setAttribute("pageInfo", reviewPageInfo);
			request.setAttribute("searchCondition", searchCondition);
			request.setAttribute("searchValue", searchValue);
			
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "게시물 검색 실패!");
		}

		request.getRequestDispatcher(path).forward(request, response);

	}

}


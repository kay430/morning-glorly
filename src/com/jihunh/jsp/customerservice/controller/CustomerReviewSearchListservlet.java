package com.jihunh.jsp.customerservice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jihunh.jsp.common.paging.Pagenation;
import com.jihunh.jsp.customerservice.model.dto.PageInfoDTO;
import com.jihunh.jsp.customerservice.model.dto.ReviewDTO;
import com.jihunh.jsp.customerservice.model.service.ReviewService;

/**
 * Servlet implementation class CustomerReviewSearchListservlet
 */
@WebServlet("/review/search")
public class CustomerReviewSearchListservlet extends HttpServlet {


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

		ReviewService reviewService = new ReviewService();
		int totalCount = reviewService.searchReviewCount(searchCondition, searchValue);

		System.out.println("totalCount : " + totalCount);

		int limit = 10;
		int buttonAmount = 5;

		PageInfoDTO pageInfo = Pagenation.getPageInfo(pageNo, totalCount, limit, buttonAmount);

		System.out.println(pageInfo);

		List<ReviewDTO> reviewList = reviewService.searchReviewList(searchCondition, searchValue, pageInfo);

		for(ReviewDTO review : reviewList) {
			System.out.println(review);
		}

		String path = "";
		if(reviewList != null) {
			path = "/WEB-INF/views/customerservice/review.jsp";
			request.setAttribute("reviewList", reviewList);
			request.setAttribute("pageInfo", pageInfo);
			request.setAttribute("searchCondition", searchCondition);
			request.setAttribute("searchValue", searchValue);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "게시물 검색 실패!");
		}

		request.getRequestDispatcher(path).forward(request, response);

	}

}


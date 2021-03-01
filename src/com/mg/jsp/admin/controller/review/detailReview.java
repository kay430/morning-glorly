package com.mg.jsp.admin.controller.review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mg.jsp.review.dto.ReviewDTO;
import com.mg.jsp.review.service.ReviewService;

@WebServlet("/admin/review/detail")
public class detailReview extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		int pageNumNo = no;
		
		ReviewDTO reviewDTO = new ReviewService().selectReviewDetail(no);
		
		System.out.println(reviewDTO);
		
		String path = "";
		if(reviewDTO != null) {
			path = "/WEB-INF/views/admin/reviewDetailAdmin.jsp";
			request.setAttribute("review", reviewDTO);
			request.setAttribute("pageNumNo", pageNumNo);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "공지사항 상세 보기 조회에 실패하셨습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}


}

package com.jihunh.jsp.customerservice.model.service;

import static com.jihunh.jsp.common.jdbc.JDBCTemplate.close;
import static com.jihunh.jsp.common.jdbc.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.jihunh.jsp.customerservice.model.dao.ReviewDAO;
import com.jihunh.jsp.customerservice.model.dto.ReviewDTO;


public class ReviewService {
	
	private final ReviewDAO reviewDAO;
	
	public ReviewService() {
		reviewDAO = new ReviewDAO();
	}
	
	public List<ReviewDTO> selectAllReviewList() {
		
		Connection con = getConnection();
		
		List<ReviewDTO> reviewList = reviewDAO.selectAllReviewService(con);
		
		close(con);
		
		return reviewList;
	}

	
}

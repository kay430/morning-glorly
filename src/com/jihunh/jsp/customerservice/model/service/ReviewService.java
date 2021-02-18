package com.jihunh.jsp.customerservice.model.service;

import static com.jihunh.jsp.common.jdbc.JDBCTemplate.close;
import static com.jihunh.jsp.common.jdbc.JDBCTemplate.getConnection;
import static com.jihunh.jsp.common.jdbc.JDBCTemplate.commit;
import static com.jihunh.jsp.common.jdbc.JDBCTemplate.rollback;


import java.sql.Connection;
import java.util.List;

import com.jihunh.jsp.customerservice.model.dao.ReviewDAO;
import com.jihunh.jsp.customerservice.model.dto.PageInfoDTO;
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

	public int insertReview(ReviewDTO newReview) {
		Connection con = getConnection();
		
		int result = reviewDAO.insertReview(con, newReview);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public int searchReviewCount(String searchCondition, String searchValue) {
		Connection con = getConnection();
		
		int totalCount = reviewDAO.searchReviewCount(con, searchCondition, searchValue);
		
		close(con);
		
		return totalCount;
	}

	public List<ReviewDTO> searchReviewList(String searchCondition, String searchValue, PageInfoDTO pageInfo) {

		Connection con = getConnection();
		
		List<ReviewDTO> reviewList = reviewDAO.searchReviewList(con, searchCondition, searchValue, pageInfo);
		
		close(con);
		
		return reviewList;
	}

	

	
}

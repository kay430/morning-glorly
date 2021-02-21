package com.jihunh.jsp.review.service;

import static com.jihunh.jsp.common.jdbc.JDBCTemplate.close;
import static com.jihunh.jsp.common.jdbc.JDBCTemplate.commit;
import static com.jihunh.jsp.common.jdbc.JDBCTemplate.getConnection;
import static com.jihunh.jsp.common.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.jihunh.jsp.customerservice.model.dto.PageInfoDTO;
import com.jihunh.jsp.review.dao.ReviewDAO;
import com.jihunh.jsp.review.dto.ReviewDTO;
import com.jihunh.jsp.review.dto.ReviewPageInfoDTO;


public class ReviewService {
	
	private final ReviewDAO reviewDAO;
	
	public ReviewService() {
		reviewDAO = new ReviewDAO();
	}
	
	public List<ReviewDTO> selectAllReviewList(ReviewPageInfoDTO ReviewPageInfo) {
		
		Connection con = getConnection();
		
		List<ReviewDTO> reviewList = reviewDAO.selectAllReviewList(con, ReviewPageInfo);
		
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

	
	  public int searchTotalCount() {
	  Connection con = getConnection();
	  
	  int totalCount = reviewDAO.searchTotalCount(con);
	  
	  close(con);
	  
	  return totalCount; }
	 
	//오류.
	  public List<ReviewDTO> searchReviewList(String searchCondition, String
	  searchValue, PageInfoDTO pageInfo) {
	  
	  Connection con = getConnection();
	  
	  List<ReviewDTO> reviewList = reviewDAO.searchReviewList(con, searchCondition,
	  searchValue, pageInfo);
	  
	  close(con);
	  
	  return reviewList; 
	  }
	 
	  
	  public int selectTotalCount() {
			
			Connection con = getConnection();
			
			int totalCount = reviewDAO.selectTotalCount(con);
			
			close(con);
			
			return totalCount;
		}

	  

	  
	



	

	
}

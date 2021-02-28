package com.mg.jsp.review.service;

import static com.mg.jsp.common.jdbc.JDBCTemplate.close;
import static com.mg.jsp.common.jdbc.JDBCTemplate.commit;
import static com.mg.jsp.common.jdbc.JDBCTemplate.getConnection;
import static com.mg.jsp.common.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.mg.jsp.customerservice.model.dto.PageInfoDTO;
import com.mg.jsp.review.dao.ReviewDAO;
import com.mg.jsp.review.dto.AttachmentDTO;
import com.mg.jsp.review.dto.ReviewDTO;
import com.mg.jsp.review.dto.ReviewPageInfoDTO;


public class ReviewService {
	
	private final ReviewDAO reviewDAO;
	
	public ReviewService() {
		reviewDAO = new ReviewDAO();
	}
		
	public int selectTotalCount() {
		
		Connection con = getConnection();
		
		int totalCount = reviewDAO.selectTotalCount(con);
		
		close(con);
		 
		return totalCount;
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
	 
	
	  public List<ReviewDTO> searchReviewList(String searchCondition, String
	  searchValue, PageInfoDTO pageInfo) {
	  
	  Connection con = getConnection();
	  
	  List<ReviewDTO> reviewList = reviewDAO.searchReviewList(con, searchCondition,
	  searchValue, pageInfo);
	  
	  close(con);
	  
	  return reviewList; 
	  }
	public ReviewDTO selectReviewDetail(int no) {
		Connection con = getConnection();
		ReviewDTO reviewDetail = null;
		
		int result = reviewDAO.incrementReviewCount(con, no);
		
		if(result > 0) {
			reviewDetail = reviewDAO.selectReviewDetail(con, no);
			System.out.println("게시물 조회 " + reviewDetail);
			
			if(reviewDetail != null) {
				commit(con);
				reviewDetail = reviewDAO.selectReviewAttachment(con, no, reviewDetail);
				
			} else {
				rollback(con);
			}
			
		} else {
			rollback(con);
		}
		
		close(con);
		System.out.println("썸네일 조회 "+reviewDetail);
		return reviewDetail;
	}
	public List<ReviewDTO> selectSearchReviewList(String searchCondition, String searchValue,
			ReviewPageInfoDTO reviewPageInfo) {
		Connection con = getConnection();
		
		List<ReviewDTO> reviewList = reviewDAO.selectSearchReviewList(con, searchCondition, searchValue, reviewPageInfo);
		
		close(con);
		
		return reviewList;
	}
	public int updateMemberNo(ReviewDTO changeInfo) {
		Connection con = getConnection();
		
	
		
			int result = reviewDAO.changeReview(con, changeInfo);
			
		
			if(result > 0 ) {
				commit(con);
			} else {
				rollback(con);
		
		}
		
		close(con);
		
		return result;
	}
	public int insertReviewThumbnail(ReviewDTO thumbnail) {
		Connection con = getConnection();
		System.out.println("thumbnail:"+thumbnail);
		int result = 0;
		
		int reviewResult = reviewDAO.InsertThumbnailContent(con,thumbnail);
		
		int reviewNo = reviewDAO.selectThumbnailSequence(con);
		
		List<AttachmentDTO> fileList = thumbnail.getAttachmentList();
		for(int i = 0; i < fileList.size(); i++) {
			fileList.get(i).setNotiNo(reviewNo);
		}
		
		int attachmentResult = 0;
		for(int i = 0; i < fileList.size(); i++) {
			attachmentResult = reviewDAO.insertAttachment(con, fileList.get(i));
		}
		
		System.out.println("attachmentResult : " + attachmentResult);
		System.out.println("fileListSize : " + fileList.size());
		
		if(reviewResult > 0 && attachmentResult == fileList.size()) {
			commit(con);
			result = 1;
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}
	
	


	}
	 

	  

	  
	



	

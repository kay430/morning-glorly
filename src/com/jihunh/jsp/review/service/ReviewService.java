package com.jihunh.jsp.review.service;

import static com.jihunh.jsp.common.jdbc.JDBCTemplate.close;
import static com.jihunh.jsp.common.jdbc.JDBCTemplate.commit;
import static com.jihunh.jsp.common.jdbc.JDBCTemplate.getConnection;
import static com.jihunh.jsp.common.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.jihunh.jsp.customerservice.model.dto.PageInfoDTO;
import com.jihunh.jsp.review.dao.ReviewDAO;
import com.jihunh.jsp.review.dto.AttachmentDTO;
import com.jihunh.jsp.review.dto.ReviewDTO;
import com.jihunh.jsp.review.dto.ReviewPageInfoDTO;


public class ReviewService {
	
	private final ReviewDAO reviewDAO;
	
	public ReviewService() {
		reviewDAO = new ReviewDAO();
	}
		//페이징처리 위한  전체게시물수 조회용 메소드 
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
	 
	//오류.
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
		System.out.println("진입");
		int result = reviewDAO.incrementReviewCount(con, no);
		
		if(result > 0) {
			reviewDetail = reviewDAO.selectReviewDetail(con, no);
			
			if(reviewDetail != null) {
				commit(con);
			} else {
				rollback(con);
			}
			
		} else {
			rollback(con);
		}
		
		close(con);
		
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
		
	
		/* 1. DB에 저장된 게시물 넘버와 일치하는 회원의 넘버 조회 */
		/* String memberId = reviewDAO.selectMemberId(con, changeInfo); */
		System.out.println("조회함?");
		/* 2. 파라미터로 전달받은 회원번호와 DB에 저장된 회원번호가 일치하는지 확인 */
		
		/* if(memberId.equals(changeInfo.getMgDTO().getId())) { */
			
			/* 3. 회원번호가 일치하면 리뷰 수정 */
			int result = reviewDAO.changeReview(con, changeInfo);
			
			/* 4. update가 성공하면  회원 리ㅂ 조회 */
			
			
			/* 5. 모두 정상적으로 동작하면 commit */
			if(result > 0 ) {
				commit(con);
			} else {
				rollback(con);
			//}
		}
		
		close(con);
		
		return result;
	}
	public int insertReviewThumbnail(ReviewDTO thumbnail) {
		Connection con = getConnection();
		
		int result = 0;
		
		int reviewResult = reviewDAO.InsertThumbnailContent(con,thumbnail);
		System.out.println("여기오나");
		int reviewNo = reviewDAO.selectThumbnailSequence(con);
		
		List<AttachmentDTO> fileList = thumbnail.getAttachmentList();
		for(int i = 0; i < fileList.size(); i++) {
			fileList.get(i).setNotiNo(reviewNo);
		}
		
		int attachmentResult = 0;
		for(int i = 0; i < fileList.size(); i++) {
			attachmentResult = reviewDAO.insertAttachment(con, fileList.get(i));
		}
		
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
	 

	  

	  
	



	



package com.jihunh.jsp.customerservice.model.dao;

import static com.jihunh.jsp.common.jdbc.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.jihunh.jsp.common.config.ConfigLocation;
import com.jihunh.jsp.customerservice.model.dto.CategoryDTO;
import com.jihunh.jsp.customerservice.model.dto.PageInfoDTO;
import com.jihunh.jsp.customerservice.model.dto.ReviewDTO;
import com.jihunh.jsp.member.model.dto.MgDTO;

public class ReviewDAO {

	private final Properties prop;

	public ReviewDAO() {
		prop = new Properties();

		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "customerservice/review-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<ReviewDTO> selectAllReviewService(Connection con) {

		Statement stmt = null;
		ResultSet rset = null;

		List<ReviewDTO> reviewList = null;

		String query = prop.getProperty("selectAllReviewList");

		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);

			reviewList = new ArrayList<>();

			while (rset.next()) {
				ReviewDTO review = new ReviewDTO();
				review.setWriter(new MgDTO());

				review.setNo(rset.getInt("REVIEW_NO"));
				review.setTitle(rset.getString("REVIEW_TITLE"));
				review.setBody(rset.getString("REVIEW_BODY"));
				review.setWriterMemberNo(rset.getInt("REVIEW_WRITER_MEMBER_NO"));
				review.setCount(rset.getInt("REVIEW_COUNT"));
				review.setCreateDate(rset.getDate("CREATED_DATE"));
				review.setModifiedDate(rset.getDate("MODIFIED_DATE"));
				review.setDisplay(rset.getString("REVIEW_DISPLAY"));
				review.setOrderNo(rset.getString("REVIEW_ORDER_NO"));

				reviewList.add(review);

				review.getWriter().setId(rset.getString("REVIEW_WRITER_MEMBER_NO"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return reviewList;
	}

	public int insertReview(Connection con, ReviewDTO newReview) {
		PreparedStatement pstmt = null;

		int result = 0;

		String query = prop.getProperty("insertReview");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, newReview.getTitle());
			pstmt.setString(2, newReview.getBody());
			pstmt.setInt(3, newReview.getWriterMemberNo());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int searchReviewCount(Connection con, String searchCondition, String searchValue) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		int totalCount = 0;

		String query = null;
		if ("category".equals(searchCondition)) {
			query = prop.getProperty("searchCategoryReviewCount");
		} else if ("writer".equals(searchCondition)) {
			query = prop.getProperty("searchWriterReviewCount");
		} else if ("title".equals(searchCondition)) {
			query = prop.getProperty("searchTitleReviewCount");
		} else if ("content".equals(searchCondition)) {
			query = prop.getProperty("searchContentReviewCount");
		}

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, searchValue);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				totalCount = rset.getInt("COUNT(*)");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return totalCount;
	}
	
	  
	  public List<ReviewDTO> searchReviewList(Connection con, String
	  searchCondition, String searchValue, PageInfoDTO pageInfo) {
	  PreparedStatement pstmt = null; ResultSet rset = null;
	  
	  List<ReviewDTO> reviewList = null;
	  
	  String query = null;
	  
	  if("category".equals(searchCondition)) { query =
	  prop.getProperty("searchCategoryReviewList"); } else
	  if("writer".equals(searchCondition)) { query =
	  prop.getProperty("searchWriterReviewList"); } else
	  if("title".equals(searchCondition)) { query =
	  prop.getProperty("searchTitleReviewList"); } else
	  if("content".equals(searchCondition)) { query =
	  prop.getProperty("searchContentReviewList"); }
	  
	  try { pstmt = con.prepareStatement(query); pstmt.setString(1, searchValue);
	  pstmt.setInt(2, pageInfo.getStartRow()); pstmt.setInt(3,
	  pageInfo.getEndRow());
	  
	  rset = pstmt.executeQuery();
	  
	  reviewList = new ArrayList<>();
	  
	  while(rset.next()) { ReviewDTO review = new ReviewDTO();
	  review.setCategory(new CategoryDTO()); review.setWriter(new MgDTO());
	  
	  review.setNo(rset.getInt("REVIEW_NO"));
	  review.setType(rset.getInt("REVIEW_TYPE"));
	  review.setCategoryCode(rset.getInt("CATEGORY_CODE"));
	  review.getCategory().setName(rset.getString("CATEGORY_NAME"));
	  review.setTitle(rset.getString("REVIEW_TITLE"));
	  review.setBody(rset.getString("REVIEW_BODY"));
	  review.setWriterMemberNo(rset.getInt("REVIEW_WRITER_MEMBER_NO"));
	  review.getWriter().setNickname(rset.getString("NICKNAME"));
	  review.setCount(rset.getInt("REVIEW_COUNT"));
	  review.setCreatedDate(rset.getDate("CREATED_DATE"));
	  review.setStatus(rset.getString("REVIEW_STATUS"));
	  
	  reviewList.add(review); }
	  
	  } catch (SQLException e) { e.printStackTrace(); } finally { close(rset);
	  close(pstmt); }
	  
	  return reviewList; }
	  
	 
}

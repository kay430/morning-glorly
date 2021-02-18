package com.jihunh.jsp.customerservice.model.dao;


import static com.jihunh.jsp.common.jdbc.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.jihunh.jsp.common.config.ConfigLocation;
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

			reviewList = new ArrayList();

			while(rset.next()) {
				ReviewDTO review = new ReviewDTO();	
				review.setWriter(new MgDTO());

				review.setNo(rset.getInt("REVIEW_NO"));
				review.setTitle(rset.getString("REVIEW_TITLE"));
				review.setBody(rset.getString("REVIEW_BODY"));
				review.setWriterMemberNo(rset.getInt("REVIEW_WRITER_MEMBER_NO"));
				review.getWriter().setId(rset.getString("MEMBER_ID"));
				review.setCount(rset.getInt("REVIEW_COUNT"));
				review.setCreateDate(rset.getDate("REVIEW_DATE"));

				reviewList.add(review);


			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return reviewList;
	}

}

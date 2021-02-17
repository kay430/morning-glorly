package com.jihunh.jsp.admin.model.dao;

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

import com.jihunh.jsp.admin.model.dto.AnswerCategoryDTO;
import com.jihunh.jsp.admin.model.dto.AnswerDTO;
import com.jihunh.jsp.admin.model.dto.NoticePageInfoDTO;
import com.jihunh.jsp.common.config.ConfigLocation;
import com.jihunh.jsp.member.model.dto.MgDTO;

public class AnswerDAO {
	
	private final Properties prop;
	
	public AnswerDAO() {
		prop = new Properties();
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "admin/answer-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertAnswer(Connection con, AnswerDTO answerDTO) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("insertAnswer");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, answerDTO.getTitle());
			pstmt.setString(2, answerDTO.getBody());
			pstmt.setInt(3, answerDTO.getWriterMgNo());
			pstmt.setString(4, answerDTO.getStatus());
			pstmt.setInt(5, answerDTO.getCategoryCode());
			
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int incrementAnswerCount(Connection con, int no) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("incrementAnswerCount");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, no);
			pstmt.setInt(2, no);
			
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public AnswerDTO selectAnswerDetail(Connection con, int no) {
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		AnswerDTO answerDTO = null;
		
		String query = prop.getProperty("selectAnswerDetail");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, no);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				answerDTO = new AnswerDTO();
				answerDTO.setWriter(new MgDTO());
				answerDTO.setCategory(new AnswerCategoryDTO());
				
				answerDTO.setNo(rset.getInt("QNA_NO"));
				answerDTO.setStatus(rset.getString("QNA_STATUS"));
				answerDTO.getCategory().setName(rset.getString("CATEGORY_NAME"));
				answerDTO.setTitle(rset.getString("QNA_TITLE"));
				answerDTO.setBody(rset.getString("QNA_BODY"));
				answerDTO.setWriterMgNo(rset.getInt("QNA_WRITER_MEMBER_NO"));
				answerDTO.getWriter().setName(rset.getString("MEMBER_NAME"));
				answerDTO.setCount(rset.getInt("QNA_COUNT"));
				answerDTO.setCreatedDate(rset.getDate("CREATED_DATE"));
			
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return answerDTO;
	}

	public int updateAnswer(Connection con, AnswerDTO answerDTO) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("updateAnswer");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, answerDTO.getTitle());
			pstmt.setString(2, answerDTO.getBody());
			pstmt.setInt(3, answerDTO.getNo());
			pstmt.setInt(4, answerDTO.getWriterMgNo());
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int selectTotalCount(Connection con) {

		Statement stmt = null;
		ResultSet rset = null;
		
		int totalCount = 0;
		
		String query = prop.getProperty("selectTotalCount");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				totalCount = rset.getInt("COUNT(*)");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return totalCount;
	}

	public List<AnswerDTO> selectAnswerList(Connection con, NoticePageInfoDTO pageInfo) {

		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		List<AnswerDTO> answerList = null;
		
		String query = prop.getProperty("selectAnswerList");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, pageInfo.getStartRow());
			pstmt.setInt(2, pageInfo.getEndRow());
			
			rset = pstmt.executeQuery();
			
			answerList = new ArrayList<>();
			
			while(rset.next()) {
				AnswerDTO answer = new AnswerDTO();
				answer.setWriter(new MgDTO());
				
				answer.setNo(rset.getInt("QNA_NO"));
				answer.setStatus(rset.getString("QNA_STATUS"));
				answer.setCategoryCode(rset.getInt("CATEGORY_CODE"));
				answer.setTitle(rset.getString("QNA_TITLE"));
				answer.setBody(rset.getString("QNA_BODY"));
				answer.setWriterMgNo(rset.getInt("QNA_WRITER_MEMBER_NO"));
				answer.getWriter().setName(rset.getString("MEMBER_NAME"));
				answer.setCount(rset.getInt("QNA_COUNT"));
				answer.setCreatedDate(rset.getDate("CREATED_DATE"));
				answer.setModifiedDate(rset.getDate("MODIFIED_DATE"));
				answer.setStatus(rset.getString("QNA_DISPLAY"));
				
				answerList.add(answer);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return answerList;
	}

}


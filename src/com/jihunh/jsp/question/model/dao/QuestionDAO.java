package com.jihunh.jsp.question.model.dao;

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
import com.jihunh.jsp.member.model.dto.MgDTO;
import com.jihunh.jsp.question.model.dto.AttaQuestionDTO;
import com.jihunh.jsp.question.model.dto.CategoryDTO;
import com.jihunh.jsp.question.model.dto.QuestionDTO;
import com.jihunh.jsp.question.model.dto.QuestionPageInfoDTO;

public class QuestionDAO {
	
	private final Properties prop;
	
	public QuestionDAO() {
		prop = new Properties();
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "question/question-mapper.xml" ));
		} catch (IOException e) {
			e.printStackTrace();
		}
				
	}
	public List<QuestionDTO> selectAllQuestionService(Connection con, QuestionPageInfoDTO QuestionPageInfo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<QuestionDTO> questionList = null;
		
		String query = prop.getProperty("selectAllQuestionList");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, QuestionPageInfo.getStartRow());
			pstmt.setInt(2, QuestionPageInfo.getEndRow());
			
			rset = pstmt.executeQuery();
			
			questionList = new ArrayList<>();
			
			while(rset.next()) {
				QuestionDTO question = new QuestionDTO();			
				question.setMgDTO(new MgDTO());
				question.setCategory(new CategoryDTO());
				
				
				question.setNo(rset.getInt("QNA_NO"));
				question.setTitle(rset.getString("QNA_TITLE"));
				question.setBody(rset.getString("QNA_BODY"));
				question.setWriterMemberNo(rset.getInt("QNA_WRITER_MEMBER_NO"));
				question.getMgDTO().setName(rset.getString("MEMBER_ID"));
				question.setCount(rset.getInt("QNA_COUNT"));
				question.setCreateDate(rset.getDate("CREATED_DATE"));
				question.setDisplay(rset.getString("QNA_DISPLAY"));
				question.setStatus(rset.getString("QNA_STATUS"));
				question.getCategory().setName(rset.getString("CATEGORY_NAME"));
				
				questionList.add(question);
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return questionList;
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
	public int incrementQuestionCount(Connection con, int no) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("incrementQuestionCount");
		
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
	public QuestionDTO selectQuestionDetail(Connection con, int no) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		QuestionDTO questionDetail = null;
		
		String query = prop.getProperty("selectQuestionDetail");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, no);
			
			rset = pstmt.executeQuery();
			
			List<AttaQuestionDTO> attaQueList = new ArrayList<>();
			if(rset.next()) {
				questionDetail = new QuestionDTO();
				questionDetail.setMgDTO(new MgDTO());
				AttaQuestionDTO attaQue = new AttaQuestionDTO();
				
				questionDetail.setNo(rset.getInt("QNA_NO"));
				questionDetail.setTitle(rset.getString("QNA_TITLE"));
				questionDetail.setBody(rset.getString("QNA_BODY"));
				questionDetail.setWriterMemberNo(rset.getInt("QNA_WRITER_MEMBER_NO"));
				questionDetail.getMgDTO().setName(rset.getString("MEMBER_ID"));
				questionDetail.setCount(rset.getInt("QNA_COUNT"));
				questionDetail.setCreateDate(rset.getDate("CREATED_DATE"));
				//questionDetail.setModifiedDate(rset.getDate("MODIFIED_DATE"));
				questionDetail.setDisplay(rset.getString("QNA_DISPLAY"));
				attaQue.setNo(rset.getInt("ATTACHMENT_NO"));
				attaQue.setOriginalName(rset.getString("ORIGINAL_NAME"));
				attaQue.setSavedName(rset.getString("SAVED_NAME"));
				attaQue.setSavedPath(rset.getString("SAVE_PATH"));
				attaQue.setFileType(rset.getString("FILE_TYPE"));
				attaQue.setThumbnailPath(rset.getString("THUMBNAIL_PATH"));
				
				attaQueList.add(attaQue);
			}
			
			questionDetail.setAttaQueList(attaQueList);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return questionDetail;
	}
	public int insertQuestion(Connection con, QuestionDTO newQuestion) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("insertQuestion");
		
		try {			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, newQuestion.getTitle());
			pstmt.setString(2, newQuestion.getBody());
			pstmt.setInt(3, newQuestion.getWriterMemberNo());
			pstmt.setInt(4, newQuestion.getCategoryCode());
			
			result = pstmt.executeUpdate();
			
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}	finally {
			close(pstmt);
		}
		
		
		return result;
	}
	public int searchQuestionCount(Connection con, String searchCondition, String searchValue) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int searchQuestionCount = 0;
		
		String query = null;
		if("QueName".equals(searchCondition)) {
			query = prop.getProperty("searchQueNameCount");
		} else if("QueTitle".equals(searchCondition)) {
			query = prop.getProperty("searchQueTitleCount");
		} else if("QueBody".equals(searchCondition)) {
			query = prop.getProperty("searchQueBodyCount");
		}
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, searchValue);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				searchQuestionCount = rset.getInt("COUNT(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return searchQuestionCount;
	}
	public List<QuestionDTO> searchQuestionList(Connection con, String searchCondition, String searchValue,
			QuestionPageInfoDTO questionInfo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<QuestionDTO> searchQuestionList = null;
		
		String query = null;
		
		if("QueName".equals(searchCondition)) {
			query = prop.getProperty("searchQueNameList");
		} else if("QueTitle".equals(searchCondition)) {
			query = prop.getProperty("searchQueTitleList");
		} else if("QueBody".equals(searchCondition)) {
			query = prop.getProperty("searchQueBodyList");
		}
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, searchValue);
			pstmt.setInt(2, questionInfo.getStartRow());
			pstmt.setInt(3, questionInfo.getEndRow());
			
			rset = pstmt.executeQuery();
			
			searchQuestionList = new ArrayList<>();
			
			while(rset.next()) {
				QuestionDTO questions = new QuestionDTO();
				questions.setCategory(new CategoryDTO());
				questions.setMgDTO(new MgDTO());
				
				questions.setNo(rset.getInt("QNA_NO"));
				questions.setTitle(rset.getString("QNA_TITLE"));
				questions.setBody(rset.getString("QNA_BODY"));
				questions.setWriterMemberNo(rset.getInt("QNA_WRITER_MEMBER_NO"));
				questions.getMgDTO().setName(rset.getString("MEMBER_ID"));
				questions.setCount(rset.getInt("QNA_COUNT"));
				questions.setCreateDate(rset.getDate("CREATED_DATE"));
				questions.setDisplay(rset.getString("QNA_DISPLAY"));
				questions.setStatus(rset.getString("QNA_STATUS"));
				
				searchQuestionList.add(questions);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		
		return searchQuestionList;
	}
	public int updateQuestion(Connection con, QuestionDTO newQuestion) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("updateQuestion");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, newQuestion.getTitle());
			pstmt.setString(2, newQuestion.getBody());
			pstmt.setInt(3, newQuestion.getNo());
			pstmt.setInt(4, newQuestion.getWriterMemberNo());
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	public int deleteQuestion(Connection con, QuestionDTO requestQuestion) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("deleteQuestion");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, requestQuestion.getNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		
		return result;
	}


}

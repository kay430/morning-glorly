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
				
				question.setNo(rset.getInt("QNA_NO"));
				question.setTitle(rset.getString("QNA_TITLE"));
				question.setBody(rset.getString("QNA_BODY"));
				question.setWriterMemberNo(rset.getInt("QNA_WRITER_MEMBER_NO"));
				question.getMgDTO().setName(rset.getString("MEMBER_ID"));
				question.setCount(rset.getInt("QNA_COUNT"));
				question.setCreateDate(rset.getDate("CREATED_DATE"));
				question.setDisplay(rset.getString("QNA_DISPLAY"));
				question.setStatus(rset.getString("QNA_STATUS"));
				
				
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
				questionDetail.setModifiedDate(rset.getDate("MODIFIED_DATE"));
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


}

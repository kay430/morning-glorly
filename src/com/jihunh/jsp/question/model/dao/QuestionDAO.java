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

import com.jihunh.jsp.admin.model.dto.MgAdDTO;
import com.jihunh.jsp.common.config.ConfigLocation;
import com.jihunh.jsp.member.model.dto.MgDTO;
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


}

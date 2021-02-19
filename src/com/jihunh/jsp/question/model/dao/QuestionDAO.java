package com.jihunh.jsp.question.model.dao;

import static com.greedy.jsp.common.jdbc.JDBCTemplate.close;
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

import com.greedy.jsp.board.model.dto.BoardDTO;
import com.greedy.jsp.board.model.dto.CategoryDTO;
import com.greedy.jsp.board.model.dto.PageInfoDTO;
import com.greedy.jsp.member.model.dto.MemberDTO;
import com.jihunh.jsp.common.config.ConfigLocation;
import com.jihunh.jsp.member.model.dto.MgDTO;
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
		
		Statement stmt = null;
		ResultSet rset = null;
		
		List<QuestionDTO> questionList = null;
		
		String query = prop.getProperty("selectAllQuestionList");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			questionList = new ArrayList();
			
			while(rset.next()) {
				QuestionDTO question = new QuestionDTO();	
				question.setWriter(new MgDTO());
				
				question.setNo(rset.getInt("QNA_NO"));
				question.setTitle(rset.getString("QNA_TITLE"));
				question.setBody(rset.getString("QNA_BODY"));
				question.setWriterMemberNo(rset.getInt("QNA_WRITER_MEMBER_NO"));
				question.getWriter().setId(rset.getString("MEMBER_ID"));
				question.setCount(rset.getInt("QNA_COUNT"));
				question.setCreateDate(rset.getDate("CREATED_DATE"));
				question.setStatus(rset.getString("QNA_STATUS"));
				
				questionList.add(question);
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
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

	
	
	
	
/*public List<BoardDTO> selectBoardList(Connection con, PageInfoDTO pageInfo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<BoardDTO> boardList = null;
		
		String query = prop.getProperty("selectBoardList");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, pageInfo.getStartRow());
			pstmt.setInt(2, pageInfo.getEndRow());
			
			rset = pstmt.executeQuery();
			
			boardList = new ArrayList<>();
			
			while(rset.next()) {
				BoardDTO board = new BoardDTO();
				board.setCategory(new CategoryDTO());
				board.setWriter(new MemberDTO());
				
				board.setNo(rset.getInt("BOARD_NO"));
				board.setType(rset.getInt("BOARD_TYPE"));
				board.setCategoryCode(rset.getInt("CATEGORY_CODE"));
				board.getCategory().setName(rset.getString("CATEGORY_NAME"));
				board.setTitle(rset.getString("BOARD_TITLE"));
				board.setBody(rset.getString("BOARD_BODY"));
				board.setWriterMemberNo(rset.getInt("BOARD_WRITER_MEMBER_NO"));
				board.getWriter().setNickname(rset.getString("NICKNAME"));
				board.setCount(rset.getInt("BOARD_COUNT"));
				board.setCreatedDate(rset.getDate("CREATED_DATE"));
				board.setStatus(rset.getString("BOARD_STATUS"));
				
				boardList.add(board);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return boardList;
	}*/

}

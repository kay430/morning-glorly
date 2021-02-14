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

import com.jihunh.jsp.admin.model.dto.AnswerDTO;
import com.jihunh.jsp.admin.model.dto.NoticeDTO;
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
	
	public List<AnswerDTO> selectAllNoticeList(Connection con) {
		
		Statement stmt = null;
		ResultSet rset = null;
		
		List<AnswerDTO> noticeList = null;
		
		String query = prop.getProperty("selectAllNoticeList");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			noticeList = new ArrayList<>();
			
			while(rset.next()) {
				AnswerDTO notice = new AnswerDTO();
				notice.setWriter(new MgDTO());
				
				notice.setNo(rset.getInt("NOTICE_NO"));
				notice.setTitle(rset.getString("NOTICE_TITLE"));
				notice.setBody(rset.getString("NOTICE_BODY"));
				notice.setWriterMgNo(rset.getInt("NOTICE_WRITER_MEMBER_NO"));
				notice.getWriter().setName(rset.getString("MEMBER_NAME"));
				notice.setCount(rset.getInt("NOTICE_COUNT"));
				notice.setCreatedDate(rset.getDate("CREATED_DATE"));
				
				noticeList.add(notice);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return noticeList;
	}

	public int insertNotice(Connection con, AnswerDTO newNotice) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("insertNotice");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, newNotice.getTitle());
			pstmt.setString(2, newNotice.getBody());
			pstmt.setInt(3, newNotice.getWriterMgNo());
			pstmt.setString(4, newNotice.getType());
			pstmt.setInt(5, newNotice.getCategoryNo());
			
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int incrementNoticeCount(Connection con, int no) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("incrementNoticeCount");
		
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
		
		System.out.println("조회수 증가 결과 : " + result);
		return result;
	}

	public AnswerDTO selectNoticeDetail(Connection con, int no) {
		
		System.out.println("디테일 조회 가즈아");
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		AnswerDTO noticeDetail = null;
		
		String query = prop.getProperty("selectNoticeDetail");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, no);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				noticeDetail = new AnswerDTO();
				noticeDetail.setWriter(new MgDTO());
				
				noticeDetail.setNo(rset.getInt("QNA_NO"));
				noticeDetail.setTitle(rset.getString("QNA_TITLE"));
				noticeDetail.setBody(rset.getString("QNA_BODY"));
				noticeDetail.setWriterMgNo(rset.getInt("QNA_WRITER_MEMBER_NO"));
				noticeDetail.getWriter().setName(rset.getString("MEMBER_NAME"));
				noticeDetail.setCount(rset.getInt("QNA_COUNT"));
				noticeDetail.setCreatedDate(rset.getDate("CREATED_DATE"));
			
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return noticeDetail;
	}

	public int updateNotice(Connection con, AnswerDTO newNotice) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("updateNotice");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, newNotice.getTitle());
			pstmt.setString(2, newNotice.getBody());
			pstmt.setInt(3, newNotice.getNo());
			pstmt.setInt(4, newNotice.getWriterMgNo());
			
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

	public List<AnswerDTO> selectBoardList(Connection con, NoticePageInfoDTO pageInfo) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<AnswerDTO> answerList = null;
		
		String query = prop.getProperty("selectNoticeList");
		
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
				answer.setType(rset.getString("QNA_TYPE"));
				answer.setCategoryNo(rset.getInt("CATEGORY_CODE"));
				answer.setTitle(rset.getString("QNA_TITLE"));
				answer.setBody(rset.getString("QNA_BODY"));
				answer.setWriterMgNo(rset.getInt("QNA_WRITER_MEMBER_NO"));
				answer.getWriter().setName(rset.getString("MEMBER_NAME"));
				answer.setCount(rset.getInt("QNA_COUNT"));
				answer.setCreatedDate(rset.getDate("CREATED_DATE"));
				answer.setModifiedDate(rset.getDate("MODIFIED_DATE"));
				answer.setStatus(rset.getString("QNA_STATUS"));
				
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











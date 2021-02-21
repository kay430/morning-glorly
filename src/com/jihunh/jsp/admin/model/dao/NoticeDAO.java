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

import com.jihunh.jsp.admin.model.dto.AttaNoticeDTO;
import com.jihunh.jsp.admin.model.dto.MgAdDTO;
import com.jihunh.jsp.admin.model.dto.NoticeDTO;
import com.jihunh.jsp.admin.model.dto.NoticePageInfoDTO;
import com.jihunh.jsp.admin.model.dto.SearchReadyDTO;
import com.jihunh.jsp.common.config.ConfigLocation;

public class NoticeDAO {
	
	private final Properties prop;
	
	public NoticeDAO() {
		prop = new Properties();
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "admin/admin-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertNotice(Connection con, NoticeDTO newNotice) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("insertNotice");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, newNotice.getTitle());
			pstmt.setString(2, newNotice.getBody());
			pstmt.setInt(3, newNotice.getWriterMemberNo());
			pstmt.setString(4, newNotice.getGeneral());
			pstmt.setString(5, newNotice.getGeneralType());
			
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
		
		return result;
	}

	public NoticeDTO selectNoticeDetail(Connection con, int no) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		NoticeDTO noticeDetail = null;
		
		String query = prop.getProperty("selectNoticeDetail");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, no);
			
			rset = pstmt.executeQuery();
			
			List<AttaNoticeDTO> attaNotiList = new ArrayList<>();
			if(rset.next()) {
				noticeDetail = new NoticeDTO();
				noticeDetail.setWriter(new MgAdDTO());
				AttaNoticeDTO attaNoti = new AttaNoticeDTO();
				
				noticeDetail.setNo(rset.getInt("NOTICE_NO"));
				noticeDetail.setTitle(rset.getString("NOTICE_TITLE"));
				noticeDetail.setBody(rset.getString("NOTICE_BODY"));
				noticeDetail.setWriterMemberNo(rset.getInt("NOTICE_WRITER_MEMBER_NO"));
				noticeDetail.getWriter().setName(rset.getString("ADMIN_NAME"));
				noticeDetail.setCount(rset.getInt("NOTICE_COUNT"));
				noticeDetail.setCreatedDate(rset.getDate("CREATED_DATE"));
				noticeDetail.setDisplay(rset.getString("NOTICE_DISPLAY"));
				noticeDetail.setGeneral(rset.getString("NOTICE_GENERAL"));
				noticeDetail.setGeneralType(rset.getString("NOTICE_GENERAL_TYPE"));
				attaNoti.setNo(rset.getInt("ATTACHMENT_NO"));
				attaNoti.setOriginalName(rset.getString("ORIGINAL_NAME"));
				attaNoti.setSavedName(rset.getString("SAVED_NAME"));
				attaNoti.setSavePath(rset.getString("SAVE_PATH"));
				attaNoti.setFileType(rset.getString("FILE_TYPE"));
				attaNoti.setThumbnailPath(rset.getString("THUMBNAIL_PATH"));
				
				attaNotiList.add(attaNoti);
			}
			
			noticeDetail.setAttaNotiList(attaNotiList);
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return noticeDetail;
	}

	public int updateNotice(Connection con, NoticeDTO newNotice) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("updateNotice");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, newNotice.getTitle());
			pstmt.setString(2, newNotice.getBody());
			pstmt.setInt(3, newNotice.getNo());
			pstmt.setInt(4, newNotice.getWriterMemberNo());
			
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

	public List<NoticeDTO> selectnoticeList(Connection con, NoticePageInfoDTO pageInfo) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<NoticeDTO> noticeList = null;
		
		String query = prop.getProperty("selectNoticeList");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, pageInfo.getStartRow());
			pstmt.setInt(2, pageInfo.getEndRow());
			
			rset = pstmt.executeQuery();
			
			noticeList = new ArrayList<>();
			
			while(rset.next()) {
				NoticeDTO notice = new NoticeDTO();
				notice.setWriter(new MgAdDTO());
				
				notice.setNo(rset.getInt("NOTICE_NO"));
				notice.setTitle(rset.getString("NOTICE_TITLE"));
				notice.setBody(rset.getString("NOTICE_BODY"));
				notice.setWriterMemberNo(rset.getInt("NOTICE_WRITER_MEMBER_NO"));
				notice.getWriter().setName(rset.getString("ADMIN_NAME"));
				notice.setCount(rset.getInt("NOTICE_COUNT"));
				notice.setCreatedDate(rset.getDate("CREATED_DATE"));
				notice.setDisplay(rset.getString("NOTICE_DISPLAY"));
				notice.setGeneral(rset.getString("NOTICE_GENERAL"));
				notice.setGeneralType(rset.getString("NOTICE_GENERAL_TYPE"));
				
				noticeList.add(notice);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return noticeList;
	}

	public int selectNoticeSequence(Connection con) {
		
		Statement stmt = null;
		ResultSet rset = null;
		
		int lastNoticeNo = 0;
		
		String query = prop.getProperty("selectNoticeSequence");
		
		try {
			stmt = con.createStatement();
			
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				lastNoticeNo = rset.getInt("CURRVAL");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return lastNoticeNo;
	}

	public int insertAttaNotice(Connection con, AttaNoticeDTO file) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("insertAttaNotice");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, file.getRefNotiNo());
			pstmt.setString(2, file.getOriginalName());
			pstmt.setString(3, file.getSavedName());
			pstmt.setString(4, file.getSavePath());
			pstmt.setString(5, file.getFileType());
			pstmt.setString(6, file.getThumbnailPath());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int searchNoticeCount(Connection con, SearchReadyDTO searchRd) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int totalCount = 0;
		
		String query = null;
		if("writer".equals(searchRd.getSearchCondition())) {
			query = prop.getProperty("searchTotalWriter");
		} else if("title".equals(searchRd.getSearchCondition())) {
			query = prop.getProperty("searchTotalTitle");
		} else if("body".equals(searchRd.getSearchCondition())) {
			query = prop.getProperty("searchTotalBody");
		} else if("general".equals(searchRd.getSearchCondition())) {
			query = prop.getProperty("searchTotalGeneral");
		} else if("generalType".equals(searchRd.getSearchCondition())) {
			query = prop.getProperty("searchTotalGeneralType");
		}
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, searchRd.getSearchValue());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
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

	public List<NoticeDTO> searchNoticeList(Connection con, SearchReadyDTO searchRd) {
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		List<NoticeDTO> searchNoticeList = null;
		
		String query = null;
		if("writer".equals(searchRd.getSearchCondition())) {
			query = prop.getProperty("searchNoticeListWriter");
		} else if("title".equals(searchRd.getSearchCondition())) {
			query = prop.getProperty("searchNoticeListTitle");
		} else if("body".equals(searchRd.getSearchCondition())) {
			query = prop.getProperty("searchNoticeListBody");
		} else if("general".equals(searchRd.getSearchCondition())) {
			query = prop.getProperty("searchNoticeListGeneral");
		} else if("generalType".equals(searchRd.getSearchCondition())) {
			query = prop.getProperty("searchNoticeListGeneralType");
		}
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, searchRd.getSearchValue());
			pstmt.setInt(2, searchRd.getPageInfo().getStartRow());
			pstmt.setInt(3, searchRd.getPageInfo().getEndRow());
			
			rset = pstmt.executeQuery();
			searchNoticeList = new ArrayList<>();
//			List<AttaNoticeDTO> attaList = null;
			
			while(rset.next()) {
				NoticeDTO noti = new NoticeDTO();
				noti.setWriter(new MgAdDTO());
				noti.setRefNotiNo(new AttaNoticeDTO());
				AttaNoticeDTO atta = new AttaNoticeDTO();
//				attaList = new ArrayList<AttaNoticeDTO>();
				
				noti.setNo(rset.getInt("NOTICE_NO"));
				noti.setTitle(rset.getString("NOTICE_TITLE"));
				noti.setBody(rset.getString("NOTICE_BODY"));
				noti.setWriterMemberNo(rset.getInt("NOTICE_WRITER_MEMBER_NO"));
				noti.getWriter().setName((rset.getString("ADMIN_NAME")));
				noti.setCount(rset.getInt("NOTICE_COUNT"));
				noti.setCreatedDate(rset.getDate("CREATED_DATE"));
				noti.setDisplay(rset.getString("NOTICE_DISPLAY"));
				noti.setGeneral(rset.getString("NOTICE_GENERAL"));
				noti.setGeneralType(rset.getString("NOTICE_GENERAL_TYPE"));
				noti.getRefNotiNo().setRefNotiNo(rset.getInt("REF_NOTI_NO"));
				
//				attaList.add(atta);
//				noti.setAttaNotiList(attaList);
				searchNoticeList.add(noti);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return searchNoticeList;
	}

}


































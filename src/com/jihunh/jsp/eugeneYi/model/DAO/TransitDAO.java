package com.jihunh.jsp.eugeneYi.model.DAO;

import static com.jihunh.jsp.common.jdbc.JDBCTemplate.close;

import java.io.File;
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
import com.jihunh.jsp.common.config.ConfigLocation;
import com.jihunh.jsp.eugeneYi.model.DTO.TransitDTO;
import com.jihunh.jsp.member.model.dto.MgDTO;

public class TransitDAO {
	
	private final Properties prop;
	
	public TransitDAO() {
		prop = new Properties();
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "admin/admin-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public int incrementTransitCount(Connection con, int no) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("incrementTransitCount");
		
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

	public TransitDTO selectTransitDetail(Connection con, int no) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		TransitDTO transitDetail = null;
		
		String query = prop.getProperty("selectTransitDetail");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, no);
			
			rset = pstmt.executeQuery();
			
			List<AttaNoticeDTO> attaNotiList = new ArrayList<>();
			if(rset.next()) {
				transitDetail = new TransitDTO();
//				transitDetail.setdNo();
//				AttaNoticeDTO attaNoti = new AttaNoticeDTO();
				
				transitDetail.setdNo(rset.getInt("DELIVERY_NO"));
				transitDetail.setdType(rset.getString("DELIVERY_TYPE"));
				transitDetail.settNo(rset.getInt("TRANSIT_NO"));
				transitDetail.settDate(rset.getDate("TRANSIT_DATE"));
				transitDetail.setoNo(rset.getInt("ORDER_NO"));
				transitDetail.setMemberNo(rset.getInt("ORDER_MEMBER_NO"));
				transitDetail.setoDate(rset.getDate("ORDER_DATE"));
				transitDetail.setoTitle(rset.getString("ORDER_TITLE"));
				transitDetail.setPrice(rset.getInt("AMOUNT_PRICE"));
//				attaNoti.setNo(rset.getInt("ATTACHMENT_NO"));
//				attaNoti.setOriginalName(rset.getString("ORIGINAL_NAME"));
//				attaNoti.setSavedName(rset.getString("SAVED_NAME"));
//				attaNoti.setSavePath(rset.getString("SAVE_PATH"));
//				attaNoti.setFileType(rset.getString("FILE_TYPE"));
//				attaNoti.setThumbnailPath(rset.getString("THUMBNAIL_PATH"));
				
//				attaNotiList.add(attaNoti);
			}
			
//			transitDetail.setAttaNotiList(attaNotiList);
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return transitDetail;
	}

	public int updateTransit(Connection con, TransitDTO newTransit) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("updateTransit");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, newTransit.getTitle());
			pstmt.setString(2, newTransit.getBody());
			pstmt.setInt(3, newTransit.getNo());
			pstmt.setInt(4, newTransit.getWriterMemberNo());
			
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

}


































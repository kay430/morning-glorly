package com.jihunh.jsp.admin.model.dao;

import static com.jihunh.jsp.common.jdbc.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.jihunh.jsp.admin.model.dto.AttaNoticeDTO;
import com.jihunh.jsp.admin.model.dto.MgAdDTO;
import com.jihunh.jsp.admin.model.dto.NoticeDTO;
import com.jihunh.jsp.admin.model.dto.SearchReadyDTO;
import com.jihunh.jsp.common.config.ConfigLocation;
import com.jihunh.jsp.member.model.dto.MgDTO;

public class MemberDAO {
	
	private final Properties prop;
	
	public MemberDAO() {
		prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "admin/member-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int totalMemberList(Connection con) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int totalCount = 0;
		String query = prop.getProperty("totalMemberList");
		
		try {
			pstmt = con.prepareStatement(query);
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

	public List<MgDTO> mainMemberList(Connection con, SearchReadyDTO memberList) {

		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		List<MgDTO> mgList = null;
		
		String query = prop.getProperty("mainMemberList");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, memberList.getPageInfo().getStartRow());
			pstmt.setInt(2, memberList.getPageInfo().getEndRow());
			
			rset = pstmt.executeQuery();
			
			mgList = new ArrayList<>();
			
			while(rset.next()) {
				MgDTO mgDTO = new MgDTO();
				
				mgDTO.setNo(rset.getInt("MEMBER_NO"));
				mgDTO.setName(rset.getString("MEMBER_NAME"));
				mgDTO.setId(rset.getString("MEMBER_ID"));
				mgDTO.setPno(rset.getString("MEMBER_PNO"));
				mgDTO.setGender(rset.getString("MEMBER_GENDER"));
				mgDTO.setEmail(rset.getString("EMAIL"));
				mgDTO.setAddress(rset.getString("ADDRESS"));
				mgDTO.setPhone(rset.getString("PHONE"));
				mgDTO.setSubPhone(rset.getString("SUB_PHONE"));
				mgDTO.setPoint(rset.getInt("MEMBER_POINT"));
				mgDTO.setEnrollDate(rset.getDate("ENROLL_DATE"));
				mgDTO.setModifiedDate(rset.getDate("MODIFIED_DATE"));
				mgDTO.setBlackList(rset.getString("CHECK_BLACKLIST"));
				mgDTO.setStatus(rset.getString("MEMBER_STATUS"));
				
				mgList.add(mgDTO);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return mgList;
	}

	public int totalMemberAdList(Connection con) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int totalCount = 0;
		String query = prop.getProperty("totalMemberAdList");
		
		try {
			pstmt = con.prepareStatement(query);
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

	public List<MgAdDTO> mainMemberAdList(Connection con, SearchReadyDTO memberAdList) {

		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		List<MgAdDTO> mgAdList = null;
		
		String query = prop.getProperty("mainMemberAdList");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, memberAdList.getPageInfo().getStartRow());
			pstmt.setInt(2, memberAdList.getPageInfo().getEndRow());
			
			rset = pstmt.executeQuery();
			
			mgAdList = new ArrayList<>();
			
			while(rset.next()) {
				MgAdDTO mgAdDTO = new MgAdDTO();
				
				mgAdDTO.setNo(rset.getInt("ADMIN_NO"));
				mgAdDTO.setName(rset.getString("ADMIN_NAME"));
				mgAdDTO.setId(rset.getString("ADMIN_ID"));
				mgAdDTO.setPno(rset.getString("ADMIN_PNO"));
				mgAdDTO.setEmail(rset.getString("EMAIL"));
				mgAdDTO.setEnrollDate(rset.getDate("ENROLL_DATE"));
				mgAdDTO.setStatus(rset.getString("ADMIN_STATUS"));
				
				mgAdList.add(mgAdDTO);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return mgAdList;
	}

	public int searchMemberCount(Connection con, SearchReadyDTO searchRd) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int totalCount = 0;
		
		String query = null;
		if("mgName".equals(searchRd.getSearchCondition())) {
			query = prop.getProperty("searchMgNameCount");
		} else if("mgId".equals(searchRd.getSearchCondition())) {
			query = prop.getProperty("searchMgIdCount");
		} else if("mgPno".equals(searchRd.getSearchCondition())) {
			query = prop.getProperty("searchMgPnoCount");
		} else if("mgGender".equals(searchRd.getSearchCondition())) {
			query = prop.getProperty("searchMgGenderCount");
		} else if("mgAdd".equals(searchRd.getSearchCondition())) {
			query = prop.getProperty("searchMgAddCount");
		} else if("mgBlack".equals(searchRd.getSearchCondition())) {
			query = prop.getProperty("searchMgBlackCount");
		} else if("mgStatus".equals(searchRd.getSearchCondition())) {
			query = prop.getProperty("searchMgStatusCount");
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

	public List<MgDTO> searchNoticeList(Connection con, SearchReadyDTO searchRd) {
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		List<MgDTO> mgList = null;
		
		String query = null;
		if("mgName".equals(searchRd.getSearchCondition())) {
			query = prop.getProperty("searchMgNameList");
		} else if("mgId".equals(searchRd.getSearchCondition())) {
			query = prop.getProperty("searchMgIdList");
		} else if("mgPno".equals(searchRd.getSearchCondition())) {
			query = prop.getProperty("searchMgPnoList");
		} else if("mgGender".equals(searchRd.getSearchCondition())) {
			query = prop.getProperty("searchMgGenderList");
		} else if("mgAdd".equals(searchRd.getSearchCondition())) {
			query = prop.getProperty("searchMgAddList");
		} else if("mgBlack".equals(searchRd.getSearchCondition())) {
			query = prop.getProperty("searchMgBlackList");
		} else if("mgStatus".equals(searchRd.getSearchCondition())) {
			query = prop.getProperty("searchMgStatusList");
		}
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, searchRd.getSearchValue());
			pstmt.setInt(2, searchRd.getPageInfo().getStartRow());
			pstmt.setInt(3, searchRd.getPageInfo().getEndRow());
			
			rset = pstmt.executeQuery();
			
			mgList = new ArrayList<>();
			
			while(rset.next()) {
				MgDTO mgDTO = new MgDTO();
				
				mgDTO.setNo(rset.getInt("MEMBER_NO"));
				mgDTO.setName(rset.getString("MEMBER_NAME"));
				mgDTO.setId(rset.getString("MEMBER_ID"));
				mgDTO.setPno(rset.getString("MEMBER_PNO"));
				mgDTO.setGender(rset.getString("MEMBER_GENDER"));
				mgDTO.setEmail(rset.getString("EMAIL"));
				mgDTO.setAddress(rset.getString("ADDRESS"));
				mgDTO.setPhone(rset.getString("PHONE"));
				mgDTO.setSubPhone(rset.getString("SUB_PHONE"));
				mgDTO.setPoint(rset.getInt("MEMBER_POINT"));
				mgDTO.setEnrollDate(rset.getDate("ENROLL_DATE"));
				mgDTO.setModifiedDate(rset.getDate("MODIFIED_DATE"));
				mgDTO.setBlackList(rset.getString("CHECK_BLACKLIST"));
				mgDTO.setStatus(rset.getString("MEMBER_STATUS"));
				
				mgList.add(mgDTO);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return mgList;
	}

	public int searchMemberAdCount(Connection con, SearchReadyDTO searchRd) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int totalCount = 0;
		
		String query = null;
		if("mgAdName".equals(searchRd.getSearchCondition())) {
			query = prop.getProperty("searchMgAdNameCount");
		} else if("mgAdId".equals(searchRd.getSearchCondition())) {
			query = prop.getProperty("searchMgAdIdCount");
		} else if("mgAdPno".equals(searchRd.getSearchCondition())) {
			query = prop.getProperty("searchMgAdPnoCount");
		} else if("mgAdEmail".equals(searchRd.getSearchCondition())) {
			query = prop.getProperty("searchMgAdEmailCount");
		} else if("mgAdEnrollDate".equals(searchRd.getSearchCondition())) {
			query = prop.getProperty("searchMgAdEnrollDateCount");
		} else if("mgAdStatus".equals(searchRd.getSearchCondition())) {
			query = prop.getProperty("searchMgAdStatusCount");
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

	public List<MgAdDTO> searchMemberAdList(Connection con, SearchReadyDTO searchRd) {
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		List<MgAdDTO> mgAdList = null;
		
		String query = null;
		if("mgAdName".equals(searchRd.getSearchCondition())) {
			query = prop.getProperty("searchMgAdNameList");
		} else if("mgAdId".equals(searchRd.getSearchCondition())) {
			query = prop.getProperty("searchMgAdIdList");
		} else if("mgAdPno".equals(searchRd.getSearchCondition())) {
			query = prop.getProperty("searchMgAdPnoList");
		} else if("mgAdEmail".equals(searchRd.getSearchCondition())) {
			query = prop.getProperty("searchMgAdEmailList");
		} else if("mgAdEnrollDate".equals(searchRd.getSearchCondition())) {
			query = prop.getProperty("searchMgAdEnrollDateList");
		} else if("mgAdStatus".equals(searchRd.getSearchCondition())) {
			query = prop.getProperty("searchMgAdStatusList");
		}
		
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, searchRd.getSearchValue());
			pstmt.setInt(2, searchRd.getPageInfo().getStartRow());
			pstmt.setInt(3, searchRd.getPageInfo().getEndRow());
			
			rset = pstmt.executeQuery();
			
			mgAdList = new ArrayList<>();
			
			while(rset.next()) {
				MgAdDTO mgAdDTO = new MgAdDTO();
				
				mgAdDTO.setNo(rset.getInt("ADMIN_NO"));
				mgAdDTO.setName(rset.getString("ADMIN_NAME"));
				mgAdDTO.setId(rset.getString("ADMIN_ID"));
				mgAdDTO.setPno(rset.getString("ADMIN_PNO"));
				mgAdDTO.setEmail(rset.getString("EMAIL"));
				mgAdDTO.setEnrollDate(rset.getDate("ENROLL_DATE"));
				mgAdDTO.setStatus(rset.getString("ADMIN_STATUS"));
				
				mgAdList.add(mgAdDTO);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return mgAdList;
	}

	public MgDTO viewMemberDetailInfo(Connection con, int no) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		MgDTO noticeDetail = null;
		
		String query = prop.getProperty("selectNoticeDetail");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, no);
			
			rset = pstmt.executeQuery();
			
//			List<AttaNoticeDTO> attaNotiList = new ArrayList<>();
//			if(rset.next()) {
//				noticeDetail = new NoticeDTO();
//				noticeDetail.setWriter(new MgAdDTO());
//				AttaNoticeDTO attaNoti = new AttaNoticeDTO();
//				
//				noticeDetail.setNo(rset.getInt("NOTICE_NO"));
//				noticeDetail.setTitle(rset.getString("NOTICE_TITLE"));
//				noticeDetail.setBody(rset.getString("NOTICE_BODY"));
//				noticeDetail.setWriterMemberNo(rset.getInt("NOTICE_WRITER_MEMBER_NO"));
//				noticeDetail.getWriter().setName(rset.getString("ADMIN_NAME"));
//				noticeDetail.setCount(rset.getInt("NOTICE_COUNT"));
//				noticeDetail.setCreatedDate(rset.getDate("CREATED_DATE"));
//				noticeDetail.setDisplay(rset.getString("NOTICE_DISPLAY"));
//				noticeDetail.setGeneral(rset.getString("NOTICE_GENERAL"));
//				noticeDetail.setGeneralType(rset.getString("NOTICE_GENERAL_TYPE"));
//				attaNoti.setNo(rset.getInt("ATTACHMENT_NO"));
//				attaNoti.setOriginalName(rset.getString("ORIGINAL_NAME"));
//				attaNoti.setSavedName(rset.getString("SAVED_NAME"));
//				attaNoti.setSavePath(rset.getString("SAVE_PATH"));
//				attaNoti.setFileType(rset.getString("FILE_TYPE"));
//				attaNoti.setThumbnailPath(rset.getString("THUMBNAIL_PATH"));
//				
//				attaNotiList.add(attaNoti);
//			}
//			
//			noticeDetail.setAttaNotiList(attaNotiList);
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return noticeDetail;
	}

}

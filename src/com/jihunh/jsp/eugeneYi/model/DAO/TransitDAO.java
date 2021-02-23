package com.jihunh.jsp.eugeneYi.model.DAO;

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
import com.jihunh.jsp.eugeneYi.model.DTO.SearchDTO;
import com.jihunh.jsp.eugeneYi.model.DTO.TransitDTO;
import com.jihunh.jsp.eugeneYi.model.DTO.TransitPageInfoDTO;

public class TransitDAO {
	
	private final Properties prop;
	
	public TransitDAO() {
		prop = new Properties();
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "eugeneYi/mapper.xml"));
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
			
			if(rset.next()) {
				transitDetail = new TransitDTO();
				
				transitDetail.setdNo(rset.getInt("DELIVERY_NO"));
				transitDetail.setdType(rset.getString("DELIVERY_TYPE"));
				transitDetail.settNo(rset.getInt("TRANSIT_NO"));
				transitDetail.settDate(rset.getDate("TRANSIT_DATE"));
				transitDetail.setoNo(rset.getInt("ORDER_NO"));
				transitDetail.setMemberNo(rset.getInt("ORDER_MEMBER_NO"));
				transitDetail.setoDate(rset.getDate("ORDER_DATE"));
				transitDetail.setoTitle(rset.getString("ORDER_TITLE"));
				transitDetail.setPrice(rset.getInt("AMOUNT_PRICE"));

			}
			
		
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
			pstmt.setDate(1, newTransit.gettDate());
			pstmt.setString(2, newTransit.getdType());
			pstmt.setInt(3, newTransit.getdNo());
			pstmt.setInt(4, newTransit.gettNo());
			
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

	public List<TransitDTO> selectTransitList(Connection con, TransitPageInfoDTO pageInfo) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<TransitDTO> transitList = null;
		
		String query = prop.getProperty("selectTransitList");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, pageInfo.getStartRow());
			pstmt.setInt(2, pageInfo.getEndRow());
			
			rset = pstmt.executeQuery();
			
			transitList = new ArrayList<>();
			
			while(rset.next()) {
				TransitDTO transit = new TransitDTO();
//				notice.setWriter(new MgAdDTO());
				
				transit.setdNo(rset.getInt("DELIVERY_NO"));
				transit.setdType(rset.getString("DELIVERY_TYPE"));
				transit.settNo(rset.getInt("TRANSIT_NO"));
				transit.settDate(rset.getDate("TRANSIT_DATE"));
				transit.setoNo(rset.getInt("ORDER_NO"));
				transit.setMemberNo(rset.getInt("ORDER_MEMBER_NO"));
				transit.setoDate(rset.getDate("ORDER_DATE"));
				transit.setoTitle(rset.getString("ORDER_TITLE"));
				transit.setPrice(rset.getInt("AMOUNT_PRICE"));
				
				transitList.add(transit);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return transitList;
	}

	public int selectTransitSequence(Connection con) {
		
		Statement stmt = null;
		ResultSet rset = null;
		
		int lastTransitNo = 0;
		
		String query = prop.getProperty("selectTransitSequence");
		
		try {
			stmt = con.createStatement();
			
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				lastTransitNo = rset.getInt("CURRVAL");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return lastTransitNo;
	}


	public List<TransitDTO> searchTransitList(Connection con, SearchDTO searchTransit) {
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		List<TransitDTO> searchTransitList = null;
		
		String query = null;
		if("type".equals(searchTransit.getSearchCondition())) {
			query = prop.getProperty("searchTransitListByType");
		} else if("tranum".equals(searchTransit.getSearchCondition())) {
			query = prop.getProperty("searchTransitListByTransitNo");
		} else if("orderNo".equals(searchTransit.getSearchCondition())) {
			query = prop.getProperty("searchTransitListByOrderNo");
		}
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, searchTransit.getSearchValue());
			pstmt.setInt(2, searchTransit.getPageInfo().getStartRow());
			pstmt.setInt(3, searchTransit.getPageInfo().getEndRow());
			
			rset = pstmt.executeQuery();
			searchTransitList = new ArrayList<>();
			
			while(rset.next()) {
				TransitDTO transit = new TransitDTO();
				
				transit.setdNo(rset.getInt("DELIVERY_NO"));
				transit.setdType(rset.getString("DELIVERY_TYPE"));
				transit.settNo(rset.getInt("TRANSIT_NO"));
				transit.settDate(rset.getDate("TRANSIT_DATE"));
				transit.setoNo(rset.getInt("ORDER_NO"));
				transit.setMemberNo(rset.getInt("ORDER_MEMBER_NO"));
				transit.setoDate(rset.getDate("ORDER_DATE"));
				transit.setoTitle(rset.getString("ORDER_TITLE"));
				transit.setPrice(rset.getInt("AMOUNT_PRICE"));
				
				searchTransitList.add(transit);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return searchTransitList;
	  
	}


		public int searchTransitCount(Connection con, SearchDTO searchTransit) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int totalCount = 0;
		
		String query = null;
		if("type".equals(searchTransit.getSearchCondition())) {
			query = prop.getProperty("searchTypeCount");
		} else if("tranum".equals(searchTransit.getSearchCondition())) {
			query = prop.getProperty("searchTransitNoCount");
		} else if("orderNo".equals(searchTransit.getSearchCondition())) {
			query = prop.getProperty("searchOdNoCount");
		}
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, searchTransit.getSearchValue());
			
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



//	public int insertAttaNotice(Connection con, AttaNoticeDTO file) {
//		
//		PreparedStatement pstmt = null; 
//		
//		int result = 0;
//		
//		String query = prop.getProperty("insertAttaNotice");
//		
//		try {
//			pstmt = con.prepareStatement(query);
//			pstmt.setInt(1, file.getRefNotiNo());
//			pstmt.setString(2, file.getOriginalName());
//			pstmt.setString(3, file.getSavedName());
//			pstmt.setString(4, file.getSavePath());
//			pstmt.setString(5, file.getFileType());
//			pstmt.setString(6, file.getThumbnailPath());
//			
//			result = pstmt.executeUpdate();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(pstmt);
//		}
//		
//		return result;
//	}

}
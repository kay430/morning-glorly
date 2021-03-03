package com.mg.jsp.admin.model.dao.order;

import static com.mg.jsp.common.jdbc.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.mg.jsp.admin.model.dto.order.OSearchDTO;
import com.mg.jsp.admin.model.dto.order.OrderDTO;
import com.mg.jsp.admin.model.dto.order.OrderPageInfoDTO;
import com.mg.jsp.common.config.ConfigLocation;



public class OrderDAO {
	
	private final Properties prop;
	
	public OrderDAO() {
		prop = new Properties();
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "admin/order-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
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

	public List<OrderDTO> selectOrderList(Connection con, OrderPageInfoDTO pageInfo) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<OrderDTO> orderList = null;
		
		String query = prop.getProperty("selectOrderList");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, pageInfo.getStartRow());
			pstmt.setInt(2, pageInfo.getEndRow());
			
			rset = pstmt.executeQuery();
			
			orderList = new ArrayList<>();
			
			while(rset.next()) {
				OrderDTO order = new OrderDTO();
				
				order.setoNo(rset.getInt("ORDER_NO"));
				order.setmNo(rset.getInt("ORDER_MEMBER_NO"));
				order.setoDate(rset.getDate("ORDER_DATE"));
				order.setoTitle(rset.getString("ORDER_TITLE"));
				order.setAmount(rset.getInt("AMOUNT_PRICE"));
				
				orderList.add(order);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return orderList;
	}

	public int selectOrderSequence(Connection con) {
		
		Statement stmt = null;
		ResultSet rset = null;
		
		int lastOrderNo = 0;
		
		String query = prop.getProperty("selectOrderSequence");
		
		try {
			stmt = con.createStatement();
			
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				lastOrderNo = rset.getInt("CURRVAL");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return lastOrderNo;
	}


	public List<OrderDTO> searchOrderList(Connection con, OSearchDTO searchOrder) {
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		List<OrderDTO> searchOrderList = null;
		
		String query = null;
		if("orderNo".equals(searchOrder.getSearchCondition())) {
			query = prop.getProperty("searchOrderListByOrderNo");
		} else if("memNo".equals(searchOrder.getSearchCondition())) {
			query = prop.getProperty("searchOrderListByMemberNo");
		} else if("orderTitle".equals(searchOrder.getSearchCondition())) {
			query = prop.getProperty("searchOrderListByOrderTitle");
		}
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, searchOrder.getSearchValue());
			pstmt.setInt(2, searchOrder.getPageInfo().getStartRow());
			pstmt.setInt(3, searchOrder.getPageInfo().getEndRow());
			
			rset = pstmt.executeQuery();
			searchOrderList = new ArrayList<>();
			
			while(rset.next()) {
				OrderDTO order = new OrderDTO();
				
				order.setoNo(rset.getInt("ORDER_NO"));
				order.setmNo(rset.getInt("ORDER_MEMBER_NO"));
				order.setoDate(rset.getDate("ORDER_DATE"));
				order.setoTitle(rset.getString("ORDER_TITLE"));
				order.setAmount(rset.getInt("AMOUNT_PRICE"));
				
				searchOrderList.add(order);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return searchOrderList;
	  
	}


		public int searchOrderCount(Connection con, OSearchDTO searchOrder) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int totalCount = 0;
		
		String query = null;
		if("payNo".equals(searchOrder.getSearchCondition())) {
			query = prop.getProperty("searchOrderNoCount");
		} else if("memNo".equals(searchOrder.getSearchCondition())) {
			query = prop.getProperty("searchMemberNoCount");
		} else if("orderTitle".equals(searchOrder.getSearchCondition())) {
			query = prop.getProperty("searchOrderTitleCount");
		}
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, searchOrder.getSearchValue());
			
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

}
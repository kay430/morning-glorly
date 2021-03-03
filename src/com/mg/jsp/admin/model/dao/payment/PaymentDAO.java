package com.mg.jsp.admin.model.dao.payment;

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

import com.mg.jsp.admin.model.dto.payment.PaymentDTO;
import com.mg.jsp.admin.model.dto.payment.PaymentPageInfoDTO;
import com.mg.jsp.admin.model.dto.payment.PSearchDTO;
import com.mg.jsp.common.config.ConfigLocation;



public class PaymentDAO {
	
	private final Properties prop;
	
	public PaymentDAO() {
		prop = new Properties();
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "admin/payment-mapper.xml"));
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

	public List<PaymentDTO> selectPaymentList(Connection con, PaymentPageInfoDTO pageInfo) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<PaymentDTO> paymentList = null;
		
		String query = prop.getProperty("selectPaymentList");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, pageInfo.getStartRow());
			pstmt.setInt(2, pageInfo.getEndRow());
			
			rset = pstmt.executeQuery();
			
			paymentList = new ArrayList<>();
			
			while(rset.next()) {
				PaymentDTO payment = new PaymentDTO();
				
				payment.setpNo(rset.getInt("PAYMENT_NO"));
				payment.setoNo(rset.getInt("PAYMENT_ORDER_NO"));
				payment.setmNo(rset.getInt("PAYMENT_MEMBER_NO"));
				payment.setAmount(rset.getInt("FINAL_PAYMENT_PRICE"));
				payment.setUsedPoint(rset.getInt("USED_POINT"));
				payment.setpType(rset.getString("PAYMENT_STATUS"));
				payment.setpDate(rset.getDate("PAYMENT_DATE"));
				
				paymentList.add(payment);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return paymentList;
	}

	public int selectPaymentSequence(Connection con) {
		
		Statement stmt = null;
		ResultSet rset = null;
		
		int lastPaymentNo = 0;
		
		String query = prop.getProperty("selectPaymentSequence");
		
		try {
			stmt = con.createStatement();
			
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				lastPaymentNo = rset.getInt("CURRVAL");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return lastPaymentNo;
	}


	public List<PaymentDTO> searchPaymentList(Connection con, PSearchDTO searchPayment) {
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		List<PaymentDTO> searchPaymentList = null;
		
		String query = null;
		if("payNo".equals(searchPayment.getSearchCondition())) {
			query = prop.getProperty("searchPaymentListByPaymentNo");
		} else if("memNo".equals(searchPayment.getSearchCondition())) {
			query = prop.getProperty("searchPaymentListByMemberNo");
		} else if("orderNo".equals(searchPayment.getSearchCondition())) {
			query = prop.getProperty("searchPaymentListByOrderNo");
		}
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, searchPayment.getSearchValue());
			pstmt.setInt(2, searchPayment.getPageInfo().getStartRow());
			pstmt.setInt(3, searchPayment.getPageInfo().getEndRow());
			
			rset = pstmt.executeQuery();
			searchPaymentList = new ArrayList<>();
			
			while(rset.next()) {
				PaymentDTO payment = new PaymentDTO();
				
				payment.setpNo(rset.getInt("PAYMENT_NO"));
				payment.setoNo(rset.getInt("PAYMENT_ORDER_NO"));
				payment.setmNo(rset.getInt("PAYMENT_MEMBER_NO"));
				payment.setAmount(rset.getInt("FINAL_PAYMENT_PRICE"));
				payment.setUsedPoint(rset.getInt("USED_POINT"));
				payment.setpType(rset.getString("PAYMENT_STATUS"));
				payment.setpDate(rset.getDate("PAYMENT_DATE"));
				
				searchPaymentList.add(payment);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return searchPaymentList;
	  
	}


		public int searchPaymentCount(Connection con, PSearchDTO searchPayment) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int totalCount = 0;
		
		String query = null;
		if("payNo".equals(searchPayment.getSearchCondition())) {
			query = prop.getProperty("searchPaymentNoCount");
		} else if("memNo".equals(searchPayment.getSearchCondition())) {
			query = prop.getProperty("searchMemberNoCount");
		} else if("orderNo".equals(searchPayment.getSearchCondition())) {
			query = prop.getProperty("searchOdNoCount");
		}
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, searchPayment.getSearchValue());
			
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
		
		public PaymentDTO selectPaymentDetail(Connection con, int no) {
			
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			PaymentDTO paymentDetail = null;
			
			List<PaymentDTO> trdList = new ArrayList<>();
			String query = prop.getProperty("selectPaymentDetail");
			System.out.println(no);
			
			try {
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, no);
				
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					paymentDetail = new PaymentDTO();
					
					paymentDetail.setpNo(rset.getInt("PAYMENT_NO"));
					paymentDetail.setoNo(rset.getInt("PAYMENT_ORDER_NO"));
					paymentDetail.setmNo(rset.getInt("PAYMENT_MEMBER_NO"));
					paymentDetail.setAmount(rset.getInt("FINAL_PAYMENT_PRICE"));
					paymentDetail.setUsedPoint(rset.getInt("USED_POINT"));
					paymentDetail.setpType(rset.getString("PAYMENT_STATUS"));
					paymentDetail.setpDate(rset.getDate("PAYMENT_DATE"));
					paymentDetail.setmName(rset.getString("MEMBER_NAME"));
					paymentDetail.setPhNo(rset.getInt("MEMBER_PNO"));
					paymentDetail.setmType(rset.getString("MEMBER_STATUS"));
					paymentDetail.setEmail(rset.getString("EMAIL"));
					paymentDetail.setmPoint(rset.getInt("MEMBER_PNO"));
					
					trdList.add(paymentDetail);
					
				}
			
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}

			return paymentDetail;
		}

}
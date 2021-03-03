package com.mg.jsp.payment.model.dao;

import static com.mg.jsp.common.jdbc.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mg.jsp.common.config.ConfigLocation;
import com.mg.jsp.member.model.dto.MgDTO;
import com.mg.jsp.order.model.dto.OrderDTO;
import com.mg.jsp.order.model.dto.OrderDeliveryDTO;

public class PaymentDAO {

	private final Properties prop;
	
	public PaymentDAO() {
		prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "member/member-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public MgDTO selectMemberInfo(Connection con, String memId) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectMemberInfo");
		
		MgDTO mgDTO = null;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, memId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				mgDTO = new MgDTO();
				
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
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return mgDTO;
	}

	public int insertOrder(Connection con, OrderDTO order) {

		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("insertOrder");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, order.getMgInfo().getNo());
			pstmt.setString(2, order.getOrderTitle());
			pstmt.setInt(3, order.getAmountPrice());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		if(result > 0) {
			System.out.println("첫번째 관문 통과");
			System.out.println("1 : " + order.getMgInfo().getNo());
			System.out.println("2 : " + order.getOrderTitle());
			System.out.println("3 : " + order.getAmountPrice());
		} else {
			System.out.println("첫번째 탈락");
		}
		
		return result;
	}
	
	
	public OrderDTO selectOrderNoSequence(Connection con, OrderDTO order) {
		
		System.out.println("시퀀스 조회 가자");
		
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectOrderNoSequence");
		
		try {
			stmt = con.createStatement();
			
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				order.setNo(rset.getInt("CURRVAL"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		System.out.println("시퀀스 번호 : " + order.getNo());
		return order;
	}
	
	

	public int insertOrderGoods(Connection con, OrderDTO order) {

		System.out.println("주문상품 등록 가자");
		System.out.println("가져온 주문 시퀀스 : " + order.getNo());
		System.out.println("2 : " + order.getOrderGoods().get(0).getAmountCount());
		System.out.println("3 : " + order.getOrderGoods().get(0).getGoodsPrice());
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("insertOrderGoods");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, order.getNo());
			pstmt.setInt(2, order.getOrderGoods().get(0).getGoodsNo());
			pstmt.setInt(3, order.getOrderGoods().get(0).getAmountCount());
			pstmt.setInt(4, order.getOrderGoods().get(0).getGoodsPrice());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		if(result > 0) {
			System.out.println("두 번째 관문 통과");
		} else {
			System.out.println("두 번째 탈락");
		}
		
		return result;
	}

	public int insertOrderDelivery(Connection con, OrderDTO order) {

		System.out.println("배송 등록 ");
		
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("insertOrderDelivery");
		
		int result = 0;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, order.getNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		if(result > 0) {
			System.out.println("세 번째 관문 통과");
		} else {
			System.out.println("세 번째 탈락");
		}
		
		return result;
	}
	
	public OrderDTO selectOrderDeliveryNoSequence(Connection con, OrderDTO order) {
		
		System.out.println("시퀀스 조회 가자");
		
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectOrderDeliveryNoSequence");

		try {
			stmt = con.createStatement();
			
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				order.getOrderDeli().get(0).setNo(rset.getInt("CURRVAL"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		System.out.println("현재 여기에 뭐가 이씅ㄹ까 : " + order.getOrderDeli());
	
		return order;
	}

	public int insertOrderAddress(Connection con, OrderDTO order) {

		System.out.println("배송주소 등록 ");
		
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("insertOrderAddress");
		
		int result = 0;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, order.getOrderDeli().get(0).getNo());
			pstmt.setString(2, order.getOrderAdd().get(0).getAddType());
			pstmt.setString(3, order.getOrderAdd().get(0).getRecieverName());
			pstmt.setString(4, order.getOrderAdd().get(0).getRecieverPhone());
			pstmt.setString(5, order.getOrderAdd().get(0).getRecieverAdd());
			pstmt.setInt(6, order.getOrderAdd().get(0).getMemNo());
			
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		if(result > 0) {
			System.out.println("네 번째 관문 통과");
		} else {
			System.out.println("네 번째 탈락");
		}
		
		return result;
	}

	public int insertOrderPayment(Connection con, OrderDTO order) {

		System.out.println("결제 등록 ");
		
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("insertOrderPayment");
		
		int result = 0;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, order.getNo());
			pstmt.setInt(2, order.getPayment().get(0).getMgInfo().getNo());
			pstmt.setInt(3, order.getPayment().get(0).getFinalPrice());
			pstmt.setInt(4, order.getPayment().get(0).getUsedPoint());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		if(result > 0) {
			System.out.println("다섯 번째 관문 통과");
		} else {
			System.out.println("다섯 번째 탈락");
		}
		
		return result;
	}

	public OrderDTO selectOrderPaymentNoSequence(Connection con, OrderDTO order) {
		
		System.out.println("결제 시퀀스 조회 가자");
		
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectOrderPaymentNoSequence");

		try {
			stmt = con.createStatement();
			
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				order.getPayment().get(0).setNo(rset.getInt("CURRVAL"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		System.out.println("현재 여기에 뭐가 결제 시퀀스? : " + order.getPayment());
	
		return order;
	}

	public int insertOrderPaymentDivision(Connection con, OrderDTO order) {

		System.out.println("결제 등록 ");
		
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("insertOrderPaymentDivision");
		System.out.println("최종 승인 번호 : " + order.getPayDivi().get(0).getAdmissionPayNo());
		int result = 0;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, order.getPayment().get(0).getNo());
			pstmt.setInt(2, order.getPayDivi().get(0).getAdmissionPayNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		if(result > 0) {
			System.out.println("여섯 번째 관문 통과");
		} else {
			System.out.println("여섯 번째 탈락");
		}
		
		return result;
	}

	public int InsertMemberPoint(Connection con, OrderDTO order) {

		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("InsertMemberPoint");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, order.getPayment().get(0).getNo());
			pstmt.setInt(2, order.getMgInfo().getPoint());
			pstmt.setInt(3, order.getMgInfo().getNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int UpdateMemberInfo(Connection con, OrderDTO order) {

		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("UpdateMemberInfo");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, order.getMgInfo().getPoint());
			pstmt.setInt(2, order.getMgInfo().getNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}


	public int InsertMemberModify(Connection con, OrderDTO order) {

		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("InsertMemberModify");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "POINT");
			pstmt.setInt(2, order.getExistingPoint());
			pstmt.setInt(3, order.getMgInfo().getPoint());
			pstmt.setInt(4, order.getMgInfo().getNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	
}



















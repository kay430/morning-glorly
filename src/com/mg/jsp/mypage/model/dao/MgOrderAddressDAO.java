package com.mg.jsp.mypage.model.dao;

import static com.mg.jsp.common.jdbc.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.mg.jsp.admin.model.dto.MemberPointDTO;
import com.mg.jsp.admin.model.product.model.dto.MgGoodsDTO;
import com.mg.jsp.common.config.ConfigLocation;
import com.mg.jsp.member.model.dto.MgDTO;
import com.mg.jsp.mypage.model.dto.MgOrderAddressDTO;
import com.mg.jsp.mypage.model.dto.MgOrderDTO;
import com.mg.jsp.mypage.model.dto.MgOrderDeliveryDTO;
import com.mg.jsp.mypage.model.dto.MgOrderGoodsDTO;

public class MgOrderAddressDAO {
	
	private final Properties prop;
	
	public MgOrderAddressDAO() {
		prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "mypage/orderSelect-mapper.xml"));
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}

	public List<MgOrderAddressDTO> selectAllOrderList(Connection con) {
		
		PreparedStatement pstmt = null; 
		ResultSet rset = null;
		
		List<MgOrderAddressDTO> mypageOrderList = null;
		
		String query = prop.getProperty("selectAllOrderList");
		
		try {
			pstmt = con.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			
			mypageOrderList = new ArrayList<>();
			
			while(rset.next()) {
				MgOrderAddressDTO order = new MgOrderAddressDTO();
				MgOrderDeliveryDTO delivery = new MgOrderDeliveryDTO();
				MgOrderDTO order1 = new MgOrderDTO();
				MgGoodsDTO goods = new MgGoodsDTO();
				MgOrderGoodsDTO ordegoods = new MgOrderGoodsDTO();
				
				order.setMgOrderDeliveryDTO(delivery);
				order.setMgGoodsDTO(goods);
				order.setMgOrderDTO(order1);
				order.setMgOrderGoodsDTO(ordegoods);
				
				
				order.setOrderAddNo(rset.getInt("ORDER_ADD_NO"));
				order.setMemberNo(rset.getInt("MEMBER_NO"));
				order.getMgOrderDTO().setMemberNo(rset.getInt("ORDER_MEMBER_NO"));
				order.getMgOrderDTO().setDate(rset.getDate("ORDER_DATE"));
				order.getMgOrderGoodsDTO().setGoodsNo(rset.getInt("GOODS_NO"));
				order.getMgGoodsDTO().setName(rset.getString("GOODS_NAME"));
				order.getMgGoodsDTO().setPrice(rset.getInt("GOODS_PRICE"));
				order.getMgOrderGoodsDTO().setAmountCount(rset.getInt("AMOUNT_COUNT"));
				order.getMgOrderDeliveryDTO().setType(rset.getString("DELIVERY_TYPE"));
				order.getMgOrderDTO().setAmountPrice(rset.getInt("ORDER_GOODS_PRICE"));
				order.getMgOrderDTO().setTitle(rset.getString("ORDER_TITLE"));
				order.setDeliveryNo(rset.getInt("DELIVERY_NO"));
				order.setRecieverName(rset.getString("RECIEVER_NAME"));
				order.setPhone(rset.getString("RECIEVER_PHONE"));
				order.setRecieverAddress(rset.getString("RECIEVER_ADDRESS"));
				
				mypageOrderList.add(order);
				
//				   A.ORDER_ADD_NO
//		              , A.MEMBER_NO
//		              , B.ORDER_MEMBER_NO
//		              , B.ORDER_DATE
//		              , B.ORDER_TITLE
//		              , A.DELIVERY_NO
//		              , A.RECIEVER_NAME
//		              , A.RECIEVER_PHONE
//		              , A.RECIEVER_ADDRESS
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
				
		
		return mypageOrderList;
	}

//	public List<MgOrderAddressDTO> selectNewPointList(Connection con, MgDTO no) {
		
		/*PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<MgOrderAddressDTO> newPoint = null; 
		
		String query = prop.getProperty("selectNewPoint");
		
		try {
			pstmt = con.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			
			newPoint = new ArrayList<>();
			
			List<MemberPointDTO> newPointInfo = new ArrayList<>();
			while(rset.next()){
				
				
				
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		
		return newPoint;*/
//	}

	public List<MgOrderAddressDTO> selectNewPointList(Connection con, int no, List<MgOrderAddressDTO> mypageOrderList1) {
		PreparedStatement pstmt = null; 
		ResultSet rset = null;
		
		String query = prop.getProperty("selectNewPoint");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, no);
			rset = pstmt.executeQuery();
			
			while(rset.next()){
				
				MgDTO pointInfo = new MgDTO();
				
				pointInfo.setPoint(rset.getInt("MEMBER_POINT"));
					
				mypageOrderList1.get(0).setMgDTO(pointInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return mypageOrderList1;
	}

	
}

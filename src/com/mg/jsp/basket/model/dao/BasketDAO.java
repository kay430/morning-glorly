package com.mg.jsp.basket.model.dao;

import java.io.FileInputStream;
import static com.mg.jsp.common.jdbc.JDBCTemplate.close;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.mg.jsp.admin.model.product.model.dto.AttachmentDTO;
import com.mg.jsp.admin.model.product.model.dto.MgGoodsDTO;
import com.mg.jsp.basket.model.dto.basketDTO;
import com.mg.jsp.common.config.ConfigLocation;
import com.mg.jsp.member.model.dto.MgDTO;

public class BasketDAO {
	
	private final Properties prop;
	
	public BasketDAO() {
		prop = new Properties();
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "basket/basket-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public basketDTO selectBasketInfo(Connection con, int no) {
		
		System.out.println("DAO시작입니다");
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		basketDTO detailInfo1 = null;
		
		String query = prop.getProperty("selectBasketInfo");
		
		try {
			System.out.println("여기는 try");
			MgDTO mg = new MgDTO();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, no);
			/* pstmt.setInt(2, mg.getNo()); */
			
			rset = pstmt.executeQuery();
			System.out.println("여긴 rset마지막 ");
			
			
			List<AttachmentDTO> attachmentList = new ArrayList<>();
			detailInfo1 = new basketDTO();
			
			while(rset.next()) {
				System.out.println("들어오니?");
				AttachmentDTO attachment = new AttachmentDTO();
				MgGoodsDTO goods = new MgGoodsDTO();
				
				detailInfo1.setMgGoodsDTO(goods);
				
				detailInfo1.getMgDTO().setNo(rset.getInt("MEMBER_NO"));
				detailInfo1.getMgDTO().setName(rset.getString("MEMBER_NAME"));
				detailInfo1.setGoodsNo(rset.getInt("GOODS_NO"));
				detailInfo1.getMgGoodsDTO().setName(rset.getString("GOODS_NAME"));
				detailInfo1.getMgGoodsDTO().setPrice(rset.getInt("GOODS_PRICE"));
				attachment.setThumbnailPath(rset.getString("THUMBNAIL_PATH"));
				detailInfo1.setAmountCount(rset.getInt("AMOUNT_COUNT"));
				
				System.out.println("여기는 rset 안  detailInfo1 : "   + detailInfo1);
				
				
				attachmentList.add(attachment);				
			}
			detailInfo1.setAttachmentList(attachmentList);
			System.out.println("detailInfo1 : "   + detailInfo1);
			
		} catch (SQLException e) {
			System.out.println("cat로들어온다");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		System.out.println("return전 출력문 ");
		return detailInfo1;
	}

}

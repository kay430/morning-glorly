package com.jihunh.jsp.admin.model.product.model.dao;

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

import com.jihunh.jsp.admin.model.product.model.dto.AttachmentDTO;
import com.jihunh.jsp.admin.model.product.model.dto.MgGoodsDTO;
import com.jihunh.jsp.admin.model.product.model.dto.MgGoodsTypeDTO;
import com.jihunh.jsp.common.config.ConfigLocation;
import com.jihunh.jsp.customerservice.model.dto.PageInfoDTO;

public class MgGoodsDAO {
   
   private final Properties prop;
   
   public MgGoodsDAO() {
      prop = new Properties();
      
      try {
         prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "admin/product-mapper.xml"));
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
   
   /*
    * public List<MgGoodsDTO> selectAllGoods(Connection con) {
    * 
    * Statement stmt = null; ResultSet rset = null;
    * 
    * List<MgGoodsDTO> goodsList = null;
    * 
    * String query = prop.getProperty("selectAllGoods");
    * 
    * try { stmt = con.createStatement(); rset = stmt.executeQuery(query);
    * 
    * goodsList = new ArrayList<>();
    * 
    * while(rset.next()) { MgGoodsDTO goods = new MgGoodsDTO();
    * goods.setGoodsTypeNo(new MgGoodsTypeDTO());
    * 
    * goods.setNo(rset.getInt("GOODS_NO"));
    * goods.setName(rset.getString("GOODS_NAME"));
    * goods.setPrice(rset.getInt("GOODS_PRICE"));
    * goods.setWriterMemberNo(rset.getInt("GOODS_WRITER_MEMBER_NO"));
    * goods.setTypeNo(rset.getInt("GOODS_TYPE_NO"));
    * goods.getGoodsTypeNo().setName(rset.getString("GOODS_TYPE_NAME"));
    * goods.setCreatedDate(rset.getDate("CREATED_DATE"));
    * goods.setStatus(rset.getString("GOODS_STATUS"));
    * goods.setModifiedDate(rset.getDate("MODIFIED_DATE"));
    * 
    * goodsList.add(goods);
    * 
    * } } catch (SQLException e) { // TODO Auto-generated catch block
    * e.printStackTrace(); } finally { close(stmt); close(rset); }
    * 
    * return goodsList;
    */
   //}

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
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
         close(stmt);
         close(rset);
      }
      
      return totalCount;
   }

   public List<MgGoodsDTO> selectAllGoodsList(Connection con, PageInfoDTO pageInfo) {
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      
      List<MgGoodsDTO> goodsList1 = null;
      
      String query = prop.getProperty("selectAllGoodsList");
      
      try {
         pstmt = con.prepareStatement(query);
         pstmt.setInt(1, pageInfo.getStartRow());
         pstmt.setInt(2, pageInfo.getEndRow());
         
         rset= pstmt.executeQuery();
         
         goodsList1 = new ArrayList<>();
         
         while(rset.next()) {
            MgGoodsDTO goods1 = new MgGoodsDTO();
            goods1.setGoodsTypeNo(new MgGoodsTypeDTO());
            
            goods1.setNo(rset.getInt("GOODS_NO"));
            goods1.setName(rset.getString("GOODS_NAME"));
            goods1.setPrice(rset.getInt("GOODS_PRICE"));
            goods1.setWriterMemberNo(rset.getInt("GOODS_WRITER_MEMBER_NO"));
            goods1.setTypeNo(rset.getInt("GOODS_TYPE_NO"));
            goods1.getGoodsTypeNo().setName(rset.getString("GOODS_TYPE_NAME"));
            goods1.setCreatedDate(rset.getDate("CREATED_DATE"));
            goods1.setStatus(rset.getString("GOODS_STATUS"));
            goods1.setModifiedDate(rset.getDate("MODIFIED_DATE"));
            
              
            
            
            
            goodsList1.add(goods1);
         }
         
         
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
         close(pstmt);
         close(rset);
      }
      
      
      return goodsList1;
   }

   public int searchProductCount(Connection con, String searchCondition, String searchValue) {
      
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      
      int searchProductCount = 0;
      
      String query = null;
      if("mdCode".equals(searchCondition)) {
         query = prop.getProperty("searchMdCodeCount");
      }else if("mdType".equals(searchCondition)){
         query = prop.getProperty("searchMdTypeCount");
      }else if("mdName".equals(searchCondition)) {
         query = prop.getProperty("searchMdNameCount");
      }
      
      try {
         pstmt = con.prepareStatement(query);
         pstmt.setString(1, searchValue);
         
         rset = pstmt.executeQuery();
         
         if(rset.next()) {
            searchProductCount = rset.getInt("COUNT(*)");
         }
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }finally{
         close(rset);
         close(pstmt);
         
      }
      return searchProductCount;
   }
   //서치 조회용 ~
   public List<MgGoodsDTO> searchProductList(Connection con, String searchCondition, String searchValue,
         PageInfoDTO pageInfo) {
      
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      
      List<MgGoodsDTO> searchProductList = null;
      
      String query = null;
      
      if("mdCode".equals(searchCondition)) {
         query = prop.getProperty("searchMdCodeList");
      }else if("mdType".equals(searchCondition)){
         query = prop.getProperty("searchMdTypeList");
      }else if("mdName".equals(searchCondition)) {
         query = prop.getProperty("searchMdNameList");
      }
      
      try {
         pstmt = con.prepareStatement(query);
         pstmt.setString(1, searchValue);
         pstmt.setInt(2, pageInfo.getStartRow());
         pstmt.setInt(3, pageInfo.getEndRow());
         
         rset = pstmt.executeQuery();
         
         searchProductList = new ArrayList<>();
         
         while(rset.next()) {
            MgGoodsDTO goods = new MgGoodsDTO();
            goods.setGoodsTypeNo(new MgGoodsTypeDTO());
            
            goods.setNo(rset.getInt("GOODS_NO"));
            goods.setName(rset.getString("GOODS_NAME"));
            goods.setPrice(rset.getInt("GOODS_PRICE"));
            goods.setWriterMemberNo(rset.getInt("GOODS_WRITER_MEMBER_NO"));
            goods.setTypeNo(rset.getInt("GOODS_TYPE_NO"));
            goods.getGoodsTypeNo().setName(rset.getString("GOODS_TYPE_NAME"));
            goods.setCreatedDate(rset.getDate("CREATED_DATE"));
            goods.setStatus(rset.getString("GOODS_STATUS"));
            goods.setModifiedDate(rset.getDate("MODIFIED_DATE"));
            
            searchProductList.add(goods);
         }
         
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }finally {
         close(pstmt);
         close(rset);
      }
      
      return searchProductList;
   }

   
   //썸네일..   제목하고 내용
   public int insertThumbnailContent(Connection con, MgGoodsDTO thumbnail) {
      
      PreparedStatement pstmt = null;
      
      int result = 0;
      System.out.println("thumb :"  +thumbnail);
      
      String query = prop.getProperty("insertThumbnailContent");
      System.out.println("인서트 쿼리 : " + query);

      try {
         pstmt = con.prepareStatement(query);
         pstmt.setString(1, thumbnail.getName());
         pstmt.setInt(2, thumbnail.getPrice());
         pstmt.setInt(3, thumbnail.getWriterMemberNo());
         pstmt.setInt(4, thumbnail.getGoodsTypeNo().getNo());
         
         result = pstmt.executeUpdate();
         System.out.println("상품등러록 결과 " + result);
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
         close(pstmt);
      }
      
      return result;
   }

   public int selectThumbnailSequence(Connection con) {
		
		Statement stmt = null;
		ResultSet rset = null;
		
		int lastNoticeNo = 0;
		
		String query = prop.getProperty("selectThumbnailSequence");
		System.out.println("너의 쿼리 이름은 무엇인가? : " + query); 
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

   public int insertAttachment(Connection con, AttachmentDTO file) {

      PreparedStatement pstmt = null;
      
      int result = 0;
      
      String query = prop.getProperty("insertAttachment");
      
      try {
         pstmt = con.prepareStatement(query);
         pstmt.setInt(1, file.getRefGoodsNo());
         pstmt.setString(2, file.getOriginalName());
         pstmt.setString(3, file.getSavedName());
         pstmt.setString(4, file.getSavePath());
         pstmt.setString(5, file.getFileType());
         pstmt.setString(6, file.getThumbnailPath());
         
         result = pstmt.executeUpdate();
         
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
         close(pstmt);
      }
      
      return result;
   }

}
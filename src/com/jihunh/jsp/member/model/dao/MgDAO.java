package com.jihunh.jsp.member.model.dao;

import static com.jihunh.jsp.common.jdbc.JDBCTemplate.close;
import static com.jihunh.jsp.common.jdbc.JDBCTemplate.close;
import static com.jihunh.jsp.member.controller.SendupdatePwd.getEmail;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.jihunh.jsp.common.config.ConfigLocation;
import com.jihunh.jsp.member.model.dto.MgDTO;
public class MgDAO {

   private final Properties prop;
   
   public MgDAO() {
      prop = new Properties();
      
      try {
         prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "member/member-mapper.xml"));
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
   
   public int insertMember(Connection con, MgDTO requestMember) {
      
      PreparedStatement pstmt = null;
      
      int result = 0;
      
      String query = prop.getProperty("insertMember");
      
      try {
         pstmt = con.prepareStatement(query);
         pstmt.setString(1, requestMember.getName());
         pstmt.setString(2, requestMember.getId());
         pstmt.setString(3, requestMember.getPwd());
         pstmt.setString(4, requestMember.getPno());
         pstmt.setString(5, requestMember.getGender());
         pstmt.setString(6, requestMember.getEmail());
         pstmt.setString(7, requestMember.getAddress());
         pstmt.setString(8, requestMember.getPhone());
         pstmt.setString(9, requestMember.getSubPhone());
         
         result = pstmt.executeUpdate();
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close(pstmt);
      }
      
      return result;
   }

   public String selectEncryptPwd(Connection con, MgDTO requestMember) {
      System.out.println("DAO에서 비번 조회하자");
      System.out.println(requestMember.getId());
      PreparedStatement pstmt = null;
      
      ResultSet rset = null;
      
      String encPwd = null;
      
      String query = prop.getProperty("selectEncryptPwd");
      
      try {
         pstmt = con.prepareStatement(query);
         pstmt.setString(1, requestMember.getId());
         
         rset = pstmt.executeQuery();
         
         if(rset.next()) {
            encPwd = rset.getString("MEMBER_PWD");
         }
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close(rset);
         close(pstmt);
      }
      
      return encPwd;
   }


	public MgDTO selectLoginMember(Connection con, MgDTO requestMember) {
		System.out.println("멤버 조회 DAO 들어왔나?");
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		MgDTO loginMember = null;
		
		String query = prop.getProperty("selectLoginMember");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, requestMember.getId());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				loginMember = new MgDTO();
				loginMember.setNo(rset.getInt("MEMBER_NO"));
				loginMember.setName(rset.getString("MEMBER_NAME"));
				loginMember.setId(rset.getString("MEMBER_ID"));
				loginMember.setPno(rset.getString("MEMBER_PNO"));
				loginMember.setGender(rset.getString("MEMBER_GENDER"));
				loginMember.setEmail(rset.getString("EMAIL"));
				loginMember.setAddress(rset.getString("ADDRESS"));
				loginMember.setPhone(rset.getString("PHONE"));
				loginMember.setSubPhone(rset.getString("SUB_PHONE"));
				loginMember.setPoint(rset.getInt("MEMBER_POINT"));
				loginMember.setEnrollDate(rset.getDate("ENROLL_DATE"));
				loginMember.setModifiedDate(rset.getDate("MODIFIED_DATE"));
				loginMember.setBlackList(rset.getString("CHECK_BLACKLIST"));
				loginMember.setStatus(rset.getString("MEMBER_STATUS"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return loginMember;
	}


//   public String selectMemberName(Connection con, MgDTO requestMember) {
//
//      PreparedStatement pstmt = null;
//      ResultSet rset = null;
//      
//      String Name = null;
//      
//      String query = prop.getProperty("selectMemberName");
//      
//      try {
//         pstmt = con.prepareStatement(query);
//         pstmt.setString(1, requestMember.getId());
//         
//         rset = pstmt.executeQuery();
//         
//         if(rset.next()) {
//            Name = rset.getString("MEMBER_NAME");
//         }
//         System.out.println(Name);
//      } catch (SQLException e) {
//         // TODO Auto-generated catch block
//         e.printStackTrace();
//      } finally {
//         close(pstmt);
//      }
//      
//      return Name;
//   }

   public MgDTO selectMemberInfo(Connection con, MgDTO requestMember) {
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      
      MgDTO memberInfo = null;
      
      String query = prop.getProperty("selectMemberInfo");
      
      try {
         pstmt = con.prepareStatement(query);
         pstmt.setString(1, requestMember.getName());
         pstmt.setString(2, requestMember.getPhone());
         
         rset = pstmt.executeQuery();
         System.out.println("안녕");
         
         if(rset.next()) {
            memberInfo = new MgDTO();
            
            memberInfo.setId(rset.getString("MEMBER_ID"));
            memberInfo.setName(rset.getString("MEMBER_NAME"));
            System.out.println("여기가 최종인데~~" + memberInfo);
         }
      } catch (SQLException e) {
         
         e.printStackTrace();
      } finally {
         close(pstmt);
         close(rset);
      }
      
      return memberInfo;
   }

   public MgDTO findPwd(Connection con, MgDTO requestMember) {
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      
      MgDTO memberInfo2 = null;
      
      String query = prop.getProperty("findPwd");
      
      try {
         pstmt = con.prepareStatement(query);
         pstmt.setString(1, requestMember.getId());
         pstmt.setString(2, requestMember.getName());
         pstmt.setString(3, requestMember.getPhone());
         pstmt.setString(4, requestMember.getEmail());
         
         rset = pstmt.executeQuery();
         
         if(rset.next()) {
            memberInfo2 = new MgDTO();
            memberInfo2.setNo(rset.getInt("MEMBER_NO"));
            memberInfo2.setPwd(rset.getString("MEMBER_PWD"));
         }
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
         
      }
         System.out.println(memberInfo2);   
            
      return memberInfo2;
   }

   public int updatePwd(Connection con, MgDTO requestMember) {
      
      PreparedStatement pstmt = null;
      int result = 0;
      
      String query = prop.getProperty("updatePwd");
      
      try {
         pstmt = con.prepareStatement(query);
         pstmt.setString(1, requestMember.getPwd());
         pstmt.setString(2, requestMember.getPhone());
         
         result = pstmt.executeUpdate();
         
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
         close(pstmt);
      }
      return result;
   }

public int deleteMember(Connection con, MgDTO requestMember) {
		PreparedStatement pstmt = null;
	
		int result = 0;
	
		String query = prop.getProperty("deleteMember");
	
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, requestMember.getNo());
		
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		  close(pstmt);
		}
	
	return result;
  }

}




















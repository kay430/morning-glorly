package com.jihunh.jsp.member.model.dao;

import static com.jihunh.jsp.common.jdbc.JDBCTemplate.close;

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
			pstmt.setString(6, requestMember.getAddress());
			pstmt.setString(7, requestMember.getEmail());
			pstmt.setString(8, requestMember.getPhone());
			
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
				loginMember.setPhone(rset.getString("PHONE"));
				loginMember.setEmail(rset.getString("EMAIL"));
				loginMember.setAddress(rset.getString("ADDRESS"));
				loginMember.setEnrollDate(rset.getDate("ENROLL_DATE"));
				loginMember.setRole(rset.getString("MEMBER_ROLE"));
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

}



















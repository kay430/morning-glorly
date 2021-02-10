package com.jihunh.jsp.admin.model.dao;

import static com.jihunh.jsp.common.jdbc.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.jihunh.jsp.admin.model.dto.MgAdDTO;
import com.jihunh.jsp.common.config.ConfigLocation;
import com.jihunh.jsp.member.model.dto.MgDTO;
public class MgAdDAO {

	private final Properties prop;
	
	public MgAdDAO() {
		prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "admin/admin-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int insertMember(Connection con, MgAdDTO requestAdmin) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("insertAdmin");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, requestAdmin.getName());
			pstmt.setString(2, requestAdmin.getId());
			pstmt.setString(3, requestAdmin.getPwd());
			pstmt.setString(4, requestAdmin.getPno());
			pstmt.setString(5, requestAdmin.getEmail());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public String selectEncryptPwd(Connection con, MgAdDTO requestMember) {
		System.out.println("DAO에서 비번 조회하자");
		System.out.println(requestMember.getId());
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String encPwd = null;
		
		String query = prop.getProperty("selectAdminPwd");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, requestMember.getId());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				encPwd = rset.getString("ADMIN_PWD");
				System.out.println("DAO에서 rset.next : " + encPwd);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return encPwd;
	}

	public MgAdDTO selectLoginMember(Connection con, MgAdDTO requestMember) {
		System.out.println("멤버 조회 DAO 들어왔나?");
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		MgAdDTO loginAdmin = null;
		
		String query = prop.getProperty("selectLoginAdmin");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, requestMember.getId());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				loginAdmin = new MgAdDTO();
				loginAdmin.setNo(rset.getInt("ADMIN_NO"));
				loginAdmin.setName(rset.getString("ADMIN_NAME"));
				loginAdmin.setId(rset.getString("ADMIN_ID"));
				loginAdmin.setPno(rset.getString("ADMIN_PNO"));
				loginAdmin.setEmail(rset.getString("EMAIL"));
				loginAdmin.setEnrollDate(rset.getDate("ENROLL_DATE"));
				loginAdmin.setStatus(rset.getString("ADMIN_STATUS"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return loginAdmin;
	}

}




















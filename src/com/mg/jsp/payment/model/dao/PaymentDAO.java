package com.mg.jsp.payment.model.dao;

import static com.mg.jsp.common.jdbc.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mg.jsp.common.config.ConfigLocation;
import com.mg.jsp.member.model.dto.MgDTO;

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

	
}



















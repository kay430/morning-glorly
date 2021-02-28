package com.mg.jsp.payment.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
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

	public MgDTO selectMemberInfo(String memId) {
		
		
		return null;
	}

	
}



















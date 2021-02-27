package com.mg.jsp.payment.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.mg.jsp.common.config.ConfigLocation;

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

	
}



















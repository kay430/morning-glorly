package com.mg.jsp.order.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.mg.jsp.common.config.ConfigLocation;

public class OrderGoodsDAO {

	private final Properties prop;
	
	public OrderGoodsDAO() {
		prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "member/member-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}



















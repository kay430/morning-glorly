package com.jihunh.jsp.order.model.dao;

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



















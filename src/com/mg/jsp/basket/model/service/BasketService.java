package com.mg.jsp.basket.model.service;

import java.sql.Connection;

import com.mg.jsp.basket.model.dao.BasketDAO;
import com.mg.jsp.basket.model.dto.basketDTO;

import static com.mg.jsp.common.jdbc.JDBCTemplate.getConnection;
import static com.mg.jsp.common.jdbc.JDBCTemplate.close;


public class BasketService {

	private BasketDAO basketDAO;
	
	public BasketService() {
		basketDAO = new BasketDAO();
	}

	public basketDTO selectBasketInfo(int no) {
	 Connection con = getConnection();
	
	 System.out.println("서비스라인입니다 오나여?");
	 basketDTO detailInfo1 = basketDAO.selectBasketInfo(con, no);
	
	 close(con);
	 System.out.println("서비스끝나는곳 : " + detailInfo1);
	 return detailInfo1;
	}

		
	
	
}

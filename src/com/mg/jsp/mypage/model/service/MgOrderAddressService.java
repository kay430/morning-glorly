package com.mg.jsp.mypage.model.service;

import static com.mg.jsp.common.jdbc.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.mg.jsp.member.model.dto.MgDTO;
import com.mg.jsp.mypage.model.dao.MgOrderAddressDAO;
import com.mg.jsp.mypage.model.dto.MgOrderAddressDTO;
import static com.mg.jsp.common.jdbc.JDBCTemplate.close;
public class MgOrderAddressService {
	
	private MgOrderAddressDAO mgOrderAddressDAO;
	
	public MgOrderAddressService() {
		mgOrderAddressDAO = new MgOrderAddressDAO();
	}

	

	public List<MgOrderAddressDTO> selectAllOrderList(int no) {
		Connection con = getConnection();
		 
		 
		List<MgOrderAddressDTO> mypageOrderList1 = mgOrderAddressDAO.selectAllOrderList(con);
		 mypageOrderList1 = mgOrderAddressDAO.selectNewPointList(con, no, mypageOrderList1);
		
		close(con);
		
		return mypageOrderList1;
		
	}

	

}

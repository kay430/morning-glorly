package com.mg.jsp.payment.model.service;

import static com.mg.jsp.common.jdbc.JDBCTemplate.getConnection;

import java.sql.Connection;

import com.mg.jsp.member.model.dto.MgDTO;
import com.mg.jsp.payment.model.dao.PaymentDAO;

public class PaymentService {
	
	private final PaymentDAO payDAO;

	public PaymentService() {
		
		payDAO = new PaymentDAO();
	}

	public MgDTO selectMemberInfo(String memId) {
		
		Connection con = getConnection();
		
		MgDTO result = payDAO.selectMemberInfo(memId);		
		return null;
	}




}

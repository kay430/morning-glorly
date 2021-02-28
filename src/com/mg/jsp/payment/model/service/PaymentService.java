package com.mg.jsp.payment.model.service;

import static com.mg.jsp.common.jdbc.JDBCTemplate.getConnection;
import static com.mg.jsp.common.jdbc.JDBCTemplate.commit;
import static com.mg.jsp.common.jdbc.JDBCTemplate.rollback;

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
		
		MgDTO result = payDAO.selectMemberInfo(con, memId);	
		
		if(result != null) {
			commit(con);
		} else {
			rollback(con);
		}
		
		return result;
	}




}

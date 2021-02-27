package com.mg.jsp.payment.model.service;

import static com.jihunh.jsp.common.jdbc.JDBCTemplate.close;
import static com.jihunh.jsp.common.jdbc.JDBCTemplate.commit;
import static com.jihunh.jsp.common.jdbc.JDBCTemplate.getConnection;
import static com.jihunh.jsp.common.jdbc.JDBCTemplate.rollback;
import static com.jihunh.jsp.member.controller.SendupdatePwd.getEmail;

import java.sql.Connection;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.jihunh.jsp.member.model.dao.MgDAO;
import com.jihunh.jsp.member.model.dto.MgDTO;

public class PaymentService {


	public PaymentService() {
	}




}

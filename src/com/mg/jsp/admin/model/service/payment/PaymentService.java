package com.mg.jsp.admin.model.service.payment;

import static com.mg.jsp.common.jdbc.JDBCTemplate.close;
import static com.mg.jsp.common.jdbc.JDBCTemplate.commit;
import static com.mg.jsp.common.jdbc.JDBCTemplate.getConnection;
import static com.mg.jsp.common.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.mg.jsp.admin.model.dao.payment.PaymentDAO;
import com.mg.jsp.admin.model.dto.payment.PaymentDTO;
import com.mg.jsp.admin.model.dto.payment.PaymentPageInfoDTO;
import com.mg.jsp.transit.model.DTO.TransitDTO;
import com.mg.jsp.admin.model.dto.payment.PSearchDTO;


public class PaymentService {
	
	private final PaymentDAO paymentDAO;
	
	public PaymentService() { 
		paymentDAO = new PaymentDAO();
	}

	public int selectTotalCount() {
		
	Connection con = getConnection();
		
		int totalCount = paymentDAO.selectTotalCount(con);
		
		close(con);
		
		return totalCount;
		
	}

	public List<PaymentDTO> selectPaymentList(PaymentPageInfoDTO pageInfo) {
		
		Connection con = getConnection();
		
		List<PaymentDTO> paymentList = paymentDAO.selectPaymentList(con, pageInfo);
		
		close(con);
		
		return paymentList;
	}
	
	public int searchPaymentCount(PSearchDTO searchPayment) {
		
		Connection con = getConnection();
		
		int totalPaymentCount = paymentDAO.searchPaymentCount(con, searchPayment); 
		
		close(con);
		
		return totalPaymentCount;
	}

	public List<PaymentDTO> searchPaymentList(PSearchDTO searchPayment) {
		
		Connection con = getConnection();
		
		List<PaymentDTO> searchPaymentList = paymentDAO.searchPaymentList(con, searchPayment);
		
		close(con);
		
		return searchPaymentList;
	}
	
	public PaymentDTO selectPaymentDetail(int no) {
		
		Connection con = getConnection();
		PaymentDTO paymentDetail = null;

		paymentDetail = paymentDAO.selectPaymentDetail(con, no);

		if(paymentDetail != null) {
			commit(con);
		} else {
			rollback(con);
		}

		return paymentDetail;
	}

}











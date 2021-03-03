package com.mg.jsp.payment.model.service;

import static com.mg.jsp.common.jdbc.JDBCTemplate.getConnection;
import static com.mg.jsp.common.jdbc.JDBCTemplate.commit;
import static com.mg.jsp.common.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;

import com.mg.jsp.member.model.dto.MgDTO;
import com.mg.jsp.order.model.dto.OrderDTO;
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

	public int insertOrderResult(OrderDTO order) {
		
		Connection con = getConnection();
		
		int result3 = 0;
		
		/* 1. 주문 테아블 */
		int insertOrder = payDAO.insertOrder(con, order);	
		
		/* == 주문 시퀀스 조회 == */
		order = payDAO.selectOrderNoSequence(con, order);	
		
		/* 2. 주문 상품 테이블 */
		int insertOrderGoods = payDAO.insertOrderGoods(con, order);	
		
		/* 3. 주문 배송 테이블 */
		int insertOrderDelivery = payDAO.insertOrderDelivery(con, order);
		
		/* == 배송 시퀀스 조회 == */
		order = payDAO.selectOrderDeliveryNoSequence(con, order);	
		
		/* 4. 배송 주소 구분 */
		int insertOrderAddress = payDAO.insertOrderAddress(con, order);
		
		/* 5. 결제 테이블 */
		int insertPayment = payDAO.insertOrderPayment(con, order);
		
		/* == 결제 시퀀스 조회 == */
		order = payDAO.selectOrderPaymentNoSequence(con, order);	
		
		/* 6. 결제 구분 테이블 */
		int insertPaymentDivision = payDAO.insertOrderPaymentDivision(con, order);
		
		/* === Insert 6개 테이블 결과 처리 === */
		int result1 = insertOrder + insertOrderGoods + insertOrderDelivery + insertOrderAddress + insertPayment + insertPaymentDivision;
		if(result1 > 5) {
			commit(con);
		} else {
			rollback(con);
		}

		
		/* 7. 포인트 사용 유무에 따른  테이블 3개 */
		if(order.getPayment().get(0).getUsedPoint() == 0) {
			System.out.println("포인트 안씀");
		} else {
			/* 포인트 테이블 -> 회원 테이블 -> 정보 수정이력 */
			int insertMemberPoint = payDAO.InsertMemberPoint(con, order);
			int updateMemberInfo = payDAO.UpdateMemberInfo(con, order);
			int insertMemberModify = payDAO.InsertMemberModify(con, order);

			/* === Insert 3개 테이블 결과 처리 === */
			int result2 = insertMemberPoint + updateMemberInfo + insertMemberModify;
			if(result2 > 2) {
				commit(con);
				System.out.println("포인트 처리 완료 : " + result2);
				result3 = 9;
			} else {
				rollback(con);
				result3 = 0;
			}
		}
		
		return result3;
	}





}

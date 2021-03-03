package com.mg.jsp.admin.controller.payment;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mg.jsp.admin.model.dto.payment.PaymentDTO;
import com.mg.jsp.admin.model.dto.payment.PaymentPageInfoDTO;
import com.mg.jsp.admin.model.service.payment.PaymentService;
import com.mg.jsp.common.paging.Pagenation;

@WebServlet("/admin/payment")
public class PaymentAdmin extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String currentPage = request.getParameter("currentPage");
		
		int pageNo = 1;
		
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}
		
		if(pageNo <= 0) {
			pageNo = 1;
		}
		
		PaymentService tSv = new PaymentService();
		int totalCount = tSv.selectTotalCount();
		
		int limit = 10;
		int buttonAmount = 5;
		
		PaymentPageInfoDTO pageInfo = Pagenation.getPageInfoPayment(pageNo, totalCount, limit, buttonAmount);
		
		List<PaymentDTO> paymentList = tSv.selectPaymentList(pageInfo);
		
		for(PaymentDTO payment : paymentList) {
			System.out.println(payment); 
		}
		
		
		String path = "";
		if(paymentList != null) {
			path = "/WEB-INF/views/admin/payment/PaymentList.jsp";
			request.setAttribute("paymentList", paymentList);
			request.setAttribute("pageInfo", pageInfo);
		} else {
			path = "WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "결제내역 조회 실패!!!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
		
		
	}
}

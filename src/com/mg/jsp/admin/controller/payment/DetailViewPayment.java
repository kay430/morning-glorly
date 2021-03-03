package com.mg.jsp.admin.controller.payment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mg.jsp.admin.model.dto.payment.PaymentDTO;
import com.mg.jsp.payment.model.service.PaymentService;


@WebServlet("/admin/payment/detail")
public class DetailViewPayment extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		int pageNumNo = no;
		
		PaymentDTO paymentDetail = new PaymentService().selectPaymentDetail(no);
		
		System.out.println(paymentDetail);
		System.out.println("주서온 글과 이미지 : " + paymentDetail);
		
		String path = "";
		if(paymentDetail != null) {
			path = "/WEB-INF/views/payment/PaymentDetail.jsp";
			request.setAttribute("payment", paymentDetail);
			request.setAttribute("pageNumNo", pageNumNo);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "배송조회 상세 조회에 실패하셨습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}


}

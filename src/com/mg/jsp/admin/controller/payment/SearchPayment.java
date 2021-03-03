package com.mg.jsp.admin.controller.payment;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mg.jsp.admin.model.dto.payment.PSearchDTO;
import com.mg.jsp.admin.model.dto.payment.PaymentDTO;
import com.mg.jsp.admin.model.dto.payment.PaymentPageInfoDTO;
import com.mg.jsp.admin.model.service.payment.PaymentService;
import com.mg.jsp.common.paging.Pagenation;



@WebServlet("/admin/payment/search")
public class SearchPayment extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String currentPage = request.getParameter("currentPage");
		
		int pageNo = 0;
		
		if(currentPage !=null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}
		
		if(pageNo <= 0) {
			pageNo = 1;
		}
		
		PSearchDTO searchPayment = new PSearchDTO();
		searchPayment.setPageInfo(new PaymentPageInfoDTO());
		searchPayment.setSearchCondition(request.getParameter("searchCondition"));
		searchPayment.setSearchValue(request.getParameter("searchValue"));
		searchPayment.getPageInfo().setPageNo(pageNo);
		searchPayment.getPageInfo().setTotalCount((new PaymentService().searchPaymentCount(searchPayment)));
		searchPayment.getPageInfo().setLimit(10);
		searchPayment.getPageInfo().setButtonAmount(5);  

		List<PaymentDTO> paymentList = new PaymentService().searchPaymentList(Pagenation.getPaymentPage(searchPayment));
		
		String path = "";
		
		if(paymentList != null) {
			path = "/WEB-INF/views/admin/payment/PaymentList.jsp";
			request.setAttribute("paymentList", paymentList);
			request.setAttribute("pageInfo", searchPayment.getPageInfo());
			request.setAttribute("searchCondition", searchPayment.getSearchCondition());
			request.setAttribute("searchValue", searchPayment.getSearchValue());
		} else {
			path = "/WEB-INF/views/common/error404.jsp";
			request.setAttribute("messeage", "실패");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}


}
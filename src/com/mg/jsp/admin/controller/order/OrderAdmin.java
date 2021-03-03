package com.mg.jsp.admin.controller.order;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mg.jsp.admin.model.dto.order.OrderDTO;
import com.mg.jsp.admin.model.dto.order.OrderPageInfoDTO;
import com.mg.jsp.admin.model.service.order.OrderService;
import com.mg.jsp.common.paging.Pagenation;

@WebServlet("/admin/order")
public class OrderAdmin extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String currentPage = request.getParameter("currentPage");
		
		int pageNo = 1;
		
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}
		
		if(pageNo <= 0) {
			pageNo = 1;
		}
		
		OrderService tSv = new OrderService();
		int totalCount = tSv.selectTotalCount();
		
		int limit = 10;
		int buttonAmount = 5;
		
		OrderPageInfoDTO pageInfo = Pagenation.getPageInfoOrder(pageNo, totalCount, limit, buttonAmount);
		
		List<OrderDTO> orderList = tSv.selectOrderList(pageInfo);
		
		for(OrderDTO order : orderList) {
			System.out.println(order); 
		}
		
		
		String path = "";
		if(orderList != null) {
			path = "/WEB-INF/views/admin/order/OrderList.jsp";
			request.setAttribute("orderList", orderList);
			request.setAttribute("pageInfo", pageInfo);
		} else {
			path = "WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "결제내역 조회 실패!!!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
		
		
	}
}

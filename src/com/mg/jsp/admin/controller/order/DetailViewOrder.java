package com.mg.jsp.admin.controller.order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mg.jsp.admin.model.dto.order.OrderDTO;
import com.mg.jsp.admin.model.service.order.OrderService;


@WebServlet("/admin/order/detail")
public class DetailViewOrder extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		int pageNumNo = no;
		
		OrderDTO orderDetail = new OrderService().selectOrderDetail(no);
		
		System.out.println(orderDetail);
		System.out.println("주서온 글과 이미지 : " + orderDetail);
		
		String path = "";
		if(orderDetail != null) {
			path = "/WEB-INF/views/admin/order/OrderDetail.jsp";
			request.setAttribute("order", orderDetail);
			request.setAttribute("pageNumNo", pageNumNo);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "배송조회 상세 조회에 실패하셨습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}


}

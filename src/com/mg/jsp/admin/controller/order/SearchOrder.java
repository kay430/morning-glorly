package com.mg.jsp.admin.controller.order;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mg.jsp.admin.model.dto.order.OSearchDTO;
import com.mg.jsp.admin.model.dto.order.OrderDTO;
import com.mg.jsp.admin.model.dto.order.OrderPageInfoDTO;
import com.mg.jsp.admin.model.service.order.OrderService;
import com.mg.jsp.common.paging.Pagenation;



@WebServlet("/admin/order/search")
public class SearchOrder extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String currentPage = request.getParameter("currentPage");
		
		int pageNo = 0;
		
		if(currentPage !=null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}
		
		if(pageNo <= 0) {
			pageNo = 1;
		}
		
		OSearchDTO searchOrder = new OSearchDTO();
		searchOrder.setPageInfo(new OrderPageInfoDTO());
		searchOrder.setSearchCondition(request.getParameter("searchCondition"));
		searchOrder.setSearchValue(request.getParameter("searchValue"));
		searchOrder.getPageInfo().setPageNo(pageNo);
		searchOrder.getPageInfo().setTotalCount((new OrderService().searchOrderCount(searchOrder)));
		searchOrder.getPageInfo().setLimit(10);
		searchOrder.getPageInfo().setButtonAmount(5);  

		List<OrderDTO> orderList = new OrderService().searchOrderList(Pagenation.getOrderPage(searchOrder));
		
		String path = "";
		
		if(orderList != null) {
			path = "/WEB-INF/views/admin/order/OrderList.jsp";
			request.setAttribute("orderList", orderList);
			request.setAttribute("pageInfo", searchOrder.getPageInfo());
			request.setAttribute("searchCondition", searchOrder.getSearchCondition());
			request.setAttribute("searchValue", searchOrder.getSearchValue());
		} else {
			path = "/WEB-INF/views/common/error404.jsp";
			request.setAttribute("messeage", "실패");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}


}
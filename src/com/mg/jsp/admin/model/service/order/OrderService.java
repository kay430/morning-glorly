package com.mg.jsp.admin.model.service.order;

import static com.mg.jsp.common.jdbc.JDBCTemplate.close;
import static com.mg.jsp.common.jdbc.JDBCTemplate.commit;
import static com.mg.jsp.common.jdbc.JDBCTemplate.getConnection;
import static com.mg.jsp.common.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.mg.jsp.admin.model.dao.order.OrderDAO;
import com.mg.jsp.admin.model.dto.order.OSearchDTO;
import com.mg.jsp.admin.model.dto.order.OrderDTO;
import com.mg.jsp.admin.model.dto.order.OrderPageInfoDTO;
import com.mg.jsp.admin.model.dto.order.OrderDTO;


public class OrderService {
	
	private final OrderDAO orderDAO;
	
	public OrderService() { 
		orderDAO = new OrderDAO();
	}

	public int selectTotalCount() {
		
	Connection con = getConnection();
		
		int totalCount = orderDAO.selectTotalCount(con);
		
		close(con);
		
		return totalCount;
		
	}

	public List<OrderDTO> selectOrderList(OrderPageInfoDTO pageInfo) {
		
		Connection con = getConnection();
		
		List<OrderDTO> orderList = orderDAO.selectOrderList(con, pageInfo);
		
		close(con);
		
		return orderList;
	}
	
	public int searchOrderCount(OSearchDTO searchOrder) {
		
		Connection con = getConnection();
		
		int totalOrderCount = orderDAO.searchOrderCount(con, searchOrder); 
		
		close(con);
		
		return totalOrderCount;
	}

	public List<OrderDTO> searchOrderList(OSearchDTO searchOrder) {
		
		Connection con = getConnection();
		
		List<OrderDTO> searchOrderList = orderDAO.searchOrderList(con, searchOrder);
		
		close(con);
		
		return searchOrderList;
	}
	
	public OrderDTO selectOrderDetail(int no) {
		
		Connection con = getConnection();
		OrderDTO orderDetail = null;

		orderDetail = orderDAO.selectOrderDetail(con, no);

		if(orderDetail != null) {
			commit(con);
		} else {
			rollback(con);
		}

		return orderDetail;
	}


}











package com.jihunh.jsp.admin.controller.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jihunh.jsp.admin.model.product.model.service.MgGoodsService;

/**
 * Servlet implementation class ProductSearchServlet
 */
@WebServlet("/admin/product/search")
public class ProductSearchServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String searchCondition = request.getParameter("searchCondition");
		String searchValue = request.getParameter("searchValue");
		
		System.out.println("condition : " + searchCondition);
		System.out.println("value :" + searchValue);
		
		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;
		
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}
		
		if(pageNo <= 0) {
			pageNo = 1;
		}
		MgGoodsService mgGoodsService = new MgGoodsService();
		int totalCount = mgGoodsService.searchProductCount(searchCondition,searchValue);
		
		System.out.println("totalCount : " + totalCount );
		
	}


}

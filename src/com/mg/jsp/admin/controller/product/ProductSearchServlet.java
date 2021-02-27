package com.mg.jsp.admin.controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jihunh.jsp.admin.model.product.model.dto.MgGoodsDTO;
import com.jihunh.jsp.admin.model.product.model.service.MgGoodsService;
import com.jihunh.jsp.common.paging.Pagenation;
import com.jihunh.jsp.customerservice.model.dto.PageInfoDTO;

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
		
		int limit = 10;
		int buttonAmount = 5;
		
		PageInfoDTO pageInfo = Pagenation.getPageInfo(pageNo, totalCount, limit, buttonAmount);
		
		System.out.println(pageInfo);
		
		List<MgGoodsDTO> goodsList  = mgGoodsService.searchProductList(searchCondition , searchValue, pageInfo);
		
//		System.out.println("productList : " + productList);
		
		for(MgGoodsDTO goods : goodsList) {
			System.out.println("List = " + goods);
		}
		
		String path = "";
		if(goodsList != null ) {
			path = "/WEB-INF/views/admin/selectProduct.jsp";
			request.setAttribute("goodsList", goodsList);
			request.setAttribute("pageInfo", pageInfo);
			request.setAttribute("searchCondition", searchCondition);
			request.setAttribute("searchValue", searchValue);
		}else {
			path = "/WEB-INF/views/main/failed.jsp";
			request.setAttribute("message","상품조회게시판 게시물 검색실패" );
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}


}

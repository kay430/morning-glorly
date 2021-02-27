package com.mg.jsp.admin.controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mg.jsp.admin.model.product.model.dto.MgGoodsDTO;
import com.mg.jsp.admin.model.product.model.service.MgGoodsService;
import com.mg.jsp.common.paging.Pagenation;
import com.mg.jsp.customerservice.model.dto.PageInfoDTO;



@WebServlet("/admin/SelectProduct")
public class SelectProductServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//페이징처리
		String currentPage = request.getParameter("currentPage");
		
		
		int pageNo = 1;
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}
		if(pageNo <= 0 ) {
			pageNo = 1;
		}
		System.out.println("currentPage: " + currentPage);
		System.out.println("pageNo  : " + pageNo);
		
		//페이징처리하기위해서는 총 게시물의 수가 필요하다
		//게시물의 수 조회하기!
		MgGoodsService mgGoodsService = new MgGoodsService();
		int totalCount = mgGoodsService.selectTotalCount();
		System.out.println("totalCount : " + totalCount);
		
		//한페이지의 보여줄 게시물게수 
		int limit = 10;
		
		/*한번에 보여줄 버튼 갯수*/
		int buttonAmount = 5;
		
		PageInfoDTO pageInfo = Pagenation.getPageInfo(pageNo, totalCount, limit, buttonAmount);
		System.out.println("pageInfo : " + pageInfo);
		
		
		List<MgGoodsDTO> goodsList = new MgGoodsService().selectAllGoodsList(pageInfo);
		
		
		for(MgGoodsDTO goods : goodsList) {
			System.out.println("goods1 : " + goods);
		}
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////		
		/*
		 * List<MgGoodsDTO> goodsList = new MgGoodsService().selectAllGoods();
		 * 
		 * System.out.println("goodsList : " + goodsList); for(MgGoodsDTO goods :
		 * goodsList) { System.out.println(goods); }
		 */
		
		String path = "";
		if(goodsList != null) {
			path = "/WEB-INF/views/admin/selectProduct.jsp";
			request.setAttribute("goodsList", goodsList);
			request.setAttribute("pageInfo", pageInfo);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "게시물 목록 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}
	

}

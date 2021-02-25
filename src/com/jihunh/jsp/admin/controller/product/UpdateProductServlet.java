package com.jihunh.jsp.admin.controller.product;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jihunh.jsp.admin.model.product.model.dto.MgGoodsDTO;
import com.jihunh.jsp.admin.model.product.model.service.MgGoodsService;


@WebServlet("/admin/update/product")
public class UpdateProductServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		  int no = Integer.parseInt(request.getParameter("no"));
		 
		  MgGoodsDTO detailInfo = new MgGoodsService().selectOnedetailInfo(no);
		 
		  System.out.println("detailInfo " + detailInfo);
		 
		
		  
		String path = "";	
		if(detailInfo !=null) {
			path = "/WEB-INF/views/admin/updateProduct.jsp";
			request.setAttribute("detailInfo", detailInfo);
			
		} else {
			path= "/WEB-INF/views/main/failed.jsp";
			request.setAttribute("message", "상세조회실패");
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String updateProduct = request.getParameter("updateProduct");
		String updateCode = request.getParameter("updateCode");
		String updateName = request.getParameter("updateName");
		int price = Integer.parseInt(request.getParameter("price"));
		Date updateDate = java.sql.Date.valueOf(request.getParameter("updateDate"));
		String updateStatus = request.getParameter("updatestatus");
		String picture = request.getParameter("picture");
		
		System.out.println(updateProduct);
		System.out.println(updateCode);
		System.out.println(updateName);
		System.out.println(price);
		System.out.println(updateDate);
		System.out.println(updateStatus);
		System.out.println(picture);
		
		
		
	}

}

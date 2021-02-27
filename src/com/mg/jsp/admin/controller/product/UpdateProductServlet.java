package com.mg.jsp.admin.controller.product;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mg.jsp.admin.model.product.model.dto.MgGoodsDTO;
import com.mg.jsp.admin.model.product.model.service.MgGoodsService;


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
		int updateCode = Integer.parseInt(request.getParameter("updateCode"));
		String updateName = request.getParameter("updateName");
		int price = Integer.parseInt(request.getParameter("price"));
		Date updateDate = java.sql.Date.valueOf(request.getParameter("updateDate"));
		String updateStatus = request.getParameter("updatestatus");
		String picture = request.getParameter("picture");
		  int no = Integer.parseInt(request.getParameter("no"));

		
		System.out.println(updateProduct);
		System.out.println(updateCode);
		System.out.println(updateName);
		System.out.println(price);
		System.out.println(updateDate);
		System.out.println(updateStatus);
		System.out.println(picture);
		
		
		 MgGoodsDTO changeInfo = new MgGoodsDTO(); 
		/*
		 * changeInfo.getGoodsTypeNo().setName(updateProduct);
		 * changeInfo.getGoodsTypeNo().setNo(updateCode);
		 */
		 changeInfo.setNo(no);
		 changeInfo.setName(updateName);
		 changeInfo.setPrice(price);
		 changeInfo.setCreatedDate(updateDate);
		 changeInfo.setStatus(updateStatus);
		 changeInfo.getAttachmentList();
		 
		 System.out.println("changeInfo : " + changeInfo);
		 
		 MgGoodsService mgGoodsService = new MgGoodsService();
		 int result = mgGoodsService.updateInfo(changeInfo);
		 
		 System.out.println("result : " + result );
			
		 
		 String path = "";	
			if(result > 0) {
				path = "/WEB-INF/views/admin/SelectProduct.jsp";
			} else{
				path= "/WEB-INF/views/main/failed.jsp";
				request.setAttribute("message", "상세조회실패");
			}
			request.getRequestDispatcher(path).forward(request, response);
		
		 
		 
		
	}
}

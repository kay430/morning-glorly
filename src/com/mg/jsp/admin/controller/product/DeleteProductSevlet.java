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


@WebServlet("/admin/delete/product")
public class DeleteProductSevlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		
		
		 MgGoodsDTO deleteInfo = new MgGoodsDTO(); 
		/*
		 * changeInfo.getGoodsTypeNo().setName(updateProduct);
		 * changeInfo.getGoodsTypeNo().setNo(updateCode);
		 */
		 deleteInfo.setNo(no);
		 deleteInfo.setName(updateName);
		 deleteInfo.setPrice(price);
		 deleteInfo.setCreatedDate(updateDate);
		 deleteInfo.setStatus(updateStatus);
		 deleteInfo.getAttachmentList();
		 
		 System.out.println("deleteInfo : " + deleteInfo);
		 
		 MgGoodsService mgGoodsService = new MgGoodsService();
		 int result = mgGoodsService.deleteProduct(deleteInfo);
		 
		 System.out.println("result : " + result );
			
		 
		 String path = "";	
			if(result > 0) {
				path = "/WEB-INF/views/admin/SelectProduct.jsp";
			} else{
				path= "/WEB-INF/views/main/failed.jsp";
				request.setAttribute("message", "삭제실패");
			}
			request.getRequestDispatcher(path).forward(request, response);
	}

}

package com.jihunh.jsp.admin.controller.product;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/admin/registProduct")
public class RegistProductServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/WEB-INF/views/admin/registProduct.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String producyType = request.getParameter("productType");
		String productCode = request.getParameter("productCode");
		String productName = request.getParameter("productName");
		int price = Integer.parseInt(request.getParameter("price"));
	    Date registDate = java.sql.Date.valueOf(request.getParameter("registDate"));
	    String status = request.getParameter("status");
		
		
		doGet(request, response);
	}

}

package com.jihunh.jsp.payment.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/proceed/payment")
public class ProceedPayment extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/WEB-INF/views/payment/payment.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String imp_uid = request.getParameter("imp_uid");
		String merchant_uid = request.getParameter("merchant_uid");
		
		/*
		 * HashMap<String, Object> hashMap = new HashMap<String, Object>;
		 * hashMap.put("imp_uid", rsp.imp_uid);
		 */
		
		
	}

}
	
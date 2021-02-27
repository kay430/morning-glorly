package com.mg.jsp.transit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.mg.jsp.transit.model.DTO.TransitDTO;
import com.mg.jsp.transit.model.service.TransitService;

@WebServlet("/admin/transit/update")
public class UpdateTransit extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		System.out.println("=========================================" + request.getParameter("typeSel"));
		
		TransitDTO newTransit = new TransitDTO();
		String sed = request.getParameter("typeSel");
		int delNo = Integer.parseInt(request.getParameter("delNum"));
		int tranNo = Integer.parseInt(request.getParameter("tranNum"));
		System.out.println(delNo);
		System.out.println(tranNo);
		newTransit.setdType(sed);
		newTransit.setdNo(delNo);
		newTransit.settNo(tranNo);
		
		
		System.out.println(newTransit);

		
		TransitDTO result = new TransitService().updateTransit(newTransit);
		System.out.println("변경 된 내용 출력 : " + result);
		
		String jsonString = new Gson().toJson(result);

		System.out.println(jsonString);

		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		response.getWriter();
		
		out.append(jsonString);
	
		out.flush(); 
		out.close();
		
	}

}























package com.mg.jsp.transit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mg.jsp.transit.model.DTO.TransitDTO;
import com.mg.jsp.transit.model.service.TransitService;


@WebServlet("/admin/transit/detail")
public class DetailViewTransit extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		int pageNumNo = no;
		
		TransitDTO transitDetail = new TransitService().selectTransitDetail(no);
		
		System.out.println(transitDetail);
		System.out.println("주서온 글과 이미지 : " + transitDetail);
		
		String path = "";
		if(transitDetail != null) {
			path = "/WEB-INF/views/transit/TransitDetail.jsp";
			request.setAttribute("transit", transitDetail);
			request.setAttribute("pageNumNo", pageNumNo);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "배송조회 상세 조회에 실패하셨습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}


}

package com.mg.jsp.transit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mg.jsp.common.paging.Pagenation;
import com.mg.jsp.transit.model.DTO.TransitDTO;
import com.mg.jsp.transit.model.DTO.TransitPageInfoDTO;
import com.mg.jsp.transit.model.service.TransitService;

@WebServlet("/admin/transit")
public class TransitAdmin extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String currentPage = request.getParameter("currentPage");
		
		int pageNo = 1;
		
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}
		
		if(pageNo <= 0) {
			pageNo = 1;
		}
		
		TransitService tSv = new TransitService();
		int totalCount = tSv.selectTotalCount();
		
		int limit = 10;
		int buttonAmount = 5;
		
		TransitPageInfoDTO pageInfo = Pagenation.getPageInfoTransit(pageNo, totalCount, limit, buttonAmount);
		
		List<TransitDTO> transitList = tSv.selectTransitList(pageInfo);
		
		for(TransitDTO transit : transitList) {
			System.out.println(transit); 
		}
		
		
		String path = "";
		if(transitList != null) {
			path = "/WEB-INF/views/transit/transitList.jsp";
			request.setAttribute("transitList", transitList);
			request.setAttribute("pageInfo", pageInfo);
		} else {
			path = "WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "배송상품 조회 실패!!!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
		
		
	}
}

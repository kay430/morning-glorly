package com.mg.jsp.mypage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mg.jsp.mypage.model.dto.MgOrderAddressDTO;
import com.mg.jsp.mypage.model.service.MgOrderAddressService;


@WebServlet("/mypage/main")
public class MypageMain extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<MgOrderAddressDTO> orderSelectList = new MgOrderAddressService().selectAllOrderList();
		
		for(MgOrderAddressDTO orderState : orderSelectList) {
			System.out.println("orderState : " + orderState);
		}
		String path = "";
		if(orderSelectList !=null) {
			path = "/WEB-INF/views/mypage/myPage.jsp";
			request.setAttribute("orderSelectList", orderSelectList);
			
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

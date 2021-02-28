package com.mg.jsp.payment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mg.jsp.admin.model.product.model.dto.MgGoodsDTO;
import com.mg.jsp.admin.model.product.model.service.MgGoodsService;
import com.mg.jsp.member.model.dto.MgDTO;
import com.mg.jsp.payment.model.service.PaymentService;

@WebServlet("/testJihun/test")
public class JihunTestServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int no = Integer.parseInt(request.getParameter("no"));
		MgGoodsDTO detailInfo = new MgGoodsService().selectOnedetailInfo(no);
		String MemId = ((MgDTO) request.getSession().getAttribute("loginMember")).getId();
		System.out.println("detailInfo " + detailInfo);
		MgDTO loginInfo = new PaymentService().selectMemberInfo(MemId);
		
		System.out.println("회원정보 " + loginInfo);

		String path = ""; 
		if(detailInfo !=null) { 
			path ="/WEB-INF/views/payment/testJihun.jsp";
			request.setAttribute("detailInfo", detailInfo);
			request.setAttribute("loginInfo", loginInfo);

		} else { path= "/WEB-INF/views/main/failed.jsp";
		request.setAttribute("message", "상세조회실패"); 
		}

		request.getRequestDispatcher(path).forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}

package com.mg.jsp.basket;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mg.jsp.admin.model.product.model.dto.MgGoodsDTO;
import com.mg.jsp.admin.model.product.model.service.MgGoodsService;
import com.mg.jsp.basket.model.dto.basketDTO;
import com.mg.jsp.basket.model.service.BasketService;
import com.mg.jsp.member.model.dto.MgDTO;

@WebServlet("/main/basket")
public class basket extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  int no = Integer.parseInt(request.getParameter("no"));
		 
		  System.out.println("no : " + no);
		 
		  int memberNo = ((MgDTO) request.getSession().getAttribute("loginMember")).getNo();
		  
		   
		 System.out.println("들어가기전"); 
		  basketDTO detailInfo1 = new BasketService().selectBasketInfo(no, memberNo);
		  MgGoodsDTO detailInfo = new MgGoodsService().selectOnedetailInfo(no);
		 
		  System.out.println("detailInfo1 " + detailInfo1);
		  System.out.println("detailInfo " + detailInfo);
		  
		  
		  String path = "";	
			if(detailInfo1 !=null) {
				path = "/WEB-INF/views/basket/basket.jsp";
				request.setAttribute("detailInfo1", detailInfo1);
				request.setAttribute("detailInfo", detailInfo);
			} else {
				path= "/WEB-INF/views/main/failed.jsp";
				request.setAttribute("message", "상세조회실패");
			}
			request.getRequestDispatcher(path).forward(request, response);
		 
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}



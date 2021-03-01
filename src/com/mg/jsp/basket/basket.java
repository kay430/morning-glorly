package com.mg.jsp.basket;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mg.jsp.basket.model.dto.basketDTO;
import com.mg.jsp.basket.model.service.BasketService;

@WebServlet("/main/basket")
public class basket extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  int no = Integer.parseInt(request.getParameter("no"));
		  
		  System.out.println("no : " + no);
		  
		 System.out.println("들어가기전"); 
		  basketDTO detailInfo1 = new BasketService().selectBasketInfo(no);
		 
		  System.out.println("detailInfo1 " + detailInfo1);
		
		  String path = "/WEB-INF/views/basket/basket.jsp";
		  request.getRequestDispatcher(path).forward(request, response);
		 
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}



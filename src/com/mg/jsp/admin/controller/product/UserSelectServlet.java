package com.mg.jsp.admin.controller.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mg.jsp.admin.model.product.model.dto.MgGoodsDTO;
import com.mg.jsp.admin.model.product.model.service.MgGoodsService;

/**
 * Servlet implementation class UserSelectServlet
 */
@WebServlet("/user/select")
public class UserSelectServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		System.out.println("no : " + no);
		MgGoodsDTO detailInfo = new MgGoodsService().selectOnedetailInfo(no);

		System.out.println("detailInfo " + detailInfo);




		String path = ""; 
		if(detailInfo !=null) { 
			path ="/WEB-INF/views/breakfastbox/menuDetail.jsp";
			request.setAttribute("detailInfo", detailInfo);

		} else { path= "/WEB-INF/views/main/failed.jsp";
		request.setAttribute("message", "상세조회실패"); 
		}

		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

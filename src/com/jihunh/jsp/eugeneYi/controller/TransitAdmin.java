package com.jihunh.jsp.eugeneYi.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jihunh.jsp.common.paging.Pagenation;

@WebServlet("/admin/transit")
public class TransitAdmin extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String path = "/WEB-INF/views/eugeneYi/transitList.jsp";
		request.getRequestDispatcher(path).forward(request, response);
		
		
		
	}

}

package com.mg.jsp.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.mg.jsp.admin.model.service.MgAdService;
import com.mg.jsp.member.model.service.MgService;

@WebServlet("/member/regist/checkId")
public class OverlapId extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("idOverlap");
		
		System.out.println("가져온 id : " + id);
		System.out.println(id);
		System.out.println(id.equals(""));
		int result = new MgService().memIdOverlap(id);
		
		String path = "";
		if(result > 0) {
			System.out.println("사용할수 없는 아이디임");
			path = "cannot";
		} else if(id.equals("")) {
			System.out.println("입력해주세요");
			path = "not";
		} else {
			System.out.println("사용 가능 아이디");
			path = "can";
		}
		
		
		String jsonPath = new Gson().toJson(path);
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		response.getWriter();
		
		out.append(jsonPath);
	
		out.flush(); 
		out.close();
		
	}

}

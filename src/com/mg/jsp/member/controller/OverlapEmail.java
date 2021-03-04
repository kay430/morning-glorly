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

@WebServlet("/member/regist/checkEmail")
public class OverlapEmail extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String emailOverlap = request.getParameter("emailOverlap");
		
		System.out.println("가져온 id : " + emailOverlap);
		System.out.println(emailOverlap);
		System.out.println(emailOverlap.equals(""));
		
		if(emailOverlap.equals("@")) {
			emailOverlap = "빈값";
		}
		
		int result = new MgService().memEmailOverlap(emailOverlap);
		
		String path = "";
		if(result > 0) {
			System.out.println("사용할수 없는 아이디임");
			path = "cannot";
		} else if(emailOverlap.equals("빈값")) {
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

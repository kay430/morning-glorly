package com.mg.jsp.question.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.mg.jsp.question.model.dto.QuestionDTO;
import com.mg.jsp.question.model.service.QuestionService;


@WebServlet("/question/update")
public class QuestionUpdateInsert extends HttpServlet {
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String headCore = request.getParameter("headCore");
		String body = request.getParameter("body");
		int pageNumNo = Integer.parseInt(request.getParameter("pageNumNo"));
		int adminNo = Integer.parseInt(request.getParameter("adminNo"));
		
		System.out.println(headCore);
		System.out.println(body);
		System.out.println(pageNumNo);
		System.out.println(adminNo);
		
		QuestionDTO newQuestion = new QuestionDTO();
		newQuestion.setTitle(headCore);
		newQuestion.setBody(body);
		newQuestion.setNo(pageNumNo);
		newQuestion.setWriterMemberNo(adminNo);
		
		QuestionDTO result = new QuestionService().updateQuestion(newQuestion);
		System.out.println("변경 된 내용 출력 : " + result);
		
		String jsonString = new Gson().toJson(result);

		System.out.println(jsonString);

		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		response.getWriter();
		
		out.append(jsonString);
	
		out.flush(); 
		out.close();
	}

}

package com.jihunh.jsp.question.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jihunh.jsp.question.model.dto.QuestionDTO;


@WebServlet("/question/delete")
public class QuestionDeleteServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int questionNo = ((QuestionDTO) request.getSession().getAttribute("questionList")).getNo();
		String questionTitle = request.getParameter("title");
		String questionBody = request.getParameter("body");
		
		QuestionDTO requestQuestion = new QuestionDTO();
		requestQuestion.setNo(questionNo);
		requestQuestion.setTitle(questionTitle);
		requestQuestion.setBody(questionBody);
		
		System.out.println("requestQuestion : " + requestQuestion);
		                                            
	}

}

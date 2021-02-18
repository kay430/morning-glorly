package com.jihunh.jsp.question.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jihunh.jsp.question.model.dto.QuestionDTO;
import com.jihunh.jsp.question.model.service.QuestionService;


@WebServlet("/question/list")
public class QuestionListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/WEB-INF/views/customerservice/qna.jsp";
		List<QuestionDTO> questionList = new QuestionService().selectAllNoticeList();
		
		System.out.println(questionList);
		
	}

	
}

package com.jihunh.jsp.question.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jihunh.jsp.question.model.dto.QuestionDTO;
import com.jihunh.jsp.question.model.service.QuestionService;


@WebServlet("/question/delete")
public class QuestionDeleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/views/customerservice/qnaViewDetail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		int questionNo = ((QuestionDTO) request.getSession().getAttribute("questionList")).getNo();
		String questionTitle = request.getParameter("title");
		String questionBody = request.getParameter("body");
		
		QuestionDTO requestQuestion = new QuestionDTO();
		requestQuestion.setNo(questionNo);
		requestQuestion.setTitle(questionTitle);
		requestQuestion.setBody(questionBody);
		
		System.out.println("requestQuestion : " + requestQuestion);
		
		int result = new QuestionService().deleteQuestion(requestQuestion);
		
		String path = "";
		if(result > 0) {
			path = "/WEB-INF/views/main/success.jsp";
			request.setAttribute("successCode", "deleteQuestion");
			request.getSession().invalidate();
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "회원 탈퇴에 실패하셨습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}
}

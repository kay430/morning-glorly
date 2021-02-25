package com.jihunh.jsp.question.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jihunh.jsp.member.model.dto.MgDTO;
import com.jihunh.jsp.question.model.dto.QuestionDTO;
import com.jihunh.jsp.question.model.service.QuestionService;

@WebServlet("/question/insert")
public class QuestionInsertServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/customerservice/qnainsert.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String body = request.getParameter("body");
		String writer = request.getParameter("writer");
		int writerMemberNo = ((MgDTO) request.getSession().getAttribute("loginMember")).getNo();
		int qnaCode  = Integer.parseInt(request.getParameter("qnaCode"));
		
		System.out.println("1" + title);
		System.out.println("2" + body);
		System.out.println("3" + writer);
		System.out.println("4" + writerMemberNo);
		System.out.println("qnacode " + qnaCode );
		
		QuestionDTO newQuestion = new QuestionDTO();
		newQuestion.setTitle(title);
		newQuestion.setBody(body);
		newQuestion.setWriterMemberNo(writerMemberNo);
		newQuestion.setCategoryCode(qnaCode);

		int result = new QuestionService().insertQuestion(newQuestion);
		
		String path = "";
		if(result > 0) {
			path = "/WEB-INF/views/main/success.jsp";
			request.setAttribute("successCode", "insertQuestion");
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "질문게시판 등록에 실패하셨습니다.");
			
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}

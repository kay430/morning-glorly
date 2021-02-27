package com.jihunh.jsp.question.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jihunh.jsp.question.model.dto.QuestionDTO;
import com.jihunh.jsp.question.model.service.QuestionService;


@WebServlet("/question/detail")
public class QuestionDetailView extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		int pageNumNo = no;
		
		QuestionDTO questionDetail = new QuestionService().selectQuestionDetail(no);
		
		System.out.println("글과이미지 : " + questionDetail);
		
		String path = "";
		if(questionDetail != null) {
			path  = "/WEB-INF/views/customerservice/qnaViewDetail.jsp";
			request.setAttribute("question", questionDetail);
			request.setAttribute("pageNumNo", pageNumNo);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "공지사항 상세 보기 조회에 실패하셨습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	
}

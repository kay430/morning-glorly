package com.jihunh.jsp.question.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthSpinnerUI;

import com.jihunh.jsp.common.paging.Pagenation;
import com.jihunh.jsp.question.model.dto.QuestionDTO;
import com.jihunh.jsp.question.model.dto.QuestionPageInfoDTO;
import com.jihunh.jsp.question.model.service.QuestionService;


@WebServlet("/question/search")
public class QuestiolnSearchServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String searchCondition = request.getParameter("searchCondition");
		String searchValue = request.getParameter("searchValue");
		
		System.out.println("c :" + searchCondition);
		System.out.println("v :" + searchValue);
		
		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;
		
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}
		
		if(pageNo <= 0) {
			pageNo = 1;
		}
		
		QuestionService questionService = new QuestionService();
		int totalCount = questionService.searchQuestionCount(searchCondition,searchValue);
		
		System.out.println("t :" + totalCount );
		
		int limit = 10;
		int buttonAmount = 5;
		
		QuestionPageInfoDTO questionPageInfo = Pagenation.getPageInfoQuestion(pageNo, totalCount, limit, buttonAmount);
				
		List<QuestionDTO> questionList = questionService.searchQuestionList(searchCondition, searchValue, questionPageInfo);
		
		
		String path = "";
		if(questionList != null) {
			path = "/WEB-INF/views/customerservice/qna.jsp";
			request.setAttribute("questionList", questionList);
			request.setAttribute("questionPageInfo", questionPageInfo);
			request.setAttribute("searchCondition", searchCondition);
			request.setAttribute("searchValue", searchValue);
		} else {
			path = "/WEB-INF/views/main/failed.jsp";
			request.setAttribute("message", "질문게시판 게시물 검색 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	
	
}

package com.jihunh.jsp.question.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jihunh.jsp.common.paging.Pagenation;
import com.jihunh.jsp.question.model.dto.QuestionDTO;
import com.jihunh.jsp.question.model.dto.QuestionPageInfoDTO;
import com.jihunh.jsp.question.model.service.QuestionService;


@WebServlet("/question/list")
public class QuestionListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String currentPage = request.getParameter("currentPage");
		
		int pageNo = 1;
		
		if(currentPage != null && !"".equals(currentPage)) {
			
			pageNo = Integer.parseInt(currentPage);
		}
		
		if(pageNo <= 0) {
			pageNo = 1;
		}
		
		System.out.println("currentPage : " + currentPage);
		System.out.println("pageNo : " + pageNo);
		
		QuestionService questionService = new QuestionService();
		int totalCount = questionService.selectTotalCount();
		
		System.out.println("전체 게시물 수 : " + totalCount);
		
		int limit = 10;
		int buttonAmount = 5;
		
		QuestionPageInfoDTO questionPageInfo = Pagenation.getPageInfoQuestion(pageNo, totalCount, limit, buttonAmount);
		
		System.out.println("pageInfo : " + questionPageInfo );
		
		List<QuestionDTO> questionList = questionService.selectAllQuestionList(questionPageInfo);
		
		for(QuestionDTO questionBoard : questionList) {
			System.out.println(questionBoard);
		}
		
		String path = "";
		if(questionList != null) {
			path = "/WEB-INF/views/customerservice/qna.jsp";
			request.setAttribute("questionList", questionList);
			request.setAttribute("questionPageInfo", questionPageInfo);
		} else {
			path = "WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "질문글 조회 실패!");
		}
		
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	
}

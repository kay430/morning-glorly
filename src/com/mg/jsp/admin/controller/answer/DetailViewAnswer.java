package com.mg.jsp.admin.controller.answer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mg.jsp.admin.model.dto.AnswerDTO;
import com.mg.jsp.admin.model.service.AnswerService;
import com.mg.jsp.question.model.dto.QuestionDTO;
import com.mg.jsp.question.model.service.QuestionService;

@WebServlet("/admin/answer/detail")
public class DetailViewAnswer extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		int pageNumNo = no;
		
		QuestionDTO questionDetail = new QuestionService().selectQuestionDetail(no);
		
		AnswerDTO answerDTO = new AnswerService().selectAnswerDetail(no);
		
		System.out.println(answerDTO);
		
		String path = "";
		if(answerDTO != null) {
			path = "/WEB-INF/views/admin/AnswerDetail.jsp";
			request.setAttribute("question", questionDetail);
			request.setAttribute("answer", answerDTO);
			request.setAttribute("pageNumNo", pageNumNo);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "공지사항 상세 보기 조회에 실패하셨습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}


}

package com.jihunh.jsp.admin.controller.answer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jihunh.jsp.admin.model.dto.AnswerDTO;
import com.jihunh.jsp.admin.model.dto.MgAdDTO;
import com.jihunh.jsp.admin.model.service.AnswerService;

@WebServlet("/admin/answer/insert")
public class InsertAnswerAdmin extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/admin/AnswerInsert.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String body = request.getParameter("body");
		String status = request.getParameter("status");
		int category = Integer.parseInt(request.getParameter("category"));
		/* String writer = request.getParameter("writer"); */
		int writerMemberNo = ((MgAdDTO) request.getSession().getAttribute("loginMember")).getNo();
		
//		System.out.println("title : " + title);
//		System.out.println("body : " + body);
//		System.out.println("type : " + status);
		/* System.out.println("writer : " + writer); */
//		System.out.println("writerMemberNo : " + writerMemberNo);
		
		AnswerDTO answerDTO = new AnswerDTO();
		answerDTO.setTitle(title);
		answerDTO.setBody(body);
		answerDTO.setWriterMgNo(writerMemberNo);
		answerDTO.setStatus(status);
		answerDTO.setCategoryCode(category);
		
		int result = new AnswerService().insertAnswer(answerDTO);
//		System.out.println("내용좀 보자 : " + answerDTO);
		String path = "";
		if(result > 0) {
			path = "/WEB-INF/views/common/admin/successAd.jsp";
			request.setAttribute("successCode", "insertAnswer");
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "공지사항 등록에 실패하셨습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
		
	}

}

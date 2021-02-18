package com.jihunh.jsp.admin.controller.answer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jihunh.jsp.admin.model.dto.AnswerDTO;
import com.jihunh.jsp.admin.model.dto.NoticePageInfoDTO;
import com.jihunh.jsp.admin.model.service.AnswerService;
import com.jihunh.jsp.common.paging.Pagenation;

@WebServlet("/admin/answer")
public class AnswerAdmin extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String currentPage = request.getParameter("currentPage");

		int pageNo = 1;

		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}
		
		if(pageNo <= 0) {
			pageNo = 1;
		}
		
//		System.out.println("current페이지 : " + currentPage);
//		System.out.println("pageNo는? : " + pageNo);
//		System.out.println("여기는 Answer");
		
		AnswerService anSv = new AnswerService();
		int totalCount = anSv.selectTotalCount();
		
//		System.out.println("전체 게시물 수 : " + totalCount); 
		
		int limit = 10;
		int buttonAmount = 5;
		
		NoticePageInfoDTO pageInfo = Pagenation.getPageInfo(pageNo, totalCount, limit, buttonAmount);
		
//		System.out.println("pageInfo : " + pageInfo);
		
		List<AnswerDTO> answerList = anSv.selectAnswerList(pageInfo);
		
		for(AnswerDTO answer : answerList) {
			System.out.println(answer);
		}
		

		String path = "";
		if(answerList != null) {
			path = "/WEB-INF/views/admin/AnswerAdmin.jsp";
			request.setAttribute("answerList", answerList);
			request.setAttribute("pageInfo", pageInfo);
		} else {
			path = "WEB-INF/views/common/failedAd.jsp";
			request.setAttribute("message", "게시물 목록 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}

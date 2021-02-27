package com.mg.jsp.admin.controller.noticelist;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jihunh.jsp.admin.model.dto.NoticeDTO;
import com.jihunh.jsp.admin.model.dto.NoticePageInfoDTO;
import com.jihunh.jsp.admin.model.service.NoticeService;
import com.jihunh.jsp.common.paging.Pagenation;

@WebServlet("/admin/notice")
public class NoticeAdmin extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String currentPage = request.getParameter("currentPage");
		
		int pageNo = 1;
		
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}
		
		if(pageNo <= 0) {
			pageNo = 1;
		}
		
		NoticeService ntSv = new NoticeService();
		int totalCount = ntSv.selectTotalCount();
		
		int limit = 10;
		int buttonAmount = 5;
		
		NoticePageInfoDTO pageInfo = Pagenation.getPageInfoNotice(pageNo, totalCount, limit, buttonAmount);
		
		List<NoticeDTO> noticeList = ntSv.selectNoticeList(pageInfo);
		
//		for(NoticeDTO notice : noticeList) {
//			System.out.println(notice);
//		}
		
		
		String path = "";
		if(noticeList != null) {
			path = "/WEB-INF/views/admin/noticeList.jsp";
			request.setAttribute("noticeList", noticeList);
			request.setAttribute("pageInfo", pageInfo);
		} else {
			path = "WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "QnA 목록 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
		
		
	}

}

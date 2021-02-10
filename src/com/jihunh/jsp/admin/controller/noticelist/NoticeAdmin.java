package com.jihunh.jsp.admin.controller.noticelist;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jihunh.jsp.admin.model.dto.NoticeDTO;
import com.jihunh.jsp.admin.model.service.NoticeService;

@WebServlet("/admin/notice")
public class NoticeAdmin extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		List<NoticeDTO> noticeList = new NoticeService().selectAllNoticeList();
		
		String path = "";
		if(noticeList != null) {
			path = "/WEB-INF/views/admin/noticeList.jsp";
			request.setAttribute("noticeList", noticeList);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "공지사항 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}

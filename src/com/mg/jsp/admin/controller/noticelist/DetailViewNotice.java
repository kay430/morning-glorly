package com.mg.jsp.admin.controller.noticelist;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jihunh.jsp.admin.model.dto.NoticeDTO;
import com.jihunh.jsp.admin.model.service.NoticeService;

@WebServlet("/admin/notice/detail")
public class DetailViewNotice extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		int pageNumNo = no;
		
		NoticeDTO noticeDetail = new NoticeService().selectNoticeDetail(no);
		
		System.out.println("주서온 글과 이미지 : " + noticeDetail);
		
		String path = "";
		if(noticeDetail != null) {
			path = "/WEB-INF/views/admin/DetailNotice.jsp";
			request.setAttribute("notice", noticeDetail);
			request.setAttribute("pageNumNo", pageNumNo);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "공지사항 상세 보기 조회에 실패하셨습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}


}

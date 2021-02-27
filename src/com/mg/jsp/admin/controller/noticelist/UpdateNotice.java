package com.mg.jsp.admin.controller.noticelist;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.mg.jsp.admin.model.dto.NoticeDTO;
import com.mg.jsp.admin.model.service.NoticeService;

@WebServlet("/admin/notice/update")
public class UpdateNotice extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String headCore = request.getParameter("headCore");
		String body = request.getParameter("body");
		int pageNumNo = Integer.parseInt(request.getParameter("pageNumNo"));
		int adminNo = Integer.parseInt(request.getParameter("adminNo"));
		
		System.out.println(headCore);
		System.out.println(body);
		System.out.println(pageNumNo);
		System.out.println(adminNo);
		
		NoticeDTO newNotice = new NoticeDTO();
		newNotice.setTitle(headCore);
		newNotice.setBody(body);
		newNotice.setNo(pageNumNo);
		newNotice.setWriterMemberNo(adminNo);
		
		NoticeDTO result = new NoticeService().updateNotice(newNotice);
		System.out.println("변경 된 내용 출력 : " + result);
		
		String jsonString = new Gson().toJson(result);

		System.out.println(jsonString);

		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		response.getWriter();
		
		out.append(jsonString);
	
		out.flush(); 
		out.close();
		
//		String path = "";
//		if(result != null) {
//			path = "/WEB-INF/views/common/success.jsp";
//			request.setAttribute("successCode", "updateNotice");
//			request.setAttribute("newNotice", newNotice);
//			System.out.println("신상 글 : " + newNotice);
//		} else {
//			path = "/WEB-INF/views/common/failed.jsp";
//			request.setAttribute("message", "공지사항 등록 실패");
//		}
//
//		request.getRequestDispatcher(path).forward(request, response);
	}

}























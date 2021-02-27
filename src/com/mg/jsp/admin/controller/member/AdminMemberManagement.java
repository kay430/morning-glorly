package com.jihunh.jsp.admin.controller.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jihunh.jsp.admin.model.dto.MgAdDTO;
import com.jihunh.jsp.admin.model.dto.NoticePageInfoDTO;
import com.jihunh.jsp.admin.model.dto.SearchReadyDTO;
import com.jihunh.jsp.admin.model.service.MemberService;
import com.jihunh.jsp.common.paging.Pagenation;
import com.jihunh.jsp.member.model.dto.MgDTO;

@WebServlet("/admin/member/manageAd")
public class AdminMemberManagement extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String currentPage = request.getParameter("currentPage");
		
		int pageNo = 1;
		
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}
		
		if(pageNo <= 0) {
			pageNo = 1;
		}
		
		SearchReadyDTO memberAdList = new SearchReadyDTO();
		memberAdList.setPageInfo(new NoticePageInfoDTO());
		memberAdList.getPageInfo().setPageNo(pageNo);
		memberAdList.getPageInfo().setTotalCount((new MemberService().totalMemberAdList()));
		memberAdList.getPageInfo().setLimit(10);
		memberAdList.getPageInfo().setButtonAmount(5);
		System.out.println("페이지 정보  : " + memberAdList);
		
		List<MgAdDTO> mgAdList = new MemberService().mainMemberAdList(Pagenation.getSearchPage(memberAdList));
		
		for(MgAdDTO notice : mgAdList) {
			System.out.println(notice);
		}
		
		String path = "";
		if(mgAdList != null) {
			path = "/WEB-INF/views/adminmembermanagement/memberAdManagement.jsp";
			request.setAttribute("mgAdList", mgAdList);
			request.setAttribute("pageInfo", memberAdList.getPageInfo());
		} else {
			path = "WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "QnA 목록 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}

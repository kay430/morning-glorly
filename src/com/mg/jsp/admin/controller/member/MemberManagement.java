package com.mg.jsp.admin.controller.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jihunh.jsp.admin.model.dto.NoticePageInfoDTO;
import com.jihunh.jsp.admin.model.dto.SearchReadyDTO;
import com.jihunh.jsp.admin.model.service.MemberService;
import com.jihunh.jsp.common.paging.Pagenation;
import com.jihunh.jsp.member.model.dto.MgDTO;

@WebServlet("/admin/member/manage")
public class MemberManagement extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String currentPage = request.getParameter("currentPage");
		
		int pageNo = 1;
		
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}
		
		if(pageNo <= 0) {
			pageNo = 1;
		}
		
		SearchReadyDTO memberList = new SearchReadyDTO();
		memberList.setPageInfo(new NoticePageInfoDTO());
		memberList.getPageInfo().setPageNo(pageNo);
		memberList.getPageInfo().setTotalCount((new MemberService().totalMemberList()));
		memberList.getPageInfo().setLimit(10);
		memberList.getPageInfo().setButtonAmount(5);
		
		System.out.println(memberList);
		
		List<MgDTO> mgList = new MemberService().mainMemberList(Pagenation.getSearchPage(memberList));
		
		for(MgDTO notice : mgList) {
			System.out.println(notice);
		}
		
		String path = "";
		if(mgList != null) {
			path = "/WEB-INF/views/adminmembermanagement/memberManagement.jsp";
			request.setAttribute("mgList", mgList);
			request.setAttribute("pageInfo", memberList.getPageInfo());
		} else {
			path = "WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "QnA 목록 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}

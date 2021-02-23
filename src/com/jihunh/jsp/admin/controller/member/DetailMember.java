package com.jihunh.jsp.admin.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jihunh.jsp.admin.model.dto.NoticePageInfoDTO;
import com.jihunh.jsp.admin.model.dto.SearchReadyDTO;
import com.jihunh.jsp.admin.model.service.MemberService;
import com.jihunh.jsp.admin.model.service.NoticeService;
import com.jihunh.jsp.common.paging.Pagenation;
import com.jihunh.jsp.member.model.dto.MgDTO;

@WebServlet("/admin/member/manage/detail")
public class DetailMember extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		int pageNumNo = no;
		
		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;
		
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}
		
		if(pageNo <= 0) {
			pageNo = 1;
		}
		SearchReadyDTO mgBlackCount = new SearchReadyDTO();
		mgBlackCount.setPageInfo(new NoticePageInfoDTO());
		mgBlackCount.getPageInfo().setPageNo(pageNo);
		mgBlackCount.getPageInfo().setTotalCount((new MemberService().viewMgBlackCount(no)));
		mgBlackCount.getPageInfo().setLimit(5);
		mgBlackCount.getPageInfo().setButtonAmount(5);
		Pagenation.getSearchPage(mgBlackCount);
		
		MgDTO mgList = new MemberService().viewMemberDetailInfo(no, mgBlackCount);
		
		System.out.println("주서온 글과 이미지 : " + mgList);
		
		String path = "";
		if(mgList != null) {
			path = "/WEB-INF/views/adminmembermanagement/detailMemberInfo.jsp";
			request.setAttribute("mgList", mgList);
			request.setAttribute("pageNumNo", pageNumNo);
			request.setAttribute("pageInfo", mgBlackCount.getPageInfo());
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "공지사항 상세 보기 조회에 실패하셨습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}

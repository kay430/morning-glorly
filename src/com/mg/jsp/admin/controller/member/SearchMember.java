package com.mg.jsp.admin.controller.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mg.jsp.admin.model.dto.NoticePageInfoDTO;
import com.mg.jsp.admin.model.dto.SearchReadyDTO;
import com.mg.jsp.admin.model.service.MemberService;
import com.mg.jsp.common.paging.Pagenation;
import com.mg.jsp.member.model.dto.MgDTO;

@WebServlet("/admin/member/manage/search")
public class SearchMember extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String currentPage = request.getParameter("currentPage");

		int pageNo = 0;

		if(currentPage !=null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}

		if(pageNo <= 0) {
			pageNo = 1;
		}

		SearchReadyDTO searchRd = new SearchReadyDTO();
		searchRd.setPageInfo(new NoticePageInfoDTO());
		searchRd.setSearchCondition(request.getParameter("searchCondition"));
		searchRd.setSearchValue(request.getParameter("searchValue"));
		searchRd.getPageInfo().setPageNo(pageNo);
		searchRd.getPageInfo().setTotalCount((new MemberService().searchMemberCount(searchRd)));
		searchRd.getPageInfo().setLimit(10);
		searchRd.getPageInfo().setButtonAmount(5);

		List<MgDTO> mgList = new MemberService().searchMemberList(Pagenation.getSearchPage(searchRd));

		//		for(NoticeDTO notice : noticeList) {
		//			System.out.println("검색 조회 결과 : " + notice);
		//		}

		String path = "";

		if(mgList != null) {
			path = "/WEB-INF/views/adminmembermanagement/memberManagement.jsp";
			request.setAttribute("mgList", mgList);
			request.setAttribute("pageInfo", searchRd.getPageInfo());
			request.setAttribute("searchCondition", searchRd.getSearchCondition());
			request.setAttribute("searchValue", searchRd.getSearchValue());
		} else {
			path = "/WEB-INF/views/common/admin/test.jsp";
			request.setAttribute("messeage", "실패");
		}

		request.getRequestDispatcher(path).forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}

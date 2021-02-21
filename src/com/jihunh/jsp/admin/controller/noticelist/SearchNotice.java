package com.jihunh.jsp.admin.controller.noticelist;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jihunh.jsp.admin.model.dto.NoticeDTO;
import com.jihunh.jsp.admin.model.dto.NoticePageInfoDTO;
import com.jihunh.jsp.admin.model.dto.SearchReadyDTO;
import com.jihunh.jsp.admin.model.service.NoticeService;
import com.jihunh.jsp.common.paging.Pagenation;

@WebServlet("/admin/notice/search")
public class SearchNotice extends HttpServlet {
	
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
		searchRd.getPageInfo().setTotalCount((new NoticeService().searchNoticeCount(searchRd)));
		searchRd.getPageInfo().setLimit(10);
		searchRd.getPageInfo().setButtonAmount(5);
		Pagenation.getSearchPage(searchRd);

		List<NoticeDTO> noticeList = new NoticeService().searchNoticeList(searchRd);
		
//		for(NoticeDTO notice : noticeList) {
//			System.out.println("검색 조회 결과 : " + notice);
//		}
		
		String path = "";
		
		if(noticeList != null) {
			path = "/WEB-INF/views/admin/noticeList.jsp";
			request.setAttribute("noticeList", noticeList);
			request.setAttribute("pageInfo", searchRd.getPageInfo());
			request.setAttribute("searchCondition", searchRd.getSearchCondition());
			request.setAttribute("searchValue", searchRd.getSearchValue());
		} else {
			path = "/WEB-INF/views/common/admin/test.jsp";
			request.setAttribute("messeage", "실패");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
		
	}


}













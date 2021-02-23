package com.jihunh.jsp.eugeneYi.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jihunh.jsp.common.paging.Pagenation;
import com.jihunh.jsp.eugeneYi.model.DTO.SearchDTO;
import com.jihunh.jsp.eugeneYi.model.DTO.TransitDTO;
import com.jihunh.jsp.eugeneYi.model.DTO.TransitPageInfoDTO;
import com.jihunh.jsp.eugeneYi.model.service.TransitService;

@WebServlet("/admin/transit/search")
public class SearchTransit extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String currentPage = request.getParameter("currentPage");
		
		int pageNo = 0;
		
		if(currentPage !=null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}
		
		if(pageNo <= 0) {
			pageNo = 1;
		}
		
		SearchDTO searchTransit = new SearchDTO();
		searchTransit.setPageInfo(new TransitPageInfoDTO());
		searchTransit.setSearchCondition(request.getParameter("searchCondition"));
		searchTransit.setSearchValue(request.getParameter("searchValue"));
		searchTransit.getPageInfo().setPageNo(pageNo);
		searchTransit.getPageInfo().setTotalCount((new TransitService().searchTransitCount(searchTransit)));
		searchTransit.getPageInfo().setLimit(10);
		searchTransit.getPageInfo().setButtonAmount(5);

		List<TransitDTO> transitList = new TransitService().searchTransitList(Pagenation.getTransitPage(searchTransit));
		
		String path = "";
		
		if(transitList != null) {
			path = "/WEB-INF/views/eugeneYi/transitList.jsp";
			request.setAttribute("transitList", transitList);
			request.setAttribute("pageInfo", searchTransit.getPageInfo());
			request.setAttribute("searchCondition", searchTransit.getSearchCondition());
			request.setAttribute("searchValue", searchTransit.getSearchValue());
		} else {
			path = "/WEB-INF/views/common/error404.jsp";
			request.setAttribute("messeage", "실패");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
		
	}


}
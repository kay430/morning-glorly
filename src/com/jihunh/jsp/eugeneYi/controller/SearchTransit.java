package com.jihunh.jsp.eugeneYi.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jihunh.jsp.common.paging.Pagenation;
import com.jihunh.jsp.eugeneYi.model.DTO.SearchReadyDTO;
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
		
		SearchReadyDTO searchRd = new SearchReadyDTO();
		searchRd.setPageInfo(new TransitPageInfoDTO());
		searchRd.setSearchCondition(request.getParameter("searchCondition"));
		searchRd.setSearchValue(request.getParameter("searchValue"));
		searchRd.getPageInfo().setPageNo(pageNo);
		searchRd.getPageInfo().setTotalCount((new TransitService().searchTransitCount(searchRd)));
		searchRd.getPageInfo().setLimit(10);
		searchRd.getPageInfo().setButtonAmount(5);

		List<TransitDTO> transitList = new TransitService().searchTransitList(Pagenation.getSearchPage(searchRd));
		
		String path = "";
		
		if(transitList != null) {
			path = "/WEB-INF/views/admin/transitList.jsp";
			request.setAttribute("transitList", transitList);
			request.setAttribute("pageInfo", searchRd.getPageInfo());
			request.setAttribute("searchCondition", searchRd.getSearchCondition());
			request.setAttribute("searchValue", searchRd.getSearchValue());
		} else {
			path = "/WEB-INF/views/common/error404.jsp";
			request.setAttribute("messeage", "실패");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
		
	}


}
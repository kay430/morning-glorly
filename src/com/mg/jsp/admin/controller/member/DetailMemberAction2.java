package com.mg.jsp.admin.controller.member;

import java.io.IOException;

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

@WebServlet("/admin/member/manage/detailAction2")
public class DetailMemberAction2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		int pageNumNo = no;
		
		String currentPage = request.getParameter("currentPage");
		String currentPageMd = request.getParameter("currentPageMd");
		String currentPageMp = request.getParameter("currentPageMp");
		int pageNo = 1;
		int pageNoMd = 1;
		int pageNoMp = 1;
		
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		} else if(currentPageMd != null && !"".equals(currentPageMd)) {
			pageNoMd = Integer.parseInt(currentPageMd);
		} else if(currentPageMp != null && !"".contentEquals(currentPageMp)) {
			pageNoMp = Integer.parseInt(currentPageMp);
		}
		
		if(pageNo <= 0) {
			pageNo = 1;
		} else if(pageNoMd <= 0) {
			pageNoMd = 1;
		} else if(pageNoMp <= 0) {
			pageNoMp = 1;
		}
		
		/* 1-1. 블랙리스트 페이지처리 */
		SearchReadyDTO mgBlackCount = new SearchReadyDTO();
		mgBlackCount.setPageInfo(new NoticePageInfoDTO());
		mgBlackCount.getPageInfo().setPageNo(pageNo);
		mgBlackCount.getPageInfo().setTotalCount((new MemberService().viewMgBlackCount(no)));
		mgBlackCount.getPageInfo().setLimit(5);
		mgBlackCount.getPageInfo().setButtonAmount(5);
		Pagenation.getSearchPage(mgBlackCount);
		
		
		/* 1-2. 정보변경이력 페이지처리 */
		SearchReadyDTO mgModifyCount = new SearchReadyDTO();
		mgModifyCount.setPageInfo(new NoticePageInfoDTO());
		mgModifyCount.getPageInfo().setPageNo(pageNoMd);
		mgModifyCount.getPageInfo().setTotalCount((new MemberService().viewMgModifyCount(no)));
		mgModifyCount.getPageInfo().setLimit(5);
		mgModifyCount.getPageInfo().setButtonAmount(5);
		Pagenation.getSearchPage(mgModifyCount);
		
		
		/* 1-3. 포인트변경이력 페이지처리 */
		SearchReadyDTO mgPointCount = new SearchReadyDTO();
		mgPointCount.setPageInfo(new NoticePageInfoDTO());
		mgPointCount.getPageInfo().setPageNo(pageNoMp);
		mgPointCount.getPageInfo().setTotalCount((new MemberService().viewMgPointCount(no)));
		mgPointCount.getPageInfo().setLimit(5);
		mgPointCount.getPageInfo().setButtonAmount(5);
		Pagenation.getSearchPage(mgPointCount);
		
		
		
		
		/* 테이블 조회 + 각 테이블 페이징 처리 결과 */
		MgDTO mgList = new MemberService().viewMemberDetailInfo(no, mgBlackCount, mgModifyCount, mgPointCount);
		
		System.out.println("주서온 글과 이미지 : " + mgList);
		
		String path = "";
		if(mgList != null) {
			path = "/WEB-INF/views/adminmembermanagement/detailMemberInfoAction2.jsp";
			request.setAttribute("mgList", mgList);
			request.setAttribute("pageNumNo", pageNumNo);
			request.setAttribute("pageInfo", mgBlackCount.getPageInfo());
			request.setAttribute("pageInfoMd", mgModifyCount.getPageInfo());
			request.setAttribute("pageInfoMp", mgPointCount.getPageInfo());
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "공지사항 상세 보기 조회에 실패하셨습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}

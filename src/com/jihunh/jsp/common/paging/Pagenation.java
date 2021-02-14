package com.jihunh.jsp.common.paging;

import com.jihunh.jsp.admin.model.dto.NoticePageInfoDTO;

public class Pagenation {

	public static NoticePageInfoDTO getPageInfo(int pageNo, int totalCount, int limit, int buttonAmount) {
	
	int maxPage;
	int startPage;
	int endPage;
	int startRow;
	int endRow;
	
	maxPage = (int) Math.ceil((double) totalCount / limit);
	
	startPage = (int) (Math.ceil((double) pageNo / buttonAmount) -1) * buttonAmount + 1;
	
	endPage = startPage + buttonAmount -1;
	
	if(maxPage < endPage) {
		endPage = maxPage;
	}
	
	if(maxPage == 0 && endPage == 0) {
		maxPage = startPage;
		endPage = startPage;
	}
	
	startRow = (pageNo - 1) * limit + 1;
	endRow = startRow + limit -1;
	
	return new NoticePageInfoDTO(pageNo, totalCount, limit, buttonAmount, maxPage, startPage, endPage, startRow, endRow);
	}
}

























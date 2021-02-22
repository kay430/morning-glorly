
package com.jihunh.jsp.common.paging;


import com.jihunh.jsp.admin.model.dto.NoticePageInfoDTO;
import com.jihunh.jsp.admin.model.dto.SearchReadyDTO;
import com.jihunh.jsp.customerservice.model.dto.PageInfoDTO;
import com.jihunh.jsp.eugeneYi.model.DTO.TransitPageInfoDTO;
import com.jihunh.jsp.question.model.dto.QuestionPageInfoDTO;
import com.jihunh.jsp.review.dto.ReviewPageInfoDTO;

public class Pagenation {

	/* 이걸 기본 베이스로 페이지네이션으로 사용 권장함 */
	public static PageInfoDTO getPageInfo(int pageNo, int totalCount, int limit, int buttonAmount) {
	
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
	
	return new PageInfoDTO(pageNo, totalCount, limit, buttonAmount, maxPage, startPage, endPage, startRow, endRow);
	}
	
	/* 지훈쓰 전용 페이징처리 메소드. 앞에 DTO 변경 금지 */
	public static NoticePageInfoDTO getPageInfoNotice(int pageNo, int totalCount, int limit, int buttonAmount) {
		
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
	
	/* 지훈쓰 전용 페이징처리 메소드2 */
	public static SearchReadyDTO getSearchPage(SearchReadyDTO searchRd) {
		
		int maxPage;
		int startPage;
		int endPage;
		int startRow;
		int endRow;
		
		maxPage = (int) Math.ceil((double) searchRd.getPageInfo().getTotalCount() / searchRd.getPageInfo().getLimit());
		
		startPage = (int) (Math.ceil((double) searchRd.getPageInfo().getPageNo() / searchRd.getPageInfo().getButtonAmount()) -1) * searchRd.getPageInfo().getButtonAmount() + 1;
		
		endPage = startPage + searchRd.getPageInfo().getButtonAmount() -1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		if(maxPage == 0 && endPage == 0) {
			maxPage = startPage;
			endPage = startPage;
		}
		
		startRow = (searchRd.getPageInfo().getPageNo() - 1) * searchRd.getPageInfo().getLimit() + 1;
		endRow = startRow + searchRd.getPageInfo().getLimit() -1;
		
		searchRd.getPageInfo().setMaxpage(maxPage);
		searchRd.getPageInfo().setStartPage(startPage);
		searchRd.getPageInfo().setEndPage(endPage);
		searchRd.getPageInfo().setStartRow(startRow);
		searchRd.getPageInfo().setEndRow(endRow);
		
		
		return searchRd;
	}
	
		/*지환쓰 전용 페이징처리 메소드 내꺼임 */
        public static QuestionPageInfoDTO getPageInfoQuestion(int pageNo, int totalCount, int limit, int buttonAmount) {
		
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
		
		return new QuestionPageInfoDTO(pageNo, totalCount, limit, buttonAmount, maxPage, startPage, endPage, startRow, endRow);
	}

        public static ReviewPageInfoDTO getPageInfoReview(int pageNo, int totalCount, int limit, int buttonAmount) {
    		
    		int maxPage;
    		int startPage;
    		int endPage;
    		int startRow;
    		int endRow;
    		
    		maxPage = (int) Math.ceil((double) totalCount / limit);
    		
    		startPage = (int) (Math.ceil((double) pageNo / buttonAmount) -1) * buttonAmount + 1;
    		System.out.println("startPage = " + startPage);    		
    		endPage = startPage + buttonAmount -1;
    		if(maxPage < endPage) {
    			endPage = maxPage;
    			System.out.println("endPage = " + endPage);
    		}
    		
    		if(maxPage == 0 && endPage == 0) {
    			maxPage = startPage;
    			endPage = startPage;
    		}
    		
    		startRow = (pageNo - 1) * limit + 1;
    		endRow = startRow + limit -1;
    		
    		
    		
    		
    		
    		return new ReviewPageInfoDTO(pageNo, totalCount, limit, buttonAmount, maxPage, startPage, endPage, startRow, endRow);
    	}

		public static TransitPageInfoDTO getPageInfoTransit(int pageNo, int totalCount, int limit, int buttonAmount) {

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
			
			return new TransitPageInfoDTO(pageNo, totalCount, limit, buttonAmount, maxPage, startPage, endPage, startRow, endRow);
			}

}























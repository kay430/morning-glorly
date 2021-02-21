package com.jihunh.jsp.common.paging;


import com.jihunh.jsp.admin.model.dto.NoticePageInfoDTO;
import com.jihunh.jsp.customerservice.model.dto.PageInfoDTO;
import com.jihunh.jsp.question.model.dto.QuestionPageInfoDTO;

public class Pagenation {

	/* 이걸 기본 베이스로 페이지네이션으로 사용 권장함 */
	public static PageInfoDTO getPageInfo(int pageNo, int totalCount, int limit, int buttonAmount) {
	
	int maxPage;
	int startPage;
	int endPage;
	int startRow;
	int endRow;
	
	maxPage = (int) Math.ceil((double) totalCount / limit);
	
	//maxPage 잘 맞게나오는지 한번 확인합시다~-
	System.out.println("maxPage : " + maxPage);
	
	
	startPage = (int) (Math.ceil((double) pageNo / buttonAmount) -1) * buttonAmount + 1;
	
	System.out.println("startPage : " + startPage);
	
	endPage = startPage + buttonAmount -1;
	
	System.out.println("endPage : " + endPage);
	
	//maxPage가 더 작은경우 마지막 페이지가 maxPage가 된다
	if(maxPage < endPage) {
		endPage = maxPage;
	}
	
	/*마지막 페이지는 0이 될수 없기때문에 게시물이 아무것도 존재하지않으면 maxpage와 endPage를 1로 바꿔준다*/
	if(maxPage == 0 && endPage == 0) {
		maxPage = startPage;
		endPage = startPage;
	}
	
	startRow = (pageNo - 1) * limit + 1;
	endRow = startRow + limit -1;
	System.out.println("startRow : " + startRow);
	System.out.println("endRow : " + endRow);
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
}

























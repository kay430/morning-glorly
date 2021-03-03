package com.mg.jsp.common.paging;


import com.mg.jsp.admin.model.dto.NoticePageInfoDTO;
import com.mg.jsp.admin.model.dto.SearchReadyDTO;
import com.mg.jsp.admin.model.dto.order.OSearchDTO;
import com.mg.jsp.admin.model.dto.order.OrderPageInfoDTO;
import com.mg.jsp.admin.model.dto.payment.PaymentPageInfoDTO;
import com.mg.jsp.admin.model.dto.payment.PSearchDTO;
import com.mg.jsp.customerservice.model.dto.PageInfoDTO;
import com.mg.jsp.question.model.dto.QuestionPageInfoDTO;
import com.mg.jsp.review.dto.ReviewPageInfoDTO;
import com.mg.jsp.transit.model.DTO.SearchDTO;
import com.mg.jsp.transit.model.DTO.TransitPageInfoDTO;

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

		public static SearchDTO getTransitPage(SearchDTO searchTransit) {
			
			int maxPage;
			int startPage;
			int endPage;
			int startRow;
			int endRow;
			
			maxPage = (int) Math.ceil((double) searchTransit.getPageInfo().getTotalCount() / searchTransit.getPageInfo().getLimit());
			
			startPage = (int) (Math.ceil((double) searchTransit.getPageInfo().getPageNo() / searchTransit.getPageInfo().getButtonAmount()) -1) * searchTransit.getPageInfo().getButtonAmount() + 1;
			
			endPage = startPage + searchTransit.getPageInfo().getButtonAmount() -1;
			
			if(maxPage < endPage) {
				endPage = maxPage;
			}
			
			if(maxPage == 0 && endPage == 0) {
				maxPage = startPage;
				endPage = startPage;
			}
			
			startRow = (searchTransit.getPageInfo().getPageNo() - 1) * searchTransit.getPageInfo().getLimit() + 1;
			endRow = startRow + searchTransit.getPageInfo().getLimit() -1;
			
			searchTransit.getPageInfo().setMaxPage(maxPage);
			searchTransit.getPageInfo().setStartPage(startPage);
			searchTransit.getPageInfo().setEndPage(endPage);
			searchTransit.getPageInfo().setStartRow(startRow);
			searchTransit.getPageInfo().setEndRow(endRow);
			
			return searchTransit;
		}

		public static PaymentPageInfoDTO getPageInfoPayment(int pageNo, int totalCount, int limit, int buttonAmount) {

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
			
			return new PaymentPageInfoDTO(pageNo, totalCount, limit, buttonAmount, maxPage, startPage, endPage, startRow, endRow);
			
		}
		
		public static PSearchDTO getPaymentPage(PSearchDTO searchPayment) {
			
			int maxPage;
			int startPage;
			int endPage;
			int startRow;
			int endRow;
			
			maxPage = (int) Math.ceil((double) searchPayment.getPageInfo().getTotalCount() / searchPayment.getPageInfo().getLimit());
			
			startPage = (int) (Math.ceil((double) searchPayment.getPageInfo().getPageNo() / searchPayment.getPageInfo().getButtonAmount()) -1) * searchPayment.getPageInfo().getButtonAmount() + 1;
			
			endPage = startPage + searchPayment.getPageInfo().getButtonAmount() -1;
			
			if(maxPage < endPage) {
				endPage = maxPage;
			}
			
			if(maxPage == 0 && endPage == 0) {
				maxPage = startPage;
				endPage = startPage;
			}
			
			startRow = (searchPayment.getPageInfo().getPageNo() - 1) * searchPayment.getPageInfo().getLimit() + 1;
			endRow = startRow + searchPayment.getPageInfo().getLimit() -1;
			
			searchPayment.getPageInfo().setMaxPage(maxPage);
			searchPayment.getPageInfo().setStartPage(startPage);
			searchPayment.getPageInfo().setEndPage(endPage);
			searchPayment.getPageInfo().setStartRow(startRow);
			searchPayment.getPageInfo().setEndRow(endRow);
			
			return searchPayment;
		}

		public static OrderPageInfoDTO getPageInfoOrder(int pageNo, int totalCount, int limit, int buttonAmount) {

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
			
			return new OrderPageInfoDTO(pageNo, totalCount, limit, buttonAmount, maxPage, startPage, endPage, startRow, endRow);
			
		}
		
		public static OSearchDTO getOrderPage(OSearchDTO searchOrder) {
			
			int maxPage;
			int startPage;
			int endPage;
			int startRow;
			int endRow;
			
			maxPage = (int) Math.ceil((double) searchOrder.getPageInfo().getTotalCount() / searchOrder.getPageInfo().getLimit());
			
			startPage = (int) (Math.ceil((double) searchOrder.getPageInfo().getPageNo() / searchOrder.getPageInfo().getButtonAmount()) -1) * searchOrder.getPageInfo().getButtonAmount() + 1;
			
			endPage = startPage + searchOrder.getPageInfo().getButtonAmount() -1;
			
			if(maxPage < endPage) {
				endPage = maxPage;
			}
			
			if(maxPage == 0 && endPage == 0) {
				maxPage = startPage;
				endPage = startPage;
			}
			
			startRow = (searchOrder.getPageInfo().getPageNo() - 1) * searchOrder.getPageInfo().getLimit() + 1;
			endRow = startRow + searchOrder.getPageInfo().getLimit() -1;
			
			searchOrder.getPageInfo().setMaxPage(maxPage);
			searchOrder.getPageInfo().setStartPage(startPage);
			searchOrder.getPageInfo().setEndPage(endPage);
			searchOrder.getPageInfo().setStartRow(startRow);
			searchOrder.getPageInfo().setEndRow(endRow);
			
			return searchOrder;
		}

}























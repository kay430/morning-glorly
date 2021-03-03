package com.mg.jsp.admin.model.dto.payment;

import com.mg.jsp.transit.model.DTO.TransitPageInfoDTO;

public class PSearchDTO {
	
	private String searchCondition;
	private String searchValue;
	private PaymentPageInfoDTO pageInfo;
	
	public PSearchDTO() {}

	public PSearchDTO(String searchCondition, String searchValue, PaymentPageInfoDTO pageInfo) {
		super();
		this.searchCondition = searchCondition;
		this.searchValue = searchValue;
		this.pageInfo = pageInfo;
	}

	public String getSearchCondition() {
		return searchCondition;
	}

	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	public String getSearchValue() {
		return searchValue; 
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public PaymentPageInfoDTO getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PaymentPageInfoDTO pageInfo) {
		this.pageInfo = pageInfo;
	}

	@Override
	public String toString() {
		return "SearchReadyDTO [searchCondition=" + searchCondition + ", searchValue=" + searchValue + ", pageInfo="
				+ pageInfo + "]";
	};
	
}

package com.mg.jsp.admin.model.dto.order;

import com.mg.jsp.transit.model.DTO.TransitPageInfoDTO;

public class OSearchDTO {
	
	private String searchCondition;
	private String searchValue;
	private OrderPageInfoDTO pageInfo;
	
	public OSearchDTO() {}

	public OSearchDTO(String searchCondition, String searchValue, OrderPageInfoDTO pageInfo) {
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

	public OrderPageInfoDTO getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(OrderPageInfoDTO pageInfo) {
		this.pageInfo = pageInfo;
	}

	@Override
	public String toString() {
		return "SearchReadyDTO [searchCondition=" + searchCondition + ", searchValue=" + searchValue + ", pageInfo="
				+ pageInfo + "]";
	};
	
}

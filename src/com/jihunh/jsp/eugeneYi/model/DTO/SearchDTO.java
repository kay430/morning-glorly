package com.jihunh.jsp.eugeneYi.model.DTO;

import com.jihunh.jsp.eugeneYi.model.DTO.TransitPageInfoDTO;

public class SearchDTO {
	
	private String searchCondition;
	private String searchValue;
	private TransitPageInfoDTO pageInfo;
	
	public SearchDTO() {}

	public SearchDTO(String searchCondition, String searchValue, TransitPageInfoDTO pageInfo) {
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

	public TransitPageInfoDTO getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(TransitPageInfoDTO pageInfo) {
		this.pageInfo = pageInfo;
	}

	@Override
	public String toString() {
		return "SearchReadyDTO [searchCondition=" + searchCondition + ", searchValue=" + searchValue + ", pageInfo="
				+ pageInfo + "]";
	};
	
}

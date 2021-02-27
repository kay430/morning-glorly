package com.mg.jsp.admin.model.dto;

public class SearchReadyDTO {
	
	private String searchCondition;
	private String searchValue;
	private NoticePageInfoDTO pageInfo;
	
	public SearchReadyDTO() {}

	public SearchReadyDTO(String searchCondition, String searchValue, NoticePageInfoDTO pageInfo) {
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

	public NoticePageInfoDTO getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(NoticePageInfoDTO pageInfo) {
		this.pageInfo = pageInfo;
	}

	@Override
	public String toString() {
		return "SearchReadyDTO [searchCondition=" + searchCondition + ", searchValue=" + searchValue + ", pageInfo="
				+ pageInfo + "]";
	};
	
}

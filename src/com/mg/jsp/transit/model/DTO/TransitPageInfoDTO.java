package com.mg.jsp.transit.model.DTO;

public class TransitPageInfoDTO implements java.io.Serializable {

	private int pageNo;
	private int totalCount;
	private int limit;
	private int buttonAmount;
	private int maxPage;
	private int startPage;
	private int endPage;
	private int startRow;
	private int endRow;

	public TransitPageInfoDTO() {}

	public TransitPageInfoDTO(int pageNo, int totalCount, int limit, int buttonAmount, int maxPage, int startPage,
			int endPage, int startRow, int endRow) { 
		super();
		this.pageNo = pageNo;
		this.totalCount = totalCount;
		this.limit = limit;
		this.buttonAmount = buttonAmount;
		this.maxPage = maxPage;
		this.startPage = startPage;
		this.endPage = endPage;
		this.startRow = startRow;
		this.endRow = endRow;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getButtonAmount() {
		return buttonAmount;
	}

	public void setButtonAmount(int buttonAmount) {
		this.buttonAmount = buttonAmount;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	@Override
	public String toString() {
		return "TransitPageInfoDTO [pageNo=" + pageNo + ", totalCount=" + totalCount + ", limit=" + limit
				+ ", buttonAmount=" + buttonAmount + ", maxPage=" + maxPage + ", startPage=" + startPage + ", endPage="
				+ endPage + ", startRow=" + startRow + ", endRow=" + endRow + "]";
	}

}
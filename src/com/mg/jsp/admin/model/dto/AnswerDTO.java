package com.mg.jsp.admin.model.dto;

import java.sql.Date;

import com.jihunh.jsp.member.model.dto.MgDTO;

public class AnswerDTO {

	private int no;
	private String status;
	private int categoryCode;
	private AnswerCategoryDTO category;
	private String title;
	private String body;
	private int writerMgNo;
	private MgDTO writer;
	private int count;
	private java.sql.Date createdDate;
	private java.sql.Date modifiedDate;
	private String display;
	
	public AnswerDTO() {}

	public AnswerDTO(int no, String status, int categoryCode, AnswerCategoryDTO category, String title, String body,
			int writerMgNo, MgDTO writer, int count, Date createdDate, Date modifiedDate, String display) {
		super();
		this.no = no;
		this.status = status;
		this.categoryCode = categoryCode;
		this.category = category;
		this.title = title;
		this.body = body;
		this.writerMgNo = writerMgNo;
		this.writer = writer;
		this.count = count;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.display = display;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(int categoryCode) {
		this.categoryCode = categoryCode;
	}

	public AnswerCategoryDTO getCategory() {
		return category;
	}

	public void setCategory(AnswerCategoryDTO category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public int getWriterMgNo() {
		return writerMgNo;
	}

	public void setWriterMgNo(int writerMgNo) {
		this.writerMgNo = writerMgNo;
	}

	public MgDTO getWriter() {
		return writer;
	}

	public void setWriter(MgDTO writer) {
		this.writer = writer;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public java.sql.Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(java.sql.Date createdDate) {
		this.createdDate = createdDate;
	}

	public java.sql.Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(java.sql.Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	@Override
	public String toString() {
		return "AnswerDTO [no=" + no + ", status=" + status + ", categoryCode=" + categoryCode + ", category="
				+ category + ", title=" + title + ", body=" + body + ", writerMgNo=" + writerMgNo + ", writer=" + writer
				+ ", count=" + count + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + ", display="
				+ display + "]";
	}
	
}

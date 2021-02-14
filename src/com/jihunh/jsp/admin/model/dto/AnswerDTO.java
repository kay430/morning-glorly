package com.jihunh.jsp.admin.model.dto;

import java.sql.Date;

import com.jihunh.jsp.member.model.dto.MgDTO;

public class AnswerDTO {

	private int no;
	private String type;
	private int categoryNo;
	private AnswerCategoryDTO category;
	private String title;
	private String body;
	private int writerMgNo;
	private MgDTO writer;
	private int count;
	private java.sql.Date createdDate;
	private java.sql.Date modifiedDate;
	private String status;
	
	public AnswerDTO() {}

	public AnswerDTO(int no, String type, int categoryNo, AnswerCategoryDTO category, String title, String body,
			int writerMgNo, MgDTO writer, int count, Date createdDate, Date modifiedDate, String status) {
		super();
		this.no = no;
		this.type = type;
		this.categoryNo = categoryNo;
		this.category = category;
		this.title = title;
		this.body = body;
		this.writerMgNo = writerMgNo;
		this.writer = writer;
		this.count = count;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.status = status;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "AnswerDTO [no=" + no + ", type=" + type + ", categoryNo=" + categoryNo + ", category=" + category
				+ ", title=" + title + ", body=" + body + ", writerMgNo=" + writerMgNo + ", writer=" + writer
				+ ", count=" + count + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + ", status="
				+ status + "]";
	}
	
}

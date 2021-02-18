package com.jihunh.jsp.customerservice.model.dto;

import java.sql.Date;

import com.jihunh.jsp.member.model.dto.MgDTO;

public class ReviewDTO implements java.io.Serializable{

	private int no;
	private String status;
	private int categoryNum;
	private String title;
	private String body;
	private int writerMemberNo;
	private int count;
	private MgDTO writer;
	private java.sql.Date createDate;
	private java.sql.Date modifiedDate;
    private String hideStatus;
    private CategoryDTO category;
    private java.sql.Date createdDate;
    private int categoryCode;
	private int type;
    
    
    public ReviewDTO() {}


	public ReviewDTO(int no, String status, int categoryNum, String title, String body, int writerMemberNo, int count,
			MgDTO writer, Date createDate, Date modifiedDate, String hideStatus, CategoryDTO category, Date createdDate,
			int categoryCode, int type) {
		super();
		this.no = no;
		this.status = status;
		this.categoryNum = categoryNum;
		this.title = title;
		this.body = body;
		this.writerMemberNo = writerMemberNo;
		this.count = count;
		this.writer = writer;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.hideStatus = hideStatus;
		this.category = category;
		this.createdDate = createdDate;
		this.categoryCode = categoryCode;
		this.type = type;
	}


	@Override
	public String toString() {
		return "ReviewDTO [no=" + no + ", status=" + status + ", categoryNum=" + categoryNum + ", title=" + title
				+ ", body=" + body + ", writerMemberNo=" + writerMemberNo + ", count=" + count + ", writer=" + writer
				+ ", createDate=" + createDate + ", modifiedDate=" + modifiedDate + ", hideStatus=" + hideStatus
				+ ", category=" + category + ", createdDate=" + createdDate + ", categoryCode=" + categoryCode
				+ ", type=" + type + "]";
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


	public int getCategoryNum() {
		return categoryNum;
	}


	public void setCategoryNum(int categoryNum) {
		this.categoryNum = categoryNum;
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


	public int getWriterMemberNo() {
		return writerMemberNo;
	}


	public void setWriterMemberNo(int writerMemberNo) {
		this.writerMemberNo = writerMemberNo;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public MgDTO getWriter() {
		return writer;
	}


	public void setWriter(MgDTO writer) {
		this.writer = writer;
	}


	public java.sql.Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(java.sql.Date createDate) {
		this.createDate = createDate;
	}


	public java.sql.Date getModifiedDate() {
		return modifiedDate;
	}


	public void setModifiedDate(java.sql.Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}


	public String getHideStatus() {
		return hideStatus;
	}


	public void setHideStatus(String hideStatus) {
		this.hideStatus = hideStatus;
	}


	public CategoryDTO getCategory() {
		return category;
	}


	public void setCategory(CategoryDTO category) {
		this.category = category;
	}


	public java.sql.Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(java.sql.Date createdDate) {
		this.createdDate = createdDate;
	}


	public int getCategoryCode() {
		return categoryCode;
	}


	public void setCategoryCode(int categoryCode) {
		this.categoryCode = categoryCode;
	}


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}

	
	

    
	}
    

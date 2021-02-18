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
    
    public ReviewDTO() {}
    
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
	@Override
	public String toString() {
		return "ReviewDTO [no=" + no + ", status=" + status + ", categoryNum=" + categoryNum + ", title=" + title
				+ ", body=" + body + ", writerMemberNo=" + writerMemberNo + ", count=" + count + ", writer=" + writer
				+ ", createDate=" + createDate + ", modifiedDate=" + modifiedDate + ", hideStatus=" + hideStatus + "]";
	}
	public ReviewDTO(int no, String status, int categoryNum, String title, String body, int writerMemberNo, int count,
			MgDTO writer, Date createDate, Date modifiedDate, String hideStatus) {
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
	}
	
}

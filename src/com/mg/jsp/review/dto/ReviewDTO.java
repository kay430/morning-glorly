package com.jihunh.jsp.review.dto;

import java.sql.Date;
import java.util.List;

import com.jihunh.jsp.member.model.dto.MgDTO;

public class ReviewDTO implements java.io.Serializable{

	private int no;
	private String title;
	private String body;
	private int writerMemberNo;
	private int count;
	private java.sql.Date createDate;
	private java.sql.Date modifiedDate;
	private String Display;
	private int OrderNo;
	private MgDTO mgDTO; 
	
	private List<AttachmentDTO> attachmentList;
	/* private MgDTO name; */
	
    public ReviewDTO() {}

	public ReviewDTO(int no, String title, String body, int writerMemberNo, int count, Date createDate,
			Date modifiedDate, String display, int orderNo, MgDTO mgDTO, List<AttachmentDTO> attachmentList) {
		super();
		this.no = no;
		this.title = title;
		this.body = body;
		this.writerMemberNo = writerMemberNo;
		this.count = count;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		Display = display;
		OrderNo = orderNo;
		this.mgDTO = mgDTO;
		this.attachmentList = attachmentList;
	}

	@Override
	public String toString() {
		return "ReviewDTO [no=" + no + ", title=" + title + ", body=" + body + ", writerMemberNo=" + writerMemberNo
				+ ", count=" + count + ", createDate=" + createDate + ", modifiedDate=" + modifiedDate + ", Display="
				+ Display + ", OrderNo=" + OrderNo + ", mgDTO=" + mgDTO + ", attachmentList=" + attachmentList + "]";
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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

	public String getDisplay() {
		return Display;
	}

	public void setDisplay(String display) {
		Display = display;
	}

	public int getOrderNo() {
		return OrderNo;
	}

	public void setOrderNo(int orderNo) {
		OrderNo = orderNo;
	}

	public MgDTO getMgDTO() {
		return mgDTO;
	}

	public void setMgDTO(MgDTO mgDTO) {
		this.mgDTO = mgDTO;
	}

	public List<AttachmentDTO> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<AttachmentDTO> attachmentList) {
		this.attachmentList = attachmentList;
	}
	
}
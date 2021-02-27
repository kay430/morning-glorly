package com.jihunh.jsp.admin.model.dto;


import java.sql.Date;
import java.util.List;

public class NoticeDTO implements java.io.Serializable {
	
	private int no;
	private String title;
	private String body;
	private int writerMemberNo;
	private MgAdDTO writer;
	private int count;
	private java.sql.Date createdDate;
	private String display;
	private String general;
	private String generalType;
	private AttaNoticeDTO refNotiNo;
	private List<AttaNoticeDTO> attaNotiList;
	
	public NoticeDTO() {}

	public NoticeDTO(int no, String title, String body, int writerMemberNo, MgAdDTO writer, int count, Date createdDate,
			String display, String general, String generalType, AttaNoticeDTO refNotiNo,
			List<AttaNoticeDTO> attaNotiList) {
		super();
		this.no = no;
		this.title = title;
		this.body = body;
		this.writerMemberNo = writerMemberNo;
		this.writer = writer;
		this.count = count;
		this.createdDate = createdDate;
		this.display = display;
		this.general = general;
		this.generalType = generalType;
		this.refNotiNo = refNotiNo;
		this.attaNotiList = attaNotiList;
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

	public MgAdDTO getWriter() {
		return writer;
	}

	public void setWriter(MgAdDTO writer) {
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

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public String getGeneral() {
		return general;
	}

	public void setGeneral(String general) {
		this.general = general;
	}

	public String getGeneralType() {
		return generalType;
	}

	public void setGeneralType(String generalType) {
		this.generalType = generalType;
	}

	public AttaNoticeDTO getRefNotiNo() {
		return refNotiNo;
	}

	public void setRefNotiNo(AttaNoticeDTO refNotiNo) {
		this.refNotiNo = refNotiNo;
	}

	public List<AttaNoticeDTO> getAttaNotiList() {
		return attaNotiList;
	}

	public void setAttaNotiList(List<AttaNoticeDTO> attaNotiList) {
		this.attaNotiList = attaNotiList;
	}

	@Override
	public String toString() {
		return "NoticeDTO [no=" + no + ", title=" + title + ", body=" + body + ", writerMemberNo=" + writerMemberNo
				+ ", writer=" + writer + ", count=" + count + ", createdDate=" + createdDate + ", display=" + display
				+ ", general=" + general + ", generalType=" + generalType + ", refNotiNo=" + refNotiNo
				+ ", attaNotiList=" + attaNotiList + "]";
	}
	
}

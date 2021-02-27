package com.mg.jsp.question.model.dto;

import java.sql.Date;
import java.util.List;

import com.mg.jsp.member.model.dto.MgDTO;

public class QuestionDTO implements java.io.Serializable{

	private int no;
	private String status;
	private int categoryCode;
	private String title;
	private String body;
	private int writerMemberNo;
	private int count;
	private java.sql.Date createDate;
	private java.sql.Date modifiedDate;
    private String display;
    private MgDTO mgDTO;
    private CategoryDTO category;
    
    private List<AttaQuestionDTO> attaQueList;

    public QuestionDTO() {}

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
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public MgDTO getMgDTO() {
		return mgDTO;
	}

	public void setMgDTO(MgDTO mgDTO) {
		this.mgDTO = mgDTO;
	}

	public QuestionDTO(int no, String status, int categoryCode, String title, String body, int writerMemberNo,
			int count, Date createDate, Date modifiedDate, String display, MgDTO mgDTO, CategoryDTO category,
			List<AttaQuestionDTO> attaQueList) {
		super();
		this.no = no;
		this.status = status;
		this.categoryCode = categoryCode;
		this.title = title;
		this.body = body;
		this.writerMemberNo = writerMemberNo;
		this.count = count;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.display = display;
		this.mgDTO = mgDTO;
		this.category = category;
		this.attaQueList = attaQueList;
	}

	@Override
	public String toString() {
		return "QuestionDTO [no=" + no + ", status=" + status + ", categoryCode=" + categoryCode + ", title=" + title
				+ ", body=" + body + ", writerMemberNo=" + writerMemberNo + ", count=" + count + ", createDate="
				+ createDate + ", modifiedDate=" + modifiedDate + ", display=" + display + ", mgDTO=" + mgDTO
				+ ", category=" + category + ", attaQueList=" + attaQueList + "]";
	}

	public CategoryDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
	}

	public List<AttaQuestionDTO> getAttaQueList() {
		return attaQueList;
	}

	public void setAttaQueList(List<AttaQuestionDTO> attaQueList) {
		this.attaQueList = attaQueList;
	}

	
	
}

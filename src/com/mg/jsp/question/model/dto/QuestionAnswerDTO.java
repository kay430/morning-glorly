package com.mg.jsp.question.model.dto;

import java.sql.Date;

import com.mg.jsp.admin.model.dto.MgAdDTO;

public class QuestionAnswerDTO implements java.io.Serializable {
	
	private int ansNo;
	private String ansTitle;
	private String ansBody;
	private java.sql.Date ansCreated;
	private int ansPostNo;
	private int andWriterAdminNo;
	private String ansStatus;
	private MgAdDTO mgAdDTO;
	private QuestionDTO questionDTO;
	
	public QuestionAnswerDTO(){
		
	}

	public int getAnsNo() {
		return ansNo;
	}

	public void setAnsNo(int ansNo) {
		this.ansNo = ansNo;
	}

	public String getAnsTitle() {
		return ansTitle;
	}

	public void setAnsTitle(String ansTitle) {
		this.ansTitle = ansTitle;
	}

	public String getAnsBody() {
		return ansBody;
	}

	public void setAnsBody(String ansBody) {
		this.ansBody = ansBody;
	}

	public java.sql.Date getAnsCreated() {
		return ansCreated;
	}

	public void setAnsCreated(java.sql.Date ansCreated) {
		this.ansCreated = ansCreated;
	}

	public int getAnsPostNo() {
		return ansPostNo;
	}

	public void setAnsPostNo(int ansPostNo) {
		this.ansPostNo = ansPostNo;
	}

	public int getAndWriterAdminNo() {
		return andWriterAdminNo;
	}

	public void setAndWriterAdminNo(int andWriterAdminNo) {
		this.andWriterAdminNo = andWriterAdminNo;
	}

	public String getAnsStatus() {
		return ansStatus;
	}

	public void setAnsStatus(String ansStatus) {
		this.ansStatus = ansStatus;
	}

	public MgAdDTO getMgAdDTO() {
		return mgAdDTO;
	}

	public void setMgAdDTO(MgAdDTO mgAdDTO) {
		this.mgAdDTO = mgAdDTO;
	}

	public QuestionDTO getQuestionDTO() {
		return questionDTO;
	}

	public void setQuestionDTO(QuestionDTO questionDTO) {
		this.questionDTO = questionDTO;
	}

	@Override
	public String toString() {
		return "QuestionAnswerDTO [ansNo=" + ansNo + ", ansTitle=" + ansTitle + ", ansBody=" + ansBody + ", ansCreated="
				+ ansCreated + ", ansPostNo=" + ansPostNo + ", andWriterAdminNo=" + andWriterAdminNo + ", ansStatus="
				+ ansStatus + ", mgAdDTO=" + mgAdDTO + ", questionDTO=" + questionDTO + "]";
	}

	public QuestionAnswerDTO(int ansNo, String ansTitle, String ansBody, Date ansCreated, int ansPostNo,
			int andWriterAdminNo, String ansStatus, MgAdDTO mgAdDTO, QuestionDTO questionDTO) {
		super();
		this.ansNo = ansNo;
		this.ansTitle = ansTitle;
		this.ansBody = ansBody;
		this.ansCreated = ansCreated;
		this.ansPostNo = ansPostNo;
		this.andWriterAdminNo = andWriterAdminNo;
		this.ansStatus = ansStatus;
		this.mgAdDTO = mgAdDTO;
		this.questionDTO = questionDTO;
	}
	
	
}

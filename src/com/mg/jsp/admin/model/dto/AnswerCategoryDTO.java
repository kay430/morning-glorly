package com.mg.jsp.admin.model.dto;

public class AnswerCategoryDTO implements java.io.Serializable {

	private int code;
	private String name;

	public AnswerCategoryDTO() {}

	public AnswerCategoryDTO(int code, String name) {
		super();
		this.code = code;
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CategoryDTO [code=" + code + ", name=" + name + "]";
	}
	
}

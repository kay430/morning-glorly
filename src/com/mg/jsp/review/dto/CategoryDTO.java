package com.mg.jsp.review.dto;

public class CategoryDTO implements java.io.Serializable{

	private int code;
	private String name;
	
	public CategoryDTO() {}

	public int getCode() {
		return code;
	}

	@Override
	public String toString() {
		return "CategoryDTO [code=" + code + ", name=" + name + "]";
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public CategoryDTO(int code, String name) {
		super();
		this.code = code;
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

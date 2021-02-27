package com.mg.jsp.admin.model.product.model.dto;

import java.sql.Date;
import java.util.List;

public class MgGoodsDTO {

	private int no;
	private String name;
	private int price;
	private int writerMemberNo;
//	private MgDTO writer;
	private int typeNo;
	private MgGoodsTypeDTO goodsTypeNo;
	private java.sql.Date createdDate;
	private String status;
	private java.sql.Date modifiedDate;

	private List<AttachmentDTO> attachmentList;
	
	public MgGoodsDTO() {
		
	}

	public MgGoodsDTO(int no, String name, int price, int writerMemberNo, int typeNo, MgGoodsTypeDTO goodsTypeNo,
			Date createdDate, String status, Date modifiedDate, List<AttachmentDTO> attachmentList) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.writerMemberNo = writerMemberNo;
		this.typeNo = typeNo;
		this.goodsTypeNo = goodsTypeNo;
		this.createdDate = createdDate;
		this.status = status;
		this.modifiedDate = modifiedDate;
		this.attachmentList = attachmentList;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getWriterMemberNo() {
		return writerMemberNo;
	}

	public void setWriterMemberNo(int writerMemberNo) {
		this.writerMemberNo = writerMemberNo;
	}

	public int getTypeNo() {
		return typeNo;
	}

	public void setTypeNo(int typeNo) {
		this.typeNo = typeNo;
	}

	public MgGoodsTypeDTO getGoodsTypeNo() {
		return goodsTypeNo;
	}

	public void setGoodsTypeNo(MgGoodsTypeDTO goodsTypeNo) {
		this.goodsTypeNo = goodsTypeNo;
	}

	public java.sql.Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(java.sql.Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public java.sql.Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(java.sql.Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public List<AttachmentDTO> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<AttachmentDTO> attachmentList) {
		this.attachmentList = attachmentList;
	}

	@Override
	public String toString() {
		return "MgGoodsDTO [no=" + no + ", name=" + name + ", price=" + price + ", writerMemberNo=" + writerMemberNo
				+ ", typeNo=" + typeNo + ", goodsTypeNo=" + goodsTypeNo + ", createdDate=" + createdDate + ", status="
				+ status + ", modifiedDate=" + modifiedDate + ", attachmentList=" + attachmentList + "]";
	}

	

	
	
	
}

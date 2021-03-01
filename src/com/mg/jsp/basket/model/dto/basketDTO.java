package com.mg.jsp.basket.model.dto;

import java.util.List;

import com.mg.jsp.admin.model.product.model.dto.AttachmentDTO;
import com.mg.jsp.admin.model.product.model.dto.MgGoodsDTO;
import com.mg.jsp.member.model.dto.MgDTO;

public class basketDTO  implements java.io.Serializable{
	
	private int memberNo;
	private int goodsNo;
	private int amountCount;
	private MgGoodsDTO mgGoodsDTO;
	private MgDTO mgDTO;
	
	private List<AttachmentDTO> attachmentList;
	
	public basketDTO() {
		
	}

	public basketDTO(int memberNo, int goodsNo, int amountCount, MgGoodsDTO mgGoodsDTO, MgDTO mgDTO,
			List<AttachmentDTO> attachmentList) {
		super();
		this.memberNo = memberNo;
		this.goodsNo = goodsNo;
		this.amountCount = amountCount;
		this.mgGoodsDTO = mgGoodsDTO;
		this.mgDTO = mgDTO;
		this.attachmentList = attachmentList;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getGoodsNo() {
		return goodsNo;
	}

	public void setGoodsNo(int goodsNo) {
		this.goodsNo = goodsNo;
	}

	public int getAmountCount() {
		return amountCount;
	}

	public void setAmountCount(int amountCount) {
		this.amountCount = amountCount;
	}

	public MgGoodsDTO getMgGoodsDTO() {
		return mgGoodsDTO;
	}

	public void setMgGoodsDTO(MgGoodsDTO mgGoodsDTO) {
		this.mgGoodsDTO = mgGoodsDTO;
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

	@Override
	public String toString() {
		return "basketDTO [memberNo=" + memberNo + ", goodsNo=" + goodsNo + ", amountCount=" + amountCount
				+ ", mgGoodsDTO=" + mgGoodsDTO + ", mgDTO=" + mgDTO + ", attachmentList=" + attachmentList
				+ ", getMemberNo()=" + getMemberNo() + ", getGoodsNo()=" + getGoodsNo() + ", getAmountCount()="
				+ getAmountCount() + ", getMgGoodsDTO()=" + getMgGoodsDTO() + ", getMgDTO()=" + getMgDTO()
				+ ", getAttachmentList()=" + getAttachmentList() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}

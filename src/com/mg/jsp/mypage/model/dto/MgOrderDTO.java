package com.mg.jsp.mypage.model.dto;

import java.sql.Date;

import com.mg.jsp.admin.model.product.model.dto.MgGoodsDTO;
import com.mg.jsp.member.model.dto.MgDTO;

public class MgOrderDTO implements java.io.Serializable{


	private int no;
	private int memberNo;
	private java.sql.Date date;
	private String title;
	private int amountPrice;
	private MgDTO mgDTO;
	private MgGoodsDTO mgGoodsDTO;
	
	
	public MgOrderDTO() {
		
	}


	public MgOrderDTO(int no, int memberNo, Date date, String title, int amountPrice, MgDTO mgDTO,
			MgGoodsDTO mgGoodsDTO) {
		super();
		this.no = no;
		this.memberNo = memberNo;
		this.date = date;
		this.title = title;
		this.amountPrice = amountPrice;
		this.mgDTO = mgDTO;
		this.mgGoodsDTO = mgGoodsDTO;
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public int getMemberNo() {
		return memberNo;
	}


	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}


	public java.sql.Date getDate() {
		return date;
	}


	public void setDate(java.sql.Date date) {
		this.date = date;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getAmountPrice() {
		return amountPrice;
	}


	public void setAmountPrice(int amountPrice) {
		this.amountPrice = amountPrice;
	}


	public MgDTO getMgDTO() {
		return mgDTO;
	}


	public void setMgDTO(MgDTO mgDTO) {
		this.mgDTO = mgDTO;
	}


	public MgGoodsDTO getMgGoodsDTO() {
		return mgGoodsDTO;
	}


	public void setMgGoodsDTO(MgGoodsDTO mgGoodsDTO) {
		this.mgGoodsDTO = mgGoodsDTO;
	}


	@Override
	public String toString() {
		return "MgOrderDTO [no=" + no + ", memberNo=" + memberNo + ", date=" + date + ", title=" + title
				+ ", amountPrice=" + amountPrice + ", mgDTO=" + mgDTO + ", mgGoodsDTO=" + mgGoodsDTO + "]";
	}
	
}

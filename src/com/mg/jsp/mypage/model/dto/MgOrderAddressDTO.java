package com.mg.jsp.mypage.model.dto;

import com.mg.jsp.admin.model.dto.MemberPointDTO;
import com.mg.jsp.admin.model.product.model.dto.MgGoodsDTO;
import com.mg.jsp.member.model.dto.MgDTO;

public class MgOrderAddressDTO implements java.io.Serializable {

	
	private int orderAddNo;
	private int deliveryNo;
	private String orderAddType;
	private String recieverName;
	private String phone;
	private String recieverAddress;
	private int memberNo;
	private MgDTO mgDTO;
	private int addressNo;
	private MgGoodsDTO mgGoodsDTO;
	private MgOrderDTO mgOrderDTO;
	private MgOrderDeliveryDTO mgOrderDeliveryDTO;
	private MgOrderGoodsDTO mgOrderGoodsDTO;
	private MemberPointDTO mgPointDTO;
	private int modPoint;
	private int pNo;
	 
	public MgOrderAddressDTO() {
		
	}

	public MgOrderAddressDTO(int orderAddNo, int deliveryNo, String orderAddType, String recieverName, String phone,
			String recieverAddress, int memberNo, MgDTO mgDTO, int addressNo, MgGoodsDTO mgGoodsDTO,
			MgOrderDTO mgOrderDTO, MgOrderDeliveryDTO mgOrderDeliveryDTO, MgOrderGoodsDTO mgOrderGoodsDTO,
			MemberPointDTO mgPointDTO, int modPoint, int pNo) {
		super();
		this.orderAddNo = orderAddNo;
		this.deliveryNo = deliveryNo;
		this.orderAddType = orderAddType;
		this.recieverName = recieverName;
		this.phone = phone;
		this.recieverAddress = recieverAddress;
		this.memberNo = memberNo;
		this.mgDTO = mgDTO;
		this.addressNo = addressNo;
		this.mgGoodsDTO = mgGoodsDTO;
		this.mgOrderDTO = mgOrderDTO;
		this.mgOrderDeliveryDTO = mgOrderDeliveryDTO;
		this.mgOrderGoodsDTO = mgOrderGoodsDTO;
		this.mgPointDTO = mgPointDTO;
		this.modPoint = modPoint;
		this.pNo = pNo;
	}

	public int getOrderAddNo() {
		return orderAddNo;
	}

	public void setOrderAddNo(int orderAddNo) {
		this.orderAddNo = orderAddNo;
	}

	public int getDeliveryNo() {
		return deliveryNo;
	}

	public void setDeliveryNo(int deliveryNo) {
		this.deliveryNo = deliveryNo;
	}

	public String getOrderAddType() {
		return orderAddType;
	}

	public void setOrderAddType(String orderAddType) {
		this.orderAddType = orderAddType;
	}

	public String getRecieverName() {
		return recieverName;
	}

	public void setRecieverName(String recieverName) {
		this.recieverName = recieverName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRecieverAddress() {
		return recieverAddress;
	}

	public void setRecieverAddress(String recieverAddress) {
		this.recieverAddress = recieverAddress;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public MgDTO getMgDTO() {
		return mgDTO;
	}

	public void setMgDTO(MgDTO mgDTO) {
		this.mgDTO = mgDTO;
	}

	public int getAddressNo() {
		return addressNo;
	}

	public void setAddressNo(int addressNo) {
		this.addressNo = addressNo;
	}

	public MgGoodsDTO getMgGoodsDTO() {
		return mgGoodsDTO;
	}

	public void setMgGoodsDTO(MgGoodsDTO mgGoodsDTO) {
		this.mgGoodsDTO = mgGoodsDTO;
	}

	public MgOrderDTO getMgOrderDTO() {
		return mgOrderDTO;
	}

	public void setMgOrderDTO(MgOrderDTO mgOrderDTO) {
		this.mgOrderDTO = mgOrderDTO;
	}

	public MgOrderDeliveryDTO getMgOrderDeliveryDTO() {
		return mgOrderDeliveryDTO;
	}

	public void setMgOrderDeliveryDTO(MgOrderDeliveryDTO mgOrderDeliveryDTO) {
		this.mgOrderDeliveryDTO = mgOrderDeliveryDTO;
	}

	public MgOrderGoodsDTO getMgOrderGoodsDTO() {
		return mgOrderGoodsDTO;
	}

	public void setMgOrderGoodsDTO(MgOrderGoodsDTO mgOrderGoodsDTO) {
		this.mgOrderGoodsDTO = mgOrderGoodsDTO;
	}

	public MemberPointDTO getMgPointDTO() {
		return mgPointDTO;
	}

	public void setMgPointDTO(MemberPointDTO mgPointDTO) {
		this.mgPointDTO = mgPointDTO;
	}

	public int getModPoint() {
		return modPoint;
	}

	public void setModPoint(int modPoint) {
		this.modPoint = modPoint;
	}

	public int getpNo() {
		return pNo;
	}

	public void setpNo(int pNo) {
		this.pNo = pNo;
	}

	@Override
	public String toString() {
		return "MgOrderAddressDTO [orderAddNo=" + orderAddNo + ", deliveryNo=" + deliveryNo + ", orderAddType="
				+ orderAddType + ", recieverName=" + recieverName + ", phone=" + phone + ", recieverAddress="
				+ recieverAddress + ", memberNo=" + memberNo + ", mgDTO=" + mgDTO + ", addressNo=" + addressNo
				+ ", mgGoodsDTO=" + mgGoodsDTO + ", mgOrderDTO=" + mgOrderDTO + ", mgOrderDeliveryDTO="
				+ mgOrderDeliveryDTO + ", mgOrderGoodsDTO=" + mgOrderGoodsDTO + ", mgPointDTO=" + mgPointDTO
				+ ", modPoint=" + modPoint + ", pNo=" + pNo + "]";
	}


}

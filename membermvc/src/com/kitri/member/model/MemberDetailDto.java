package com.kitri.member.model;

public class MemberDetailDto extends MemberDto {

	private String id;
	private String tel1;
	private String tel2;
	private String tel3;
	private String zipCode;
	private String address;
	private String addressDetail;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTel1() {
		return tel1;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	public String getTel2() {
		return tel2;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	public String getTel3() {
		return tel3;
	}

	public void setTel3(String tel3) {
		this.tel3 = tel3;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	// 테스트용. 실제 서비스 할때는 지워도 됨.
	@Override
	public String toString() {
		return super.toString() + "\nMemberDetailDto [ tel1=" + tel1 + ", tel2=" + tel2 + ", tel3=" + tel3
				+ ", zipCode=" + zipCode + ", adress=" + address + ", adressDetail=" + addressDetail + "]";
	}
}

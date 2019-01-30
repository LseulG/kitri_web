package com.kitri.member.model;

public class MemberDto {
	private String id;
	private String name;
	private String pass;
	private String emailId;
	private String emailDomain;
	private String joinDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getEmailDomain() {
		return emailDomain;
	}

	public void setEmailDomain(String emailDomain) {
		this.emailDomain = emailDomain;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	
	// 테스트용. 실제 서비스 할때는 지워도 됨.
	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", name=" + name + ", pass=" + pass + ", emailId=" + emailId + ", emailDomain="
				+ emailDomain + ", joinDate=" + joinDate + "]";
	}
}

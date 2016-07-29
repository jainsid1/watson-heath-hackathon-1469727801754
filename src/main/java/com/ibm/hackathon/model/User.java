package com.ibm.hackathon.model;

public class User {
	int id;
	String name;
	String uname;
	String pwd;
	String email;
	String mobile_number;
	String role;
	String dob;
	
	
	public User() {
		super();
	}
	public User(String name, String uname, String pwd, String email, String mobile_number, String role,
			String dob) {
		super();
		this.name = name;
		this.uname = uname;
		this.pwd = pwd;
		this.email = email;
		this.mobile_number = mobile_number;
		this.role = role;
		this.dob = dob;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", uname=" + uname + ", pwd=" + pwd + ", email=" + email
				+ ", mobile_number=" + mobile_number + ", role=" + role + ", dob=" + dob + "]";
	}
	
	
	
}

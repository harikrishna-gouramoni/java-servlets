package com.society.entity;

public class Society {

	private int mid;
	private String mname;
	private String address;
	private String membership;
	private String contactNo;
	private String email;
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMembership() {
		return membership;
	}
	public void setMembership(String membership) {
		this.membership = membership;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Society [mid=" + mid + ", mname=" + mname + ", address=" + address + ", membership=" + membership
				+ ", contactNo=" + contactNo + ", email=" + email + "]";
	}
	

}

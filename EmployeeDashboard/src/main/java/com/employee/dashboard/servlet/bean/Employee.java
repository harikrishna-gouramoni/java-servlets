package com.employee.dashboard.servlet.bean;

import java.io.Serializable;

public class Employee  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int employee_id;
	private String name;
	private String dob;
	private String city;
	private String contact_number;
	
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getContact_number() {
		return contact_number;
	}
	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [");
		builder.append(", employee_id=");
		builder.append(employee_id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", dob=");
		builder.append(dob);
		builder.append(", city=");
		builder.append(city);
		builder.append(", contact_number=");
		builder.append(contact_number);
		builder.append("]");
		return builder.toString();
	}
}

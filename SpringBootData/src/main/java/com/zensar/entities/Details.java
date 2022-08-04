package com.zensar.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Range;

@Entity
public class Details {

	@Id
	private int employeeId;

	@NotEmpty(message = "Name not be Null")
	private String employeeName;

	@Email(message = "invalid email address")
	private String emailId;

	@NotEmpty(message = "cityName shouldn't null")
	private String cityName;

//	@Range(min=10 ,max=12)
//	@Min(10)
//	@Max(12)
	private long phoneNo;

	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

	@UpdateTimestamp
	private Date lastUpdate;

	public Details() {
		super();
	}

	public Details(Date lastUpdate) {
		super();
		this.lastUpdate = lastUpdate;
	}

	public Details(int employeeId, String employeeName, String emailId, String cityName, long phoneNo) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.emailId = emailId;
		this.cityName = cityName;
		this.phoneNo = phoneNo;
	}

	public Details(int employeeId, String employeeName, String emailId, String cityName, long phoneNo,
			Address address) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.emailId = emailId;
		this.cityName = cityName;
		this.phoneNo = phoneNo;
		this.address = address;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Details [employeeId=" + employeeId + ", employeeName=" + employeeName + ", emailId=" + emailId
				+ ", cityName=" + cityName + ", phoneNo=" + phoneNo + "]";
	}

}

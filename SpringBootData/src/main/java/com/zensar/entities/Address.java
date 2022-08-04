package com.zensar.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Address {

	@Id
	private int addressId;

//	@NotNull(message = "Please Enter The StreatName")
	private String streatName;

//	@NotNull(message = "Enter the CityName")
	private String city;

//	@NotNull(message = "Country shouldn't null")
	private String country;

//	@NotNull(message = "PinCode shouldn't null")
	private int pinCode;

	public Address() {
		super();
	}

	public Address(int addressId, String streatName, String city, String country, int pinCode) {
		super();
		this.addressId = addressId;
		this.streatName = streatName;
		this.city = city;
		this.country = country;
		this.pinCode = pinCode;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getStreatName() {
		return streatName;
	}

	public void setStreatName(String streatName) {
		this.streatName = streatName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", streatName=" + streatName + ", city=" + city + ", country="
				+ country + ", pinCode=" + pinCode + "]";
	}

}

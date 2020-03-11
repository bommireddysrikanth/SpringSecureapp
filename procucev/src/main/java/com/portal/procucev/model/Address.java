package com.portal.procucev.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The persistent class for the address database table.
 * 
 */
@Entity
@Table(name = "address")
public class Address extends Procucev {

	private static final long serialVersionUID = 1L;

	@Column(name = "address_first")
	private String addressFirst;

	@Column(name = "address_second")
	private String addressSecond;

	private String area;

	private String city;

	private String landmark;

	private String pincode;

	private String state;

	/*
	 * @Column(name = "vendor_vendor_id") private int vendorVendorId;
	 */

	public Address() {
		super();
	}

	public String getAddressFirst() {
		return this.addressFirst;
	}

	public void setAddressFirst(String addressFirst) {
		this.addressFirst = addressFirst;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAddressSecond() {
		return this.addressSecond;
	}

	public void setAddressSecond(String addressSecond) {
		this.addressSecond = addressSecond;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getLandmark() {
		return this.landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getPincode() {
		return this.pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

}
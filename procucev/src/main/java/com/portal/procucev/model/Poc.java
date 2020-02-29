package com.portal.procucev.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the poc database table.
 * 
 */
@Entity
@Table(name = "poc")
public class Poc extends Procucev implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "poc_id")
	private int pocId;

	@Column(name = "address_id")
	private int addressId;

	private String email;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "poc_first_name")
	private String pocFirstName;

	@Column(name = "poc_second_name")
	private String pocSecondName;

	public Poc() {
		super();
	}

	public int getPocId() {
		return this.pocId;
	}

	public void setPocId(int pocId) {
		this.pocId = pocId;
	}

	public int getAddressId() {
		return this.addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPocFirstName() {
		return this.pocFirstName;
	}

	public void setPocFirstName(String pocFirstName) {
		this.pocFirstName = pocFirstName;
	}

	public String getPocSecondName() {
		return this.pocSecondName;
	}

	public void setPocSecondName(String pocSecondName) {
		this.pocSecondName = pocSecondName;
	}

}
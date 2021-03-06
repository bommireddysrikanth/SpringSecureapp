package com.portal.procucev.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The persistent class for the org_bank_details database table.
 * 
 */
@Entity
@Table(name = "org_bank_details")
public class OrgBankDetail extends Procucev {
	private static final long serialVersionUID = 1L;

	@Column(name = "account_number")
	private String accountNumber;

	@ManyToOne
	// @JoinColumn(name = "address_id")
	private Address addressId;

	@Column(name = "bank_name")
	private String bankName;

	public OrgBankDetail() {
		super();
	}

	public String getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBankName() {
		return this.bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Address getAddressId() {
		return addressId;
	}

	public void setAddressId(Address addressId) {
		this.addressId = addressId;
	}

}
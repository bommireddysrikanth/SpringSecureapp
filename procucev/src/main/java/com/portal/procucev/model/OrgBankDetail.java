package com.portal.procucev.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the org_bank_details database table.
 * 
 */
@Entity
@Table(name="org_bank_details")
@NamedQuery(name="OrgBankDetail.findAll", query="SELECT o FROM OrgBankDetail o")
public class OrgBankDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="org_bank_details_id")
	private int orgBankDetailsId;

	@Column(name="account_number")
	private String accountNumber;

	@Column(name="address_id")
	private int addressId;

	@Column(name="bank_name")
	private String bankName;

	//bi-directional many-to-one association to Organization
	@ManyToOne
	@JoinColumn(name="orgination_id")
	private Organization organization;

	public OrgBankDetail() {
	}

	public int getOrgBankDetailsId() {
		return this.orgBankDetailsId;
	}

	public void setOrgBankDetailsId(int orgBankDetailsId) {
		this.orgBankDetailsId = orgBankDetailsId;
	}

	public String getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getAddressId() {
		return this.addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getBankName() {
		return this.bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Organization getOrganization() {
		return this.organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

}
package com.portal.procucev.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the org_branches database table.
 * 
 */
@Entity
@Table(name="org_branches")
@NamedQuery(name="OrgBranch.findAll", query="SELECT o FROM OrgBranch o")
public class OrgBranch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="org_branches_id")
	private int orgBranchesId;

	@Column(name="bank_name")
	private String bankName;

	//bi-directional many-to-one association to Address
	@ManyToOne
	@JoinColumn(name="address_id")
	private Address address;

	//bi-directional many-to-one association to Organization
	@ManyToOne
	@JoinColumn(name="organization_id")
	private Organization organization;

	public OrgBranch() {
	}

	public int getOrgBranchesId() {
		return this.orgBranchesId;
	}

	public void setOrgBranchesId(int orgBranchesId) {
		this.orgBranchesId = orgBranchesId;
	}

	public String getBankName() {
		return this.bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Organization getOrganization() {
		return this.organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

}
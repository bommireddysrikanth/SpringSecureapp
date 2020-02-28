package com.portal.procucev.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the organization database table.
 * 
 */
@Entity
@Table(name="organization")
@NamedQuery(name="Organization.findAll", query="SELECT o FROM Organization o")
public class Organization implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="organization_id")
	private int organizationId;

	@Column(name="GSTIN")
	private String gstin;

	@Column(name="organization_name")
	private String organizationName;

	@Column(name="organization_phonenumber")
	private String organizationPhonenumber;

	private String organizationcol;

	@Column(name="PAN")
	private String pan;

	//bi-directional many-to-one association to OrgBankDetail
	@OneToMany(mappedBy="organization")
	private List<OrgBankDetail> orgBankDetails;

	//bi-directional many-to-one association to OrgBranch
	@OneToMany(mappedBy="organization")
	private List<OrgBranch> orgBranches;

	//bi-directional many-to-one association to Address
	@ManyToOne
	@JoinColumn(name="address_id")
	private Address address;

	//bi-directional many-to-one association to OrgStatus
	@ManyToOne
	@JoinColumn(name="org_status_id")
	private OrgStatus orgStatus;

	//bi-directional many-to-one association to OrgType
	@ManyToOne
	@JoinColumn(name="organization_type_id")
	private OrgType orgType;

	//bi-directional many-to-one association to Poc
	@ManyToOne
	@JoinColumn(name="poc_id")
	private Poc poc;

	public Organization() {
	}

	public int getOrganizationId() {
		return this.organizationId;
	}

	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}

	public String getGstin() {
		return this.gstin;
	}

	public void setGstin(String gstin) {
		this.gstin = gstin;
	}

	public String getOrganizationName() {
		return this.organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getOrganizationPhonenumber() {
		return this.organizationPhonenumber;
	}

	public void setOrganizationPhonenumber(String organizationPhonenumber) {
		this.organizationPhonenumber = organizationPhonenumber;
	}

	public String getOrganizationcol() {
		return this.organizationcol;
	}

	public void setOrganizationcol(String organizationcol) {
		this.organizationcol = organizationcol;
	}

	public String getPan() {
		return this.pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public List<OrgBankDetail> getOrgBankDetails() {
		return this.orgBankDetails;
	}

	public void setOrgBankDetails(List<OrgBankDetail> orgBankDetails) {
		this.orgBankDetails = orgBankDetails;
	}

	public OrgBankDetail addOrgBankDetail(OrgBankDetail orgBankDetail) {
		getOrgBankDetails().add(orgBankDetail);
		orgBankDetail.setOrganization(this);

		return orgBankDetail;
	}

	public OrgBankDetail removeOrgBankDetail(OrgBankDetail orgBankDetail) {
		getOrgBankDetails().remove(orgBankDetail);
		orgBankDetail.setOrganization(null);

		return orgBankDetail;
	}

	public List<OrgBranch> getOrgBranches() {
		return this.orgBranches;
	}

	public void setOrgBranches(List<OrgBranch> orgBranches) {
		this.orgBranches = orgBranches;
	}

	public OrgBranch addOrgBranch(OrgBranch orgBranch) {
		getOrgBranches().add(orgBranch);
		orgBranch.setOrganization(this);

		return orgBranch;
	}

	public OrgBranch removeOrgBranch(OrgBranch orgBranch) {
		getOrgBranches().remove(orgBranch);
		orgBranch.setOrganization(null);

		return orgBranch;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public OrgStatus getOrgStatus() {
		return this.orgStatus;
	}

	public void setOrgStatus(OrgStatus orgStatus) {
		this.orgStatus = orgStatus;
	}

	public OrgType getOrgType() {
		return this.orgType;
	}

	public void setOrgType(OrgType orgType) {
		this.orgType = orgType;
	}

	public Poc getPoc() {
		return this.poc;
	}

	public void setPoc(Poc poc) {
		this.poc = poc;
	}

}
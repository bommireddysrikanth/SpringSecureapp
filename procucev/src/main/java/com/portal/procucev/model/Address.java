package com.portal.procucev.model;


import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.portal.procucev.model.*;


/**
 * The persistent class for the address database table.
 * 
 */
@Entity
@Table(name="address")
@NamedQuery(name="Address.findAll", query="SELECT a FROM Address a")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="address_id")
	private int addressId;

	@Column(name="address_first")
	private String addressFirst;

	@Column(name="address_second")
	private String addressSecond;

	private String area;

	private String city;

	private String landmark;

	private String pincode;

	private String state;


	@Column(name="vendor_vendor_id")
	private int vendorVendorId;

	//bi-directional many-to-one association to OrgBranch
	@OneToMany(mappedBy="address")
	private List<OrgBranch> orgBranches;

	//bi-directional many-to-one association to Organization
	@OneToMany(mappedBy="address")
	private List<Organization> organizations;

	public Address() {
	}

	public int getAddressId() {
		return this.addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getAddressFirst() {
		return this.addressFirst;
	}

	public void setAddressFirst(String addressFirst) {
		this.addressFirst = addressFirst;
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

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}


	public int getVendorVendorId() {
		return this.vendorVendorId;
	}

	public void setVendorVendorId(int vendorVendorId) {
		this.vendorVendorId = vendorVendorId;
	}

	public List<OrgBranch> getOrgBranches() {
		return this.orgBranches;
	}

	public void setOrgBranches(List<OrgBranch> orgBranches) {
		this.orgBranches = orgBranches;
	}

	public OrgBranch addOrgBranch(OrgBranch orgBranch) {
		getOrgBranches().add(orgBranch);
		orgBranch.setAddress(this);

		return orgBranch;
	}

	public OrgBranch removeOrgBranch(OrgBranch orgBranch) {
		getOrgBranches().remove(orgBranch);
		orgBranch.setAddress(null);

		return orgBranch;
	}

	public List<Organization> getOrganizations() {
		return this.organizations;
	}

	public void setOrganizations(List<Organization> organizations) {
		this.organizations = organizations;
	}

	public Organization addOrganization(Organization organization) {
		getOrganizations().add(organization);
		organization.setAddress(this);

		return organization;
	}

	public Organization removeOrganization(Organization organization) {
		getOrganizations().remove(organization);
		organization.setAddress(null);

		return organization;
	}

}
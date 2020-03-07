package com.portal.procucev.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The persistent class for the rfq_vendors database table.
 * 
 */
@Entity
@Table(name = "rfq_vendors")
public class RfqVendor extends Procucev {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rfq_vendors_id")
	private int rfqVendorsId;

	@ManyToOne
	@JoinColumn(name = "organization_id")
	private Organization organization;

	@Column(name = "is_rfq_notified")
	private byte isRfqNotified;

	@ManyToOne
	private Rfq rfq;

	@Column(name = "rfq_notified_to")
	private String rfqNotifiedTo;

	@ManyToOne
	@JoinColumn(name = "org_status_id")
	private OrgStatus rfqVendorStatus;

	@ManyToOne
	private User user;

	public RfqVendor() {
	}

	public int getRfqVendorsId() {
		return this.rfqVendorsId;
	}

	public void setRfqVendorsId(int rfqVendorsId) {
		this.rfqVendorsId = rfqVendorsId;
	}

	public byte getIsRfqNotified() {
		return this.isRfqNotified;
	}

	public void setIsRfqNotified(byte isRfqNotified) {
		this.isRfqNotified = isRfqNotified;
	}

	public String getRfqNotifiedTo() {
		return this.rfqNotifiedTo;
	}

	public void setRfqNotifiedTo(String rfqNotifiedTo) {
		this.rfqNotifiedTo = rfqNotifiedTo;
	}

	public Organization getOrg() {
		return organization;
	}

	public void setOrg(Organization org) {
		this.organization = org;
	}

	public Rfq getRfq() {
		return rfq;
	}

	public void setRfq(Rfq rfq) {
		this.rfq = rfq;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Organization getOrganizationId() {
		return organization;
	}

	public void setOrganizationId(Organization organizationId) {
		this.organization = organizationId;
	}

	public OrgStatus getRfqVendorStatus() {
		return rfqVendorStatus;
	}

	public void setRfqVendorStatus(OrgStatus rfqVendorStatus) {
		this.rfqVendorStatus = rfqVendorStatus;
	}

}
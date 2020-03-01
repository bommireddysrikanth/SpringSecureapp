package com.portal.procucev.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * The persistent class for the rfq_vendors database table.
 * 
 */
@Entity
@Table(name = "rfq_vendors")
@NamedQuery(name = "RfqVendor.findAll", query = "SELECT r FROM RfqVendor r")
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

	@Column(name = "rfq_notified_ts")
	private Date rfqNotifiedTs;

	@ManyToOne
	@JoinColumn(name = "org_status_id")
	private OrgStatus rfqVendorStatus;

	@Column(name = "sent_ts")
	private Date sentTs;

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

	public void setRfqNotifiedTs(Timestamp rfqNotifiedTs) {
		this.rfqNotifiedTs = rfqNotifiedTs;
	}

	public void setSentTs(Timestamp sentTs) {
		this.sentTs = sentTs;
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

	public Date getRfqNotifiedTs() {
		return rfqNotifiedTs;
	}

	public void setRfqNotifiedTs(Date rfqNotifiedTs) {
		this.rfqNotifiedTs = rfqNotifiedTs;
	}

	public Date getSentTs() {
		return sentTs;
	}

	public void setSentTs(Date sentTs) {
		this.sentTs = sentTs;
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
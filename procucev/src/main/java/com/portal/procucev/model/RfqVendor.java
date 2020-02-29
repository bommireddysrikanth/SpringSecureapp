package com.portal.procucev.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the rfq_vendors database table.
 * 
 */
@Entity
@Table(name="rfq_vendors")
@NamedQuery(name="RfqVendor.findAll", query="SELECT r FROM RfqVendor r")
public class RfqVendor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rfq_vendors_id")
	private int rfqVendorsId;
	
	@Column(name="org_id")
	private int orgId;
	
	@Column(name="is_rfq_notified")
	private byte isRfqNotified;

	@Column(name="rfq_id")
	private int rfqId;

	@Column(name="rfq_notified_to")
	private String rfqNotifiedTo;

	@Column(name="rfq_notified_ts")
	private Timestamp rfqNotifiedTs;

	@Column(name="rfq_vendor_status")
	private String rfqVendorStatus;

	@Column(name="sent_ts")
	private Timestamp sentTs;

	@Column(name="sent_user_id")
	private int sentUserId;

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

	public int getRfqId() {
		return this.rfqId;
	}

	public void setRfqId(int rfqId) {
		this.rfqId = rfqId;
	}

	public String getRfqNotifiedTo() {
		return this.rfqNotifiedTo;
	}

	public void setRfqNotifiedTo(String rfqNotifiedTo) {
		this.rfqNotifiedTo = rfqNotifiedTo;
	}

	public Timestamp getRfqNotifiedTs() {
		return this.rfqNotifiedTs;
	}

	public void setRfqNotifiedTs(Timestamp rfqNotifiedTs) {
		this.rfqNotifiedTs = rfqNotifiedTs;
	}

	public String getRfqVendorStatus() {
		return this.rfqVendorStatus;
	}

	public void setRfqVendorStatus(String rfqVendorStatus) {
		this.rfqVendorStatus = rfqVendorStatus;
	}

	public Timestamp getSentTs() {
		return this.sentTs;
	}

	public void setSentTs(Timestamp sentTs) {
		this.sentTs = sentTs;
	}

	public int getSentUserId() {
		return this.sentUserId;
	}

	public void setSentUserId(int sentUserId) {
		this.sentUserId = sentUserId;
	}

	public int getOrgId() {
		return orgId;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

}
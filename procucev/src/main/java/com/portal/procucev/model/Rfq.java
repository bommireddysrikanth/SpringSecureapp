package com.portal.procucev.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the rfq database table.
 * 
 */
@Entity
@Table(name="rfq")
@NamedQuery(name="Rfq.findAll", query="SELECT r FROM Rfq r")
public class Rfq implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rfq_id")
	private int rfqId;

	@Column(name="pr_id")
	private int prId;

	@Column(name="query_id")
	private int queryId;

	@Column(name="rfq_created_by")
	private String rfqCreatedBy;

	private Timestamp rfq_created_TS;

	@Column(name="rfq_status")
	private String rfqStatus;

	public Rfq() {
	}

	public int getRfqId() {
		return this.rfqId;
	}

	public void setRfqId(int rfqId) {
		this.rfqId = rfqId;
	}

	public int getPrId() {
		return this.prId;
	}

	public void setPrId(int prId) {
		this.prId = prId;
	}

	public int getQueryId() {
		return this.queryId;
	}

	public void setQueryId(int queryId) {
		this.queryId = queryId;
	}

	public String getRfqCreatedBy() {
		return this.rfqCreatedBy;
	}

	public void setRfqCreatedBy(String rfqCreatedBy) {
		this.rfqCreatedBy = rfqCreatedBy;
	}

	public Timestamp getRfq_created_TS() {
		return this.rfq_created_TS;
	}

	public void setRfq_created_TS(Timestamp rfq_created_TS) {
		this.rfq_created_TS = rfq_created_TS;
	}

	public String getRfqStatus() {
		return this.rfqStatus;
	}

	public void setRfqStatus(String rfqStatus) {
		this.rfqStatus = rfqStatus;
	}

}
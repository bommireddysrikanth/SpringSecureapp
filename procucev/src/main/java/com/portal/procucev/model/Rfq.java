package com.portal.procucev.model;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the rfq database table.
 * 
 */
@Entity
@Table(name = "rfq")
public class Rfq extends Procucev {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rfq_id")
	private int rfqId;

	@ManyToOne
	private PR prId;

	@ManyToMany
	private List<Query> queryId;

	@Column(name = "rfq_created_by")
	private String rfqCreatedBy;

	private Timestamp rfq_created_TS;

	@ManyToOne
	private OrgStatus rfqStatus;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "rfq_id_fk")
	private Set<RFQDocument> documents;

	public Rfq() {
	}

	public int getRfqId() {
		return this.rfqId;
	}

	public void setRfqId(int rfqId) {
		this.rfqId = rfqId;
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

	public OrgStatus getRfqStatus() {
		return this.rfqStatus;
	}

	public void setRfqStatus(OrgStatus rfqStatus) {
		this.rfqStatus = rfqStatus;
	}

	public Set<RFQDocument> getDocuments() {
		return documents;
	}

	public void setDocuments(Set<RFQDocument> documents) {
		this.documents = documents;
	}

	public PR getPrId() {
		return prId;
	}

	public void setPrId(PR prId) {
		this.prId = prId;
	}

	public List<Query> getQueryId() {
		return queryId;
	}

	public void setQueryId(List<Query> queryId) {
		this.queryId = queryId;
	}

}
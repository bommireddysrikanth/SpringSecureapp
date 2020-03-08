package com.portal.procucev.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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

	@OneToMany(targetEntity = Comment.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "rfq_comment_fk", referencedColumnName = "rfq_id", nullable = false)
	private List<Comment> rfqComment;

	@ManyToOne
	private PR prId;

	@OneToMany(targetEntity = Query.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "rfq_query_fk", referencedColumnName = "rfq_id", nullable = false)
	private List<Query> rfqQuery;

	@OneToMany(targetEntity = Quotation.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "rfq_quotation_fk", referencedColumnName = "rfq_id", nullable = false)
	private List<Quotation> rfqQuotation;

	// added

	@OneToMany(targetEntity = RfqItem.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "rfq_item_fk", referencedColumnName = "rfq_id", nullable = false)
	private List<RfqItem> rfqItem;

	// added

	@OneToMany(targetEntity = RfqVendor.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "rfq_vendor_fk", referencedColumnName = "rfq_id", nullable = false)
	private List<RfqVendor> rfqVendor;
	// added

	@OneToMany(targetEntity = RFQDocument.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "rfq_document_fk", referencedColumnName = "rfq_id", nullable = false)
	private List<RFQDocument> rfqDocument;

	@ManyToOne
	private OrgStatus rfqStatus;

	public Rfq() {
	}

	public int getRfqId() {
		return this.rfqId;
	}

	public void setRfqId(int rfqId) {
		this.rfqId = rfqId;
	}

	public List<Comment> getRfqComment() {
		return rfqComment;
	}

	public void setRfqComment(List<Comment> rfqComment) {
		this.rfqComment = rfqComment;
	}

	public List<RFQDocument> getRfqDocument() {
		return rfqDocument;
	}

	public void setRfqDocument(List<RFQDocument> rfqDocument) {
		this.rfqDocument = rfqDocument;
	}

	public PR getPrId() {
		return prId;
	}

	public void setPrId(PR prId) {
		this.prId = prId;
	}

	public List<Query> getRfqQuery() {
		return rfqQuery;
	}

	public void setRfqQuery(List<Query> rfqQuery) {
		this.rfqQuery = rfqQuery;
	}

	public List<Quotation> getRfqQuotation() {
		return rfqQuotation;
	}

	public void setRfqQuotation(List<Quotation> rfqQuotation) {
		this.rfqQuotation = rfqQuotation;
	}

	public List<RfqItem> getRfqItem() {
		return rfqItem;
	}

	public void setRfqItem(List<RfqItem> rfqItem) {
		this.rfqItem = rfqItem;
	}

	public List<RfqVendor> getRfqVendor() {
		return rfqVendor;
	}

	public void setRfqVendor(List<RfqVendor> rfqVendor) {
		this.rfqVendor = rfqVendor;
	}

	public OrgStatus getRfqStatus() {
		return rfqStatus;
	}

	public void setRfqStatus(OrgStatus rfqStatus) {
		this.rfqStatus = rfqStatus;
	}

}
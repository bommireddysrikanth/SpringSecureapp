package com.portal.procucev.model;

import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Type;

/**
 * The persistent class for the query database table.
 * 
 */
@Entity
@Table(name = "query")
@NamedQuery(name = "Query.findAll", query = "SELECT q FROM Query q")
public class Query extends Procucev {
	private static final long serialVersionUID = 1L;

	@Column(name = "query_duetime")
	private String queryDuetime;

	@Type(type = "text")
	private String raiseQuery;

	@ManyToOne
	private QueryType querytype;

	private String questions;
    
	@OneToMany(targetEntity = VendorprocucevDocument.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "vendor_pr_documents_fk", referencedColumnName = "id", nullable = false)
	private List<VendorprocucevDocument> vendorprocucevdocuments;
	
	
	@OneToMany(targetEntity = VendorprocucevDocument.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "Query_pr_documents_fk", referencedColumnName = "id", nullable = false)
	private List<ClinetprocucevDocument> clientprocucevdocuments;
	
	
	@ManyToOne
	private User user;

	public Rfq getRfq() {
		return rfq;
	}

	public void setRfq(Rfq rfq) {
		this.rfq = rfq;
	}

	public PR getPr() {
		return pr;
	}

	public void setPr(PR pr) {
		this.pr = pr;
	}

	public Quotation getQuotation() {
		return quotation;
	}

	public void setQuotation(Quotation quotation) {
		this.quotation = quotation;
	}

	@ManyToOne
	private Rfq rfq;

	@ManyToOne
	private PR pr;

	@ManyToOne
	private Quotation quotation;

	public String getRaiseQuery() {
		return raiseQuery;
	}

	public void setRaiseQuery(String raiseQuery) {
		this.raiseQuery = raiseQuery;
	}

	public Query() {
	}

	public String getQueryDuetime() {
		return this.queryDuetime;
	}

	public void setQueryDuetime(String queryDuetime) {
		this.queryDuetime = queryDuetime;
	}

	public String getQuestions() {
		return this.questions;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
	}

	public QueryType getQuerytype() {
		return querytype;
	}

	public void setQuerytype(QueryType querytype) {
		this.querytype = querytype;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
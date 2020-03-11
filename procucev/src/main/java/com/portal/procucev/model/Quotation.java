package com.portal.procucev.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

/**
 * The persistent class for the qoutation database table.
 * 
 */
@Entity
@Table(name = "quotation")
public class Quotation extends Procucev {
	private static final long serialVersionUID = 1L;

	private String amount;

	@ManyToOne
	private Organization orgId;

	@Type(type = "text")
	private String termsConditions;

	@Type(type = "text")
	private String remarks;

	private String fileName;
	@Lob
	private byte[] file;

	@Column(name = "quotation_iteam_id")
	private int quotationIteamId;

	@Column(name = "total_amount")
	private String totalAmount;

	private int version;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_quotation")
	private Set<QuotationItem> quotationItems;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public Organization getOrgId() {
		return orgId;
	}

	public void setOrgId(Organization orgId) {
		this.orgId = orgId;
	}

	public String getTermsConditions() {
		return termsConditions;
	}

	public void setTermsConditions(String termsConditions) {
		this.termsConditions = termsConditions;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Set<QuotationItem> getQuotationItems() {
		return quotationItems;
	}

	public void setQuotationItems(Set<QuotationItem> quotationItems) {
		this.quotationItems = quotationItems;
	}

	public Quotation() {
	}

	public String getAmount() {
		return this.amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public int getQuotationIteamId() {
		return this.quotationIteamId;
	}

	public void setQuotationIteamId(int quotationIteamId) {
		this.quotationIteamId = quotationIteamId;
	}

	public String getTotalAmount() {
		return this.totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}
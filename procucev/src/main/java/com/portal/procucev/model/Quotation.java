package com.portal.procucev.model;

import java.util.Set;

import javax.persistence.*;

/**
 * The persistent class for the qoutation database table.
 * 
 */
@Entity
@Table(name = "quotation")
public class Quotation extends Procucev {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "qoutation_id")
	private int qoutationId;

	private String amount;

	@Column(name = "org_id")
	private Organization orgId;

	@Column(name = "quotation_iteam_id")
	private int quotationIteamId;

	@Column(name = "total_amount")
	private String totalAmount;

	private int version;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_quotation")
	private Set<QuotationItem> quotationItems;

	public Quotation() {
	}

	public int getQoutationId() {
		return this.qoutationId;
	}

	public void setQoutationId(int qoutationId) {
		this.qoutationId = qoutationId;
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
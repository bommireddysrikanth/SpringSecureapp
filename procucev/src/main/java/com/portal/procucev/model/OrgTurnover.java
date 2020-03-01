package com.portal.procucev.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the org_turnover database table.
 * 
 */
@Entity
@Table(name = "org_turnover")
@NamedQuery(name = "OrgTurnover.findAll", query = "SELECT o FROM OrgTurnover o")
public class OrgTurnover extends Procucev {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "org_turnover_id")
	private int orgTurnoverId;

	private String amount;

	private int currency;

	// @Column(name = "currency_master_id")
	private CurrencyMaster currencyMasterId;

	// @Column(name = "currency_unit_id")
	private CurrencyUnit currencyUnitId;

	@ManyToOne
	@JoinColumn(name = "organization_id")
	private Organization organization;

	private int year;

	public OrgTurnover() {
	}

	public int getOrgTurnoverId() {
		return this.orgTurnoverId;
	}

	public void setOrgTurnoverId(int orgTurnoverId) {
		this.orgTurnoverId = orgTurnoverId;
	}

	public String getAmount() {
		return this.amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public int getCurrency() {
		return this.currency;
	}

	public void setCurrency(int currency) {
		this.currency = currency;
	}

	public CurrencyMaster getCurrencyMasterId() {
		return currencyMasterId;
	}

	public void setCurrencyMasterId(CurrencyMaster currencyMasterId) {
		this.currencyMasterId = currencyMasterId;
	}

	public CurrencyUnit getCurrencyUnitId() {
		return currencyUnitId;
	}

	public void setCurrencyUnitId(CurrencyUnit currencyUnitId) {
		this.currencyUnitId = currencyUnitId;
	}

	public Organization getOrganization() {
		return this.organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public int getYear() {
		return this.year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}
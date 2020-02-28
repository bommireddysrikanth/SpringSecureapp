package com.portal.procucev.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the org_turnover database table.
 * 
 */
@Entity
@Table(name="org_turnover")
@NamedQuery(name="OrgTurnover.findAll", query="SELECT o FROM OrgTurnover o")
public class OrgTurnover implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="org_turnover_id")
	private int orgTurnoverId;

	private String amount;

	private int currency;

	@Column(name="currency_master_id")
	private int currencyMasterId;

	@Column(name="currency_unit_id")
	private int currencyUnitId;

	private String organization;

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

	public int getCurrencyMasterId() {
		return this.currencyMasterId;
	}

	public void setCurrencyMasterId(int currencyMasterId) {
		this.currencyMasterId = currencyMasterId;
	}

	public int getCurrencyUnitId() {
		return this.currencyUnitId;
	}

	public void setCurrencyUnitId(int currencyUnitId) {
		this.currencyUnitId = currencyUnitId;
	}

	public String getOrganization() {
		return this.organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public int getYear() {
		return this.year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}
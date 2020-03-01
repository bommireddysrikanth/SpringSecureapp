package com.portal.procucev.model;

import javax.persistence.*;

/**
 * The persistent class for the currency_master database table.
 * 
 */
@Entity
@Table(name = "currency_master")
public class CurrencyMaster extends Procucev {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "currency_master_id")
	private int currencyMasterId;

	@Column(name = "currency_type")
	private String currencyType;

	public CurrencyMaster() {
	}

	public int getCurrencyMasterId() {
		return this.currencyMasterId;
	}

	public void setCurrencyMasterId(int currencyMasterId) {
		this.currencyMasterId = currencyMasterId;
	}

	public String getCurrencyType() {
		return this.currencyType;
	}

	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}

}
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

	@Column(name = "currency_type")
	private String currencyType;

	public CurrencyMaster() {
	}

	public String getCurrencyType() {
		return this.currencyType;
	}

	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}

}
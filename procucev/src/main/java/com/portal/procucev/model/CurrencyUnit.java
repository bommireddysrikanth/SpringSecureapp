package com.portal.procucev.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The persistent class for the currency_units database table.
 * 
 */
@Entity
@Table(name = "currency_units")
public class CurrencyUnit extends Procucev {
	private static final long serialVersionUID = 1L;

	@Column(name = "currency_units_type")
	private String currencyUnitsType;

	public CurrencyUnit() {
	}

	public String getCurrencyUnitsType() {
		return this.currencyUnitsType;
	}

	public void setCurrencyUnitsType(String currencyUnitsType) {
		this.currencyUnitsType = currencyUnitsType;
	}

}
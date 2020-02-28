package com.portal.procucev.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the currency_units database table.
 * 
 */
@Entity
@Table(name="currency_units")
@NamedQuery(name="CurrencyUnit.findAll", query="SELECT c FROM CurrencyUnit c")
public class CurrencyUnit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="currency_units_id")
	private int currencyUnitsId;

	@Column(name="currency_units_type")
	private String currencyUnitsType;

	public CurrencyUnit() {
	}

	public int getCurrencyUnitsId() {
		return this.currencyUnitsId;
	}

	public void setCurrencyUnitsId(int currencyUnitsId) {
		this.currencyUnitsId = currencyUnitsId;
	}

	public String getCurrencyUnitsType() {
		return this.currencyUnitsType;
	}

	public void setCurrencyUnitsType(String currencyUnitsType) {
		this.currencyUnitsType = currencyUnitsType;
	}

}
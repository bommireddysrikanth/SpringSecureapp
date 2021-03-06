package com.portal.procucev.model;

import javax.persistence.*;

/**
 * The persistent class for the rfq_items database table.
 * 
 */
@Entity
@Table(name = "rfq_items")
public class RfqItem extends Procucev {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Rfq rfq;

	private String description;
	private String brand;
	private long quantity;
	@Column(name = "unit_of_measures")
	private long unitofMeasures;
	private long unitprice;
	private long totalamount;

	
	
	
	public RfqItem() {
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public long getUnitofMeasures() {
		return unitofMeasures;
	}

	public void setUnitofMeasures(long unitofMeasures) {
		this.unitofMeasures = unitofMeasures;
	}

	public long getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(long unitprice) {
		this.unitprice = unitprice;
	}

	public long getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(long totalamount) {
		this.totalamount = totalamount;
	}

	public Rfq getRfq() {
		return rfq;
	}

	public void setRfq(Rfq rfq) {
		this.rfq = rfq;
	}

}
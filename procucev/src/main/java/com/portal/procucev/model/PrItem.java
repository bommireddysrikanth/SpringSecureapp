package com.portal.procucev.model;

import javax.persistence.*;

/**
 * The persistent class for the pr_items database table.
 * 
 */
@Entity
@Table(name = "pr_items")
@NamedQuery(name = "PrItem.findAll", query = "SELECT p FROM PrItem p")
public class PrItem extends Procucev {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pr_items_id")
	private int prItemsId;

	@Column(name = "pr_id")
	private PR prId;

	private String description;
	private String brand;
	private long quantity;
	@Column(name = "unit_of_measures")
	private long unitofMeasures;
	
	@ManyToOne
	private OrgStatus status;

	public int getPrItemsId() {
		return prItemsId;
	}

	public void setPrItemsId(int prItemsId) {
		this.prItemsId = prItemsId;
	}

	public PR getPrId() {
		return prId;
	}

	public void setPrId(PR prId) {
		this.prId = prId;
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

}

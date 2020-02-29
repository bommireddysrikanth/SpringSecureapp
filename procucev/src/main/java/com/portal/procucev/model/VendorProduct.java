package com.portal.procucev.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the vendor_product database table.
 * 
 */
@Entity
@Table(name = "vendor_product")
public class VendorProduct extends Procucev implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "vendor_product_id")
	private int vendorProductId;

	private String description;

	@Column(name = "hsn_code")
	private int hsnCode;

	public int getVendorProductId() {
		return this.vendorProductId;
	}

	public void setVendorProductId(int vendorProductId) {
		this.vendorProductId = vendorProductId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getHsnCode() {
		return this.hsnCode;
	}

	public void setHsnCode(int hsnCode) {
		this.hsnCode = hsnCode;
	}

}
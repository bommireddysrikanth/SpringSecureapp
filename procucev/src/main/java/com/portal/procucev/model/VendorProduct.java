package com.portal.procucev.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The persistent class for the vendor_product database table.
 * 
 */
@Entity
@Table(name = "vendor_product")
public class VendorProduct extends Procucev {

	private static final long serialVersionUID = 1L;

	private String description;

	@Column(name = "hsn_code")
	private int hsnCode;

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
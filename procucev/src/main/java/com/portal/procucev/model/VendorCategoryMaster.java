package com.portal.procucev.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the vendor_category_master database table.
 * 
 */
@Entity
@Table(name = "vendor_category_master")
public class VendorCategoryMaster extends Procucev implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "vendor_category_master_id")
	private int vendorCategoryMasterId;

	public VendorCategoryMaster() {
		super();
	}

	public int getVendorCategoryMasterId() {
		return this.vendorCategoryMasterId;
	}

	public void setVendorCategoryMasterId(int vendorCategoryMasterId) {
		this.vendorCategoryMasterId = vendorCategoryMasterId;
	}

}
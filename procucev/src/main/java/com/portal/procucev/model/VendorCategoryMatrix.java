package com.portal.procucev.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The persistent class for the vendor_category_matrix database table.
 * 
 */
@Entity
@Table(name = "vendor_category_matrix")
public class VendorCategoryMatrix extends Procucev {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	private VendorCategoryMaster vendorCategoryMasterId;

	@ManyToOne
	private Organization vendorOrgId;

	public VendorCategoryMatrix() {
		super();
	}

	public VendorCategoryMaster getVendorCategoryMasterId() {
		return vendorCategoryMasterId;
	}

	public void setVendorCategoryMasterId(VendorCategoryMaster vendorCategoryMasterId) {
		this.vendorCategoryMasterId = vendorCategoryMasterId;
	}

	public Organization getVendorOrgId() {
		return vendorOrgId;
	}

	public void setVendorOrgId(Organization vendorOrgId) {
		this.vendorOrgId = vendorOrgId;
	}

}
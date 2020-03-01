package com.portal.procucev.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "vendor_category_matrix_id")
	private int vendorCategoryMatrixId;

	@ManyToOne
	private VendorCategoryMaster vendorCategoryMasterId;

	@ManyToOne
	private Organization vendorOrgId;

	public VendorCategoryMatrix() {
		super();
	}

	public int getVendorCategoryMatrixId() {
		return this.vendorCategoryMatrixId;
	}

	public void setVendorCategoryMatrixId(int vendorCategoryMatrixId) {
		this.vendorCategoryMatrixId = vendorCategoryMatrixId;
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
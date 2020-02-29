package com.portal.procucev.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the vendor_category_matrix database table.
 * 
 */
@Entity
@Table(name = "vendor_category_matrix")
public class VendorCategoryMatrix extends Procucev implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "vendor_category_matrix_id")
	private int vendorCategoryMatrixId;

	@Column(name = "vendor_category_master_id")
	private int vendorCategoryMasterId;

	@Column(name = "vendor_org_id")
	private int vendorOrgId;

	public VendorCategoryMatrix() {
		super();
	}

	public int getVendorCategoryMatrixId() {
		return this.vendorCategoryMatrixId;
	}

	public void setVendorCategoryMatrixId(int vendorCategoryMatrixId) {
		this.vendorCategoryMatrixId = vendorCategoryMatrixId;
	}

	public int getVendorCategoryMasterId() {
		return this.vendorCategoryMasterId;
	}

	public void setVendorCategoryMasterId(int vendorCategoryMasterId) {
		this.vendorCategoryMasterId = vendorCategoryMasterId;
	}

	public int getVendorOrgId() {
		return this.vendorOrgId;
	}

	public void setVendorOrgId(int vendorOrgId) {
		this.vendorOrgId = vendorOrgId;
	}

}
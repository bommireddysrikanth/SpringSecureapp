package com.portal.procucev.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The persistent class for the vendor_category_master database table.
 * 
 */
@Entity
@Table(name = "vendor_category_master")
public class VendorCategoryMaster extends Procucev {

	private static final long serialVersionUID = 1L;

	public VendorCategoryMaster() {
		super();
	}

}
package com.portal.procucev.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the vendor_category_master database table.
 * 
 */
@Entity
@Table(name="vendor_category_master")
@NamedQuery(name="VendorCategoryMaster.findAll", query="SELECT v FROM VendorCategoryMaster v")
public class VendorCategoryMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="vendor_category_master_id")
	private int vendorCategoryMasterId;

	public VendorCategoryMaster() {
	}

	public int getVendorCategoryMasterId() {
		return this.vendorCategoryMasterId;
	}

	public void setVendorCategoryMasterId(int vendorCategoryMasterId) {
		this.vendorCategoryMasterId = vendorCategoryMasterId;
	}

}
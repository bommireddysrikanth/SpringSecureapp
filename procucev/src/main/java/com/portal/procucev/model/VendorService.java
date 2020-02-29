package com.portal.procucev.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the vendor_services database table.
 * 
 */
@Entity
@Table(name = "vendor_services")
public class VendorService extends Procucev implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "vendor_services_id")
	private int vendorServicesId;

	private String description;

	@Column(name = "major_catagory_id")
	private int majorCatagoryId;

	@Column(name = "minor_catagory_id")
	private String minorCatagoryId;

	private String other;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "sac_code")
	private int sacCode;

	@Column(name = "sub_catagory_id")
	private int subCatagoryId;

	public int getVendorServicesId() {
		return this.vendorServicesId;
	}

	public void setVendorServicesId(int vendorServicesId) {
		this.vendorServicesId = vendorServicesId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getMajorCatagoryId() {
		return this.majorCatagoryId;
	}

	public void setMajorCatagoryId(int majorCatagoryId) {
		this.majorCatagoryId = majorCatagoryId;
	}

	public String getMinorCatagoryId() {
		return this.minorCatagoryId;
	}

	public void setMinorCatagoryId(String minorCatagoryId) {
		this.minorCatagoryId = minorCatagoryId;
	}

	public String getOther() {
		return this.other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getSacCode() {
		return this.sacCode;
	}

	public void setSacCode(int sacCode) {
		this.sacCode = sacCode;
	}

	public int getSubCatagoryId() {
		return this.subCatagoryId;
	}

	public void setSubCatagoryId(int subCatagoryId) {
		this.subCatagoryId = subCatagoryId;
	}

}
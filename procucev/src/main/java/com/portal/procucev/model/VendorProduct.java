package com.portal.procucev.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the vendor_product database table.
 * 
 */
@Entity
@Table(name="vendor_product")
@NamedQuery(name="VendorProduct.findAll", query="SELECT v FROM VendorProduct v")
public class VendorProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="vendor_product_id")
	private int vendorProductId;

	private String description;

	@Column(name="hsn_code")
	private int hsnCode;

	@Column(name="organization_id")
	private int organizationId;

	public VendorProduct() {
	}

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

	public int getOrganizationId() {
		return this.organizationId;
	}

	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}

}
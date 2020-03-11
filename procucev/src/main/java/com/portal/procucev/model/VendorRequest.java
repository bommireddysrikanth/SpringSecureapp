package com.portal.procucev.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vendor_new_requests")
public class VendorRequest extends Procucev {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private VendorCategoryMaster vendorCategory;

	@ManyToOne
	private User requestedBy;

	private Date requestedTs;

	@ManyToOne
	private OrgStatus status;

	public VendorCategoryMaster getVendorCategory() {
		return vendorCategory;
	}

	public void setVendorCategory(VendorCategoryMaster vendorCategory) {
		this.vendorCategory = vendorCategory;
	}

	public User getRequestedBy() {
		return requestedBy;
	}

	public void setRequestedBy(User requestedBy) {
		this.requestedBy = requestedBy;
	}

	public Date getRequestedTs() {
		return requestedTs;
	}

	public void setRequestedTs(Date requestedTs) {
		this.requestedTs = requestedTs;
	}

	public OrgStatus getStatus() {
		return status;
	}

	public void setStatus(OrgStatus status) {
		this.status = status;
	}

}

package com.portal.procucev.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The persistent class for the org_status database table.
 * 
 */
@Entity
@Table(name = "org_status")
public class OrgStatus extends Procucev {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "org_status_id")
	private int orgStatusId;

	@ManyToOne
	private OrgType orgTypeId;

	private String status;

	public OrgStatus() {
		super();
	}

	public int getOrgStatusId() {
		return this.orgStatusId;
	}

	public void setOrgStatusId(int orgStatusId) {
		this.orgStatusId = orgStatusId;
	}

	public OrgType getOrgTypeId() {
		return this.orgTypeId;
	}

	public void setOrgTypeId(OrgType orgTypeId) {
		this.orgTypeId = orgTypeId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
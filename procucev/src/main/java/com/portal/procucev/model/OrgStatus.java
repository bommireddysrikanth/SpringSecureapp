package com.portal.procucev.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the org_status database table.
 * 
 */
@Entity
@Table(name = "org_status")
public class OrgStatus extends Procucev implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "org_status_id")
	private int orgStatusId;

	@Column(name = "org_type_id")
	private int orgTypeId;

	@Column(name = "status_type")
	private String statusType;

	public OrgStatus() {
		super();
	}

	public int getOrgStatusId() {
		return this.orgStatusId;
	}

	public void setOrgStatusId(int orgStatusId) {
		this.orgStatusId = orgStatusId;
	}

	public int getOrgTypeId() {
		return this.orgTypeId;
	}

	public void setOrgTypeId(int orgTypeId) {
		this.orgTypeId = orgTypeId;
	}

	public String getStatusType() {
		return this.statusType;
	}

	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}

}
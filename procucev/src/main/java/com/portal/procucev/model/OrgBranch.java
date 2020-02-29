package com.portal.procucev.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the org_branches database table.
 * 
 */
@Entity
@Table(name = "org_branches")
public class OrgBranch extends Procucev implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "org_branches_id")
	private int orgBranchesId;

	@Column(name = "bank_name")
	private String bankName;

	public OrgBranch() {
		super();
	}

	public int getOrgBranchesId() {
		return this.orgBranchesId;
	}

	public void setOrgBranchesId(int orgBranchesId) {
		this.orgBranchesId = orgBranchesId;
	}

	public String getBankName() {
		return this.bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

}
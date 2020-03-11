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
public class OrgBranch extends Procucev {

	private static final long serialVersionUID = 1L;

	@Column(name = "bank_name")
	private String bankName;

	public OrgBranch() {
		super();
	}

	public String getBankName() {
		return this.bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

}
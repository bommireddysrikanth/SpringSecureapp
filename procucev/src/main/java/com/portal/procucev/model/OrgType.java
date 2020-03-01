package com.portal.procucev.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the org_types database table.
 * 
 */
@Entity
@Table(name = "org_types")
public class OrgType extends Procucev {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "org_types_id")
	private int orgTypesId;

	private String description;

	@Column(name = "type_name")
	private String typeName;

	public OrgType() {
		super();
	}

	public int getOrgTypesId() {
		return this.orgTypesId;
	}

	public void setOrgTypesId(int orgTypesId) {
		this.orgTypesId = orgTypesId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

}
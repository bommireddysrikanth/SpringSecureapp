package com.portal.procucev.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the org_types database table.
 * 
 */
@Entity
@Table(name="org_types")
@NamedQuery(name="OrgType.findAll", query="SELECT o FROM OrgType o")
public class OrgType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="org_types_id")
	private int orgTypesId;

	private String description;

	@Column(name="type_name")
	private String typeName;

	//bi-directional many-to-one association to Organization
	@OneToMany(mappedBy="orgType")
	private List<Organization> organizations;

	public OrgType() {
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

	public List<Organization> getOrganizations() {
		return this.organizations;
	}

	public void setOrganizations(List<Organization> organizations) {
		this.organizations = organizations;
	}

	public Organization addOrganization(Organization organization) {
		getOrganizations().add(organization);
		organization.setOrgType(this);

		return organization;
	}

	public Organization removeOrganization(Organization organization) {
		getOrganizations().remove(organization);
		organization.setOrgType(null);

		return organization;
	}

}
package com.portal.procucev.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the org_status database table.
 * 
 */
@Entity
@Table(name="org_status")
@NamedQuery(name="OrgStatus.findAll", query="SELECT o FROM OrgStatus o")
public class OrgStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="org_status_id")
	private int orgStatusId;

	@Column(name="org_type_id")
	private int orgTypeId;

	@Column(name="status_type")
	private String statusType;

	//bi-directional many-to-one association to Organization
	@OneToMany(mappedBy="orgStatus")
	private List<Organization> organizations;

	public OrgStatus() {
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

	public List<Organization> getOrganizations() {
		return this.organizations;
	}

	public void setOrganizations(List<Organization> organizations) {
		this.organizations = organizations;
	}

	public Organization addOrganization(Organization organization) {
		getOrganizations().add(organization);
		organization.setOrgStatus(this);

		return organization;
	}

	public Organization removeOrganization(Organization organization) {
		getOrganizations().remove(organization);
		organization.setOrgStatus(null);

		return organization;
	}

}
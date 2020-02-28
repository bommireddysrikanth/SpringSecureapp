package com.portal.procucev.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the vendor_client_references database table.
 * 
 */
@Entity
@Table(name="vendor_client_references")
@NamedQuery(name="VendorClientReference.findAll", query="SELECT v FROM VendorClientReference v")
public class VendorClientReference implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="vendor_client_references_id")
	private int vendorClientReferencesId;

	@Column(name="business_provided_ts")
	private String businessProvidedTs;

	@Column(name="ciient_poc_email")
	private String ciientPocEmail;

	@Column(name="client_email")
	private String clientEmail;

	@Column(name="client_name")
	private String clientName;

	@Column(name="client_org_id")
	private String clientOrgId;

	@Column(name="client_poc")
	private String clientPoc;

	@Column(name="client_poc_name")
	private String clientPocName;

	@Column(name="client_poc_phonenumber")
	private String clientPocPhonenumber;

	@Lob
	private byte[] file;

	@Column(name="organization_id")
	private int organizationId;

	@Column(name="reference_ts")
	private String referenceTs;

	@Column(name="refernce_comments")
	private String refernceComments;

	public VendorClientReference() {
	}

	public int getVendorClientReferencesId() {
		return this.vendorClientReferencesId;
	}

	public void setVendorClientReferencesId(int vendorClientReferencesId) {
		this.vendorClientReferencesId = vendorClientReferencesId;
	}

	public String getBusinessProvidedTs() {
		return this.businessProvidedTs;
	}

	public void setBusinessProvidedTs(String businessProvidedTs) {
		this.businessProvidedTs = businessProvidedTs;
	}

	public String getCiientPocEmail() {
		return this.ciientPocEmail;
	}

	public void setCiientPocEmail(String ciientPocEmail) {
		this.ciientPocEmail = ciientPocEmail;
	}

	public String getClientEmail() {
		return this.clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}

	public String getClientName() {
		return this.clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientOrgId() {
		return this.clientOrgId;
	}

	public void setClientOrgId(String clientOrgId) {
		this.clientOrgId = clientOrgId;
	}

	public String getClientPoc() {
		return this.clientPoc;
	}

	public void setClientPoc(String clientPoc) {
		this.clientPoc = clientPoc;
	}

	public String getClientPocName() {
		return this.clientPocName;
	}

	public void setClientPocName(String clientPocName) {
		this.clientPocName = clientPocName;
	}

	public String getClientPocPhonenumber() {
		return this.clientPocPhonenumber;
	}

	public void setClientPocPhonenumber(String clientPocPhonenumber) {
		this.clientPocPhonenumber = clientPocPhonenumber;
	}

	public byte[] getFile() {
		return this.file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public int getOrganizationId() {
		return this.organizationId;
	}

	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}

	public String getReferenceTs() {
		return this.referenceTs;
	}

	public void setReferenceTs(String referenceTs) {
		this.referenceTs = referenceTs;
	}

	public String getRefernceComments() {
		return this.refernceComments;
	}

	public void setRefernceComments(String refernceComments) {
		this.refernceComments = refernceComments;
	}

}
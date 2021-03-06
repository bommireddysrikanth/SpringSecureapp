package com.portal.procucev.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * The persistent class for the vendor_client_references database table.
 * 
 */
@Entity
@Table(name = "vendor_client_references")
public class VendorClientReference extends Procucev {

	private static final long serialVersionUID = 1L;

	@Column(name = "business_provided_ts")
	private String businessProvidedTs;

	@Column(name = "client_poc_email")
	private String clientPocEmail;

	@Column(name = "client_email")
	private String clientEmail;

	@Column(name = "client_name")
	private String clientName;

	@Column(name = "client_org_id")
	private String clientOrgId;

	@Column(name = "client_poc")
	private String clientPoc;

	@Column(name = "client_poc_name")
	private String clientPocName;

	@Column(name = "client_poc_phonenumber")
	private String clientPocPhonenumber;

	@Column(name = "file_name")
	private String fileName;

	@Lob
	private byte[] file;

	@Column(name = "reference_ts")
	private String referenceTs;

	@Column(name = "refernce_comments")
	private String refernceComments;

	public VendorClientReference() {
		super();
	}

	public String getBusinessProvidedTs() {
		return this.businessProvidedTs;
	}

	public void setBusinessProvidedTs(String businessProvidedTs) {
		this.businessProvidedTs = businessProvidedTs;
	}

	public String getClientPocEmail() {
		return this.clientPocEmail;
	}

	public void setClientPocEmail(String ciientPocEmail) {
		this.clientPocEmail = ciientPocEmail;
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

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
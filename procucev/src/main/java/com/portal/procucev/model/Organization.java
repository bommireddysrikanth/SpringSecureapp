package com.portal.procucev.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

/**
 * The persistent class for the organization database table.
 * 
 */
@Entity
@Table(name = "organization")
public class Organization extends Procucev {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "organization_id")
	private int organizationId;

	@Column(name = "GSTIN")
	private String gstin;

	@Transient
	@Lob
	private MultipartFile file;

	@Lob
	private byte[] files;

	@Column(name = "organization_name")
	private String organizationName;

	@Column(name = "organization_phonenumber")
	private String organizationPhonenumber;

	private String organizationcol;

	@Column(name = "PAN")
	private String pan;

	// bi-directional many-to-one association to OrgBankDetail
	@OneToMany(targetEntity = OrgBankDetail.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "org_bank_details_fk", referencedColumnName = "organization_id", nullable = false)
	private List<OrgBankDetail> orgBankDetails;

	@OneToMany(targetEntity = VendorProduct.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "vendor_product_fk", referencedColumnName = "organization_id", nullable = false)
	private List<VendorProduct> vendorProduct;

	@OneToMany(targetEntity = OrgBranch.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "org_branches_fk", referencedColumnName = "organization_id", nullable = false)
	private List<OrgBranch> orgBranches;

	@OneToMany(targetEntity = Poc.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "poc_fk", referencedColumnName = "organization_id", nullable = false)
	private List<Poc> poc;

	@OneToMany(targetEntity = VendorClientReference.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "vendor_client_references_fk", referencedColumnName = "organization_id", nullable = false)
	private List<VendorClientReference> clientReference;

	@OneToMany(targetEntity = VendorCertificate.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "vendor_certificates_fk", referencedColumnName = "organization_id", nullable = false)
	private List<VendorCertificate> certificates;

	@OneToMany(targetEntity = VendorDocument.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "vendor_documents_fk", referencedColumnName = "organization_id", nullable = false)
	private List<VendorDocument> documents;

	@OneToMany(targetEntity = Address.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "address_fk", referencedColumnName = "organization_id", nullable = false)
	private List<Address> address;

	@ManyToOne
	@JoinColumn(name = "org_status_id")
	private OrgStatus orgStatus;

	@ManyToOne
	@JoinColumn(name = "org_types_id", nullable = false)
	private OrgType orgType;

	@OneToMany(targetEntity = ClientVerticals.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "client_verticals_fk", referencedColumnName = "organization_id", nullable = false)
	private List<ClientVerticals> clientVerticals;

	@OneToMany(targetEntity = ClientCategories.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "client_categories_fk", referencedColumnName = "organization_id", nullable = false)
	private List<ClientCategories> clientCategories;

	@OneToMany(targetEntity = ClientDocuments.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "client_documents_fk", referencedColumnName = "organization_id", nullable = false)
	private List<ClientDocuments> clientDocuments;

	@Column(name = "license_valid_date")
	private Date licenseValidDate;

	public int getOrganizationId() {
		return this.organizationId;
	}

	public Organization() {
		super();
	}

	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}

	public String getGstin() {
		return this.gstin;
	}

	public void setGstin(String gstin) {
		this.gstin = gstin;
	}

	public String getOrganizationName() {
		return this.organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getOrganizationPhonenumber() {
		return this.organizationPhonenumber;
	}

	public void setOrganizationPhonenumber(String organizationPhonenumber) {
		this.organizationPhonenumber = organizationPhonenumber;
	}

	public String getOrganizationcol() {
		return this.organizationcol;
	}

	public void setOrganizationcol(String organizationcol) {
		this.organizationcol = organizationcol;
	}

	public String getPan() {
		return this.pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public List<OrgBankDetail> getOrgBankDetails() {
		return this.orgBankDetails;
	}

	public void setOrgBankDetails(List<OrgBankDetail> orgBankDetails) {
		this.orgBankDetails = orgBankDetails;
	}

	public List<OrgBranch> getOrgBranches() {
		return this.orgBranches;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public OrgStatus getOrgStatus() {
		return orgStatus;
	}

	public void setOrgStatus(OrgStatus orgStatus) {
		this.orgStatus = orgStatus;
	}

	public OrgType getOrgType() {
		return orgType;
	}

	public void setOrgType(OrgType orgType) {
		this.orgType = orgType;
	}

	public List<Poc> getPoc() {
		return poc;
	}

	public void setPoc(List<Poc> poc) {
		this.poc = poc;
	}

	public void setOrgBranches(List<OrgBranch> orgBranches) {
		this.orgBranches = orgBranches;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public List<VendorProduct> getVendorProduct() {
		return vendorProduct;
	}

	public void setVendorProduct(List<VendorProduct> vendorProduct) {
		this.vendorProduct = vendorProduct;
	}

	public List<VendorClientReference> getClientReference() {
		return clientReference;
	}

	public void setClientReference(List<VendorClientReference> clientReference) {
		this.clientReference = clientReference;
	}

	public List<VendorCertificate> getCertificates() {
		return certificates;
	}

	public void setCertificates(List<VendorCertificate> certificates) {
		this.certificates = certificates;
	}

	public List<VendorDocument> getDocuments() {
		return documents;
	}

	public void setDocuments(List<VendorDocument> documents) {
		this.documents = documents;
	}

	public byte[] getFiles() {
		return files;
	}

	public void setFiles(byte[] files) {
		this.files = files;
	}

	public List<ClientVerticals> getClientVerticals() {
		return clientVerticals;
	}

	public void setClientVerticals(List<ClientVerticals> clientVerticals) {
		this.clientVerticals = clientVerticals;
	}

	public List<ClientCategories> getClientCategories() {
		return clientCategories;
	}

	public void setClientCategories(List<ClientCategories> clientCategories) {
		this.clientCategories = clientCategories;
	}

	public List<ClientDocuments> getClientDocuments() {
		return clientDocuments;
	}

	public void setClientDocuments(List<ClientDocuments> clientDocuments) {
		this.clientDocuments = clientDocuments;
	}

	public Date getLicenseValidDate() {
		return licenseValidDate;
	}

	public void setLicenseValidDate(Date licenseValidDate) {
		this.licenseValidDate = licenseValidDate;
	}

}
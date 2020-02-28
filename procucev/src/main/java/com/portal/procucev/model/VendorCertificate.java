package com.portal.procucev.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the vendor_certificates database table.
 * 
 */
@Entity
@Table(name="vendor_certificates")
@NamedQuery(name="VendorCertificate.findAll", query="SELECT v FROM VendorCertificate v")
public class VendorCertificate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="vendor_certificates_id")
	private int vendorCertificatesId;

	@Column(name="certificate_type")
	private String certificateType;

	@Lob
	private byte[] file;

	@Column(name="organization_id")
	private int organizationId;

	public VendorCertificate() {
	}

	public int getVendorCertificatesId() {
		return this.vendorCertificatesId;
	}

	public void setVendorCertificatesId(int vendorCertificatesId) {
		this.vendorCertificatesId = vendorCertificatesId;
	}

	public String getCertificateType() {
		return this.certificateType;
	}

	public void setCertificateType(String certificateType) {
		this.certificateType = certificateType;
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

}
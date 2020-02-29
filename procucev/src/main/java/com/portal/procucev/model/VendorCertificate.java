package com.portal.procucev.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * The persistent class for the vendor_certificates database table.
 * 
 */
@Entity
@Table(name = "vendor_certificates")
public class VendorCertificate extends Procucev implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "vendor_certificates_id")
	private int vendorCertificatesId;

	@Column(name = "certificate_type")
	private String certificateType;

	@Column(name = "file_name")
	private String fileName;

	@Lob
	private byte[] file;

	public VendorCertificate() {
		super();
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

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
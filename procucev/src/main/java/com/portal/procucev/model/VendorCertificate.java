package com.portal.procucev.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * The persistent class for the vendor_certificates database table.
 * 
 */
@Entity
@Table(name = "vendor_certificates")
public class VendorCertificate extends Procucev {

	private static final long serialVersionUID = 1L;

	@Column(name = "certificate_type")
	private String certificateType;

	@Column(name = "file_name")
	private String fileName;

	@Lob
	private byte[] file;

	public VendorCertificate() {
		super();
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
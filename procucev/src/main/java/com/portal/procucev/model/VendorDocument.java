package com.portal.procucev.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * The persistent class for the vendor_documents database table.
 * 
 */
@Entity
@Table(name = "vendor_documents")
public class VendorDocument extends Procucev {

	private static final long serialVersionUID = 1L;

	@Column(name = "file_name")
	private String fileName;

	@Lob
	@Column(name = "vendor_document")
	private byte[] file;

	@Column(name = "vendor_document_types")
	private String vendorDocumentTypes;

	public String getVendorDocumentTypes() {
		return this.vendorDocumentTypes;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public void setVendorDocumentTypes(String vendorDocumentTypes) {
		this.vendorDocumentTypes = vendorDocumentTypes;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
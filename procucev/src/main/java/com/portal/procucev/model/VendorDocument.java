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
 * The persistent class for the vendor_documents database table.
 * 
 */
@Entity
@Table(name = "vendor_documents")
public class VendorDocument extends Procucev implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "vendor_documents_id")
	private int vendorDocumentsId;

	@Column(name = "file_name")
	private String fileName;

	@Lob
	@Column(name = "vendor_document")
	private byte[] file;

	@Column(name = "vendor_document_types")
	private String vendorDocumentTypes;

	public int getVendorDocumentsId() {
		return this.vendorDocumentsId;
	}

	public void setVendorDocumentsId(int vendorDocumentsId) {
		this.vendorDocumentsId = vendorDocumentsId;
	}

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
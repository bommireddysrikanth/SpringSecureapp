package com.portal.procucev.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the vendor_documents database table.
 * 
 */
@Entity
@Table(name="vendor_documents")
@NamedQuery(name="VendorDocument.findAll", query="SELECT v FROM VendorDocument v")
public class VendorDocument implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="vendor_documents_id")
	private int vendorDocumentsId;

	@Column(name="organization_id")
	private int organizationId;

	@Lob
	@Column(name="vendor_document")
	private byte[] vendorDocument;

	@Column(name="vendor_document_types")
	private String vendorDocumentTypes;

	public VendorDocument() {
	}

	public int getVendorDocumentsId() {
		return this.vendorDocumentsId;
	}

	public void setVendorDocumentsId(int vendorDocumentsId) {
		this.vendorDocumentsId = vendorDocumentsId;
	}

	public int getOrganizationId() {
		return this.organizationId;
	}

	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}

	public byte[] getVendorDocument() {
		return this.vendorDocument;
	}

	public void setVendorDocument(byte[] vendorDocument) {
		this.vendorDocument = vendorDocument;
	}

	public String getVendorDocumentTypes() {
		return this.vendorDocumentTypes;
	}

	public void setVendorDocumentTypes(String vendorDocumentTypes) {
		this.vendorDocumentTypes = vendorDocumentTypes;
	}

}
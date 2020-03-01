package com.portal.procucev.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "rfq_documents")
public class RFQDocument extends Procucev {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rfq_document_id")
	private int rfqDocumentId;

	@Lob
	@Column(name = "file_details")
	private String fileDetails;

	private Integer version;

	public int getRfqDocumentId() {
		return rfqDocumentId;
	}

	public void setRfqDocumentId(int rfqDocumentId) {
		this.rfqDocumentId = rfqDocumentId;
	}

	public String getFileDetails() {
		return fileDetails;
	}

	public void setFileDetails(String fileDetails) {
		this.fileDetails = fileDetails;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}

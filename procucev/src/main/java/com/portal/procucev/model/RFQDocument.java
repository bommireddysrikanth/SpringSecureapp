package com.portal.procucev.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "rfq_documents")
public class RFQDocument extends Procucev {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Lob
	@Column(name = "file_details")
	private String fileDetails;

	private String fileName;

	@Lob
	private byte[] file;

	@Column(name = "rfq_document_fk", insertable = false, updatable = false, nullable = false)
	private int rfqFk;

	private Integer version;

	public int getRfqFk() {
		return rfqFk;
	}

	public void setRfqFk(int rfqFk) {
		this.rfqFk = rfqFk;
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

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

}

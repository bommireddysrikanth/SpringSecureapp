package com.portal.procucev.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@MappedSuperclass
public class Procucev implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "last_modified_by")
	private String lastModifiedBy;

	@Column(name = "created_ts")
	@CreationTimestamp
	private Date createdTS;

	@Column(name = "last_modified_ts")
	@UpdateTimestamp
	private Date lastModifiedTS;

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Date getCreatedTS() {
		return createdTS;
	}

	public void setCreatedTS(Date createdTS) {
		this.createdTS = createdTS;
	}

	public Date getLastModifiedTS() {
		return lastModifiedTS;
	}

	public void setLastModifiedTS(Date lastModifiedTS) {
		this.lastModifiedTS = lastModifiedTS;
	}

	public Procucev(String createdBy, String lastModifiedBy, Date createdTS, Date lastModifiedTS) {
		super();
		this.createdBy = createdBy;
		this.lastModifiedBy = lastModifiedBy;
		this.createdTS = createdTS;
		this.lastModifiedTS = lastModifiedTS;
	}

}

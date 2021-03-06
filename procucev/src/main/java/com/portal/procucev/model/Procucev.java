package com.portal.procucev.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@MappedSuperclass
public class Procucev implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

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

	public Procucev() {
		super();
	}
	


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

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	@Override
	public String toString() {
		return "Procucev [id=" + id + ", createdBy=" + createdBy + ", lastModifiedBy=" + lastModifiedBy + ", createdTS="
				+ createdTS + ", lastModifiedTS=" + lastModifiedTS + ", getCreatedBy()=" + getCreatedBy()
				+ ", getLastModifiedBy()=" + getLastModifiedBy() + ", getCreatedTS()=" + getCreatedTS()
				+ ", getLastModifiedTS()=" + getLastModifiedTS() + ", getId()=" + getId() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}

package com.portal.procucev.model;

import javax.persistence.*;

/**
 * The persistent class for the comments database table.
 * 
 */
@Entity
@Table(name = "comments")
public class Comment extends Procucev {
	private static final long serialVersionUID = 1L;

	private String description;

	@ManyToOne
	private Rfq rfq;

	public Comment() {
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Rfq getRfq() {
		return rfq;
	}

	public void setRfq(Rfq rfq) {
		this.rfq = rfq;
	}

}
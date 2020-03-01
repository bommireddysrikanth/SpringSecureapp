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

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "comments_id")
	private int commentsId;

	private String description;

	@ManyToOne
	private Rfq rfq;

	public Comment() {
	}

	public int getCommentsId() {
		return this.commentsId;
	}

	public void setCommentsId(int commentsId) {
		this.commentsId = commentsId;
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
package com.portal.procucev.model;

import javax.persistence.*;

import com.portal.procucev.model.Query;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the pr database table.
 * 
 */
@Entity
@Table(name = "pr")
@NamedQuery(name = "Pr.findAll", query = "SELECT p FROM Pr p")
public class Pr extends Procucev {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pr_id")
	private int prId;

	@ManyToOne
	private User approverId;

	@ManyToOne
	private OrgStatus status;

	@Column(name = "requested_ts")
	private Date requestedTS;

	@Column(name = "due_date")
	private Date dueDate;

	private String priority;
	
	@ManyToMany
	private List<Query> querys;

	public Pr() {
	}

	public int getPrId() {
		return this.prId;
	}

	public void setPrId(int prId) {
		this.prId = prId;
	}

	public User getApproverId() {
		return approverId;
	}

	public void setApproverId(User approverId) {
		this.approverId = approverId;
	}

	public OrgStatus getStatus() {
		return status;
	}

	public void setStatus(OrgStatus status) {
		this.status = status;
	}

	public Date getRequestedTS() {
		return requestedTS;
	}

	public void setRequestedTS(Date requestedTS) {
		this.requestedTS = requestedTS;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

}
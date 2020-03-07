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
public class PR extends Procucev {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pr_id")
	private int prId;

	@ManyToOne
	private Organization org;

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
	
	@ManyToMany
	private List<PrItem> pritems;

	public PR() {
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

	public Organization getOrg() {
		return org;
	}

	public void setOrg(Organization org) {
		this.org = org;
	}

	public List<Query> getQuerys() {
		return querys;
	}

	public void setQuerys(List<Query> querys) {
		this.querys = querys;
	}

	@Override
	public String toString() {
		return "PR [prId=" + prId + ", org=" + org + ", approverId=" + approverId + ", status=" + status
				+ ", requestedTS=" + requestedTS + ", dueDate=" + dueDate + ", priority=" + priority + ", querys="
				+ querys + "]";
	}

}
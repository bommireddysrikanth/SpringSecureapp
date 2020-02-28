package com.portal.procucev.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the pr database table.
 * 
 */
@Entity
@Table(name="pr")
@NamedQuery(name="Pr.findAll", query="SELECT p FROM Pr p")
public class Pr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pr_id")
	private int prId;

	@Column(name="approver_id")
	private int approverId;

	@Column(name="pr_client_status_id")
	private int prClientStatusId;

	@Column(name="pr_procurev_status_id")
	private String prProcurevStatusId;

	@Column(name="pr_procuseru_status_id")
	private int prProcuseruStatusId;

	private Timestamp requested_TS;

	@Column(name="user_id")
	private int userId;

	public Pr() {
	}

	public int getPrId() {
		return this.prId;
	}

	public void setPrId(int prId) {
		this.prId = prId;
	}

	public int getApproverId() {
		return this.approverId;
	}

	public void setApproverId(int approverId) {
		this.approverId = approverId;
	}

	public int getPrClientStatusId() {
		return this.prClientStatusId;
	}

	public void setPrClientStatusId(int prClientStatusId) {
		this.prClientStatusId = prClientStatusId;
	}

	public String getPrProcurevStatusId() {
		return this.prProcurevStatusId;
	}

	public void setPrProcurevStatusId(String prProcurevStatusId) {
		this.prProcurevStatusId = prProcurevStatusId;
	}

	public int getPrProcuseruStatusId() {
		return this.prProcuseruStatusId;
	}

	public void setPrProcuseruStatusId(int prProcuseruStatusId) {
		this.prProcuseruStatusId = prProcuseruStatusId;
	}

	public Timestamp getRequested_TS() {
		return this.requested_TS;
	}

	public void setRequested_TS(Timestamp requested_TS) {
		this.requested_TS = requested_TS;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
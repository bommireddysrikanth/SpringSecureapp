package com.portal.procucev.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the query database table.
 * 
 */
@Entity
@Table(name="query")
@NamedQuery(name="Query.findAll", query="SELECT q FROM Query q")
public class Query implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="query_id")
	private int queryId;

	@Column(name="query_by")
	private String queryBy;

	@Column(name="query_duetime")
	private String queryDuetime;

	@Column(name="query_type_id")
	private int queryTypeId;

	private String questions;

	@Column(name="user_id")
	private int userId;

	public Query() {
	}

	public int getQueryId() {
		return this.queryId;
	}

	public void setQueryId(int queryId) {
		this.queryId = queryId;
	}

	public String getQueryBy() {
		return this.queryBy;
	}

	public void setQueryBy(String queryBy) {
		this.queryBy = queryBy;
	}

	public String getQueryDuetime() {
		return this.queryDuetime;
	}

	public void setQueryDuetime(String queryDuetime) {
		this.queryDuetime = queryDuetime;
	}

	public int getQueryTypeId() {
		return this.queryTypeId;
	}

	public void setQueryTypeId(int queryTypeId) {
		this.queryTypeId = queryTypeId;
	}

	public String getQuestions() {
		return this.questions;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
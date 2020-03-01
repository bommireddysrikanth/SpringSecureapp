package com.portal.procucev.model;

import javax.persistence.*;

/**
 * The persistent class for the query database table.
 * 
 */
@Entity
@Table(name = "query")
@NamedQuery(name = "Query.findAll", query = "SELECT q FROM Query q")
public class Query extends Procucev {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "query_id")
	private int queryId;

	@Column(name = "query_duetime")
	private String queryDuetime;

	@ManyToOne
	// @Column(name = "query_type_id")
	private QueryType querytype;

	private String questions;

	// @ManyToOne
	@Column(name = "user_id")
	private User user;

	public Query() {
	}

	public int getQueryId() {
		return this.queryId;
	}

	public void setQueryId(int queryId) {
		this.queryId = queryId;
	}

	public String getQueryDuetime() {
		return this.queryDuetime;
	}

	public void setQueryDuetime(String queryDuetime) {
		this.queryDuetime = queryDuetime;
	}

	public String getQuestions() {
		return this.questions;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
	}

	public QueryType getQuerytype() {
		return querytype;
	}

	public void setQuerytype(QueryType querytype) {
		this.querytype = querytype;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
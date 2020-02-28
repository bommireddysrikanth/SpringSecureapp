package com.portal.procucev.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the query_type database table.
 * 
 */
@Entity
@Table(name="query_type")
@NamedQuery(name="QueryType.findAll", query="SELECT q FROM QueryType q")
public class QueryType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="query_type_id")
	private int queryTypeId;

	@Column(name="query_role_todo")
	private String queryRoleTodo;

	@Column(name="query_type")
	private String queryType;

	public QueryType() {
	}

	public int getQueryTypeId() {
		return this.queryTypeId;
	}

	public void setQueryTypeId(int queryTypeId) {
		this.queryTypeId = queryTypeId;
	}

	public String getQueryRoleTodo() {
		return this.queryRoleTodo;
	}

	public void setQueryRoleTodo(String queryRoleTodo) {
		this.queryRoleTodo = queryRoleTodo;
	}

	public String getQueryType() {
		return this.queryType;
	}

	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}

}
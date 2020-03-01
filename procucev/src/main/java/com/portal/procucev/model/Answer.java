package com.portal.procucev.model;

import javax.persistence.*;

/**
 * The persistent class for the answers database table.
 * 
 */
@Entity
@Table(name = "answers")
@NamedQuery(name = "Answer.findAll", query = "SELECT a FROM Answer a")
public class Answer extends Procucev {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "answers_id")
	private int answersId;

	private String answer;

	@Column(name = "answers_by")
	private String answersBy;

	@ManyToOne
	private Query query;

	public Answer() {
	}

	public int getAnswersId() {
		return this.answersId;
	}

	public void setAnswersId(int answersId) {
		this.answersId = answersId;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getAnswersBy() {
		return this.answersBy;
	}

	public void setAnswersBy(String answersBy) {
		this.answersBy = answersBy;
	}

	public Query getQuery() {
		return query;
	}

	public void setQuery(Query query) {
		this.query = query;
	}

}
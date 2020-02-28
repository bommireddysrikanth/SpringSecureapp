package com.portal.procucev.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the qoutation_items database table.
 * 
 */
@Entity
@Table(name="qoutation_items")
@NamedQuery(name="QoutationItem.findAll", query="SELECT q FROM QoutationItem q")
public class QoutationItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="qoutation_items_id")
	private int qoutationItemsId;

	private String description;

	@Column(name="qoutation_id")
	private int qoutationId;

	@Column(name="qoutation_items")
	private String qoutationItems;

	private String quantity;

	public QoutationItem() {
	}

	public int getQoutationItemsId() {
		return this.qoutationItemsId;
	}

	public void setQoutationItemsId(int qoutationItemsId) {
		this.qoutationItemsId = qoutationItemsId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQoutationId() {
		return this.qoutationId;
	}

	public void setQoutationId(int qoutationId) {
		this.qoutationId = qoutationId;
	}

	public String getQoutationItems() {
		return this.qoutationItems;
	}

	public void setQoutationItems(String qoutationItems) {
		this.qoutationItems = qoutationItems;
	}

	public String getQuantity() {
		return this.quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

}
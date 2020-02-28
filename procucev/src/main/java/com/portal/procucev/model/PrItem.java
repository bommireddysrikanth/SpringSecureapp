package com.portal.procucev.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pr_items database table.
 * 
 */
@Entity
@Table(name="pr_items")
@NamedQuery(name="PrItem.findAll", query="SELECT p FROM PrItem p")
public class PrItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pr_items_id")
	private int prItemsId;

	private String code;

	private String description;

	@Column(name="item_catagory_id")
	private int itemCatagoryId;

	@Column(name="pr_id")
	private int prId;

	@Column(name="required_quantity")
	private String requiredQuantity;

	private String title;

	public PrItem() {
	}

	public int getPrItemsId() {
		return this.prItemsId;
	}

	public void setPrItemsId(int prItemsId) {
		this.prItemsId = prItemsId;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getItemCatagoryId() {
		return this.itemCatagoryId;
	}

	public void setItemCatagoryId(int itemCatagoryId) {
		this.itemCatagoryId = itemCatagoryId;
	}

	public int getPrId() {
		return this.prId;
	}

	public void setPrId(int prId) {
		this.prId = prId;
	}

	public String getRequiredQuantity() {
		return this.requiredQuantity;
	}

	public void setRequiredQuantity(String requiredQuantity) {
		this.requiredQuantity = requiredQuantity;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
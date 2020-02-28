package com.portal.procucev.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the rfq_items database table.
 * 
 */
@Entity
@Table(name="rfq_items")
@NamedQuery(name="RfqItem.findAll", query="SELECT r FROM RfqItem r")
public class RfqItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rfq_items_id")
	private int rfqItemsId;

	@Column(name="item_id")
	private int itemId;

	@Column(name="rfq_id")
	private int rfqId;

	public RfqItem() {
	}

	public int getRfqItemsId() {
		return this.rfqItemsId;
	}

	public void setRfqItemsId(int rfqItemsId) {
		this.rfqItemsId = rfqItemsId;
	}

	public int getItemId() {
		return this.itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getRfqId() {
		return this.rfqId;
	}

	public void setRfqId(int rfqId) {
		this.rfqId = rfqId;
	}

}
package com.portal.procucev.dto;

public class VendorDetailsByStatus {

	private String vendorName;
	private int rfqSent;
	private int quotationsRecieved;
	private int queriesAnswered;
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public int getRfqSent() {
		return rfqSent;
	}
	public void setRfqSent(int rfqSent) {
		this.rfqSent = rfqSent;
	}
	public int getQuotationsRecieved() {
		return quotationsRecieved;
	}
	public void setQuotationsRecieved(int quotationsRecieved) {
		this.quotationsRecieved = quotationsRecieved;
	}
	public int getQueriesAnswered() {
		return queriesAnswered;
	}
	public void setQueriesAnswered(int queriesAnswered) {
		this.queriesAnswered = queriesAnswered;
	}
	
	
	
}

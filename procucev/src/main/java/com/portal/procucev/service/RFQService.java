package com.portal.procucev.service;

import java.util.List;

import com.portal.procucev.model.Quotation;
import com.portal.procucev.model.Rfq;

public interface RFQService {
	/**
	 * Method to create a rfq
	 * 
	 * @param inputRfqRequest
	 * @return
	 */
	boolean rfqCreation(Rfq inputRfqRequest);

	/**
	 * Method to fetch the rfq details by an ID
	 * 
	 * @param id
	 * @return
	 */
	List<Rfq> fetchRfqById(int id);

	/**
	 * Method to return all the RFQ's
	 * 
	 * @return
	 */
	List<Rfq> fetchRfq();

	/**
	 * Method to return rfq information based on ID or NAME or TIME
	 * 
	 * @param id
	 * @param name
	 * @param time
	 * @return
	 */
	List<Rfq> rfqSearch(Integer id, String name, String time);

	/**
	 * Method to upload a quote for a RFQ
	 * 
	 * @param inputRfqRequest
	 * @return
	 */
	boolean uploadQuote(Rfq inputRfqRequest);

	/**
	 * Method to fetch all the Quotes
	 * 
	 * @return
	 */

	List<Quotation> fetchQuotes();

	/**
	 * Method to create a query for a RFQ
	 * 
	 * @param inputRfqRequest
	 * @return
	 */
	boolean raiseQuery(Rfq inputRfqRequest);

}

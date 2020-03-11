package com.portal.procucev.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.portal.procucev.model.Quotation;
import com.portal.procucev.model.Rfq;

/**
 * 
 * @author venu gopal
 *
 */
public interface RFQService {
	/**
	 * Function call to create a rfq
	 * 
	 * @param inputRfqRequest
	 * @return
	 */
	boolean rfqCreation(Rfq inputRfqRequest);

	/**
	 * Function call to fetch the rfq details by an ID
	 * 
	 * @param rfq
	 * @return
	 */
	List<Rfq> fetchRfqById(Rfq rfq);

	/**
	 * Function call to return all the RFQ's
	 * 
	 * @return
	 */
	List<Rfq> fetchRfq();

	/**
	 * Function call to return rfq information based on ID or NAME or TIME
	 * 
	 * @param id
	 * @param name
	 * @param time
	 * @return
	 */
	List<Rfq> rfqSearch(Integer id, String name, String time);

	/**
	 * Function call to upload a quote for a RFQ
	 * 
	 * @param inputRfqRequest
	 * @return
	 */
	boolean uploadQuote(Rfq inputRfqRequest);

	/**
	 * Function call to fetch all the Quotes
	 * 
	 * @return
	 */

	List<Quotation> fetchQuotes();

	/**
	 * Function call to create a query for a RFQ
	 * 
	 * @param inputRfqRequest
	 * @return
	 */
	boolean raiseQuery(Rfq inputRfqRequest);

	/**
	 * Function call to delete an RFQ
	 * 
	 * @param rfq
	 * 
	 * @return
	 */
	boolean deleteRfq(List<Rfq> rfq);

	/**
	 * Function call to read an xl file
	 * 
	 * @param file
	 */
	void xlRead(MultipartFile file);

}

package com.portal.procucev.service;

import java.util.List;

import com.portal.procucev.model.PR;

/**
 * 
 * @author Chiru
 *
 */
public interface PRServiceManager {

	/**
	 * Method used to save PR object 
	 * 
	 * @param probject
	 * @return
	 */
	PR savePR(PR probject);

	/**
	 * Method to get all PR's created
	 * 
	 * @return
	 */
	List<PR> getAllPR();
	
	/**
	 * 
	 * Method to get all PR's by Client/Org 
	 * 
	 * @param prObject
	 * @return
	 */
	List<PR> getAllPRByClient(PR prObject);
	
	/**
	 * Get PR details by PR ID
	 * @param pr
	 * @return
	 */
	PR getPRbyID(PR pr);
}

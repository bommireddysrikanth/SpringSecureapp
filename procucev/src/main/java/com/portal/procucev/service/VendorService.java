package com.portal.procucev.service;

import java.util.List;

import com.portal.procucev.model.Organization;

public interface VendorService {
	/**
	 * Method to create a new user
	 * 
	 * @param newVendor
	 * @return
	 */
	boolean userRegistration(Organization newVendor);

	/**
	 * Method to fetch all the vendor information
	 * 
	 * @return
	 */
	List<Organization> fetchAllVendors();

}

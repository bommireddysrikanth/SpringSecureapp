package com.portal.procucev.service;

import java.util.List;

import com.portal.procucev.model.Organization;

/**
 * 
 * @author venu gade
 *
 */
public interface VendorService {
	/**
	 * Function call to create a new user
	 * 
	 * @param newVendor
	 * @return
	 */
	boolean userRegistration(Organization newVendor);

	/**
	 * Function call to fetch all the vendor information
	 * 
	 * @return
	 */
	List<Organization> fetchAllVendors();

	/**
	 * Function call to get the currency master list
	 * 
	 * @return
	 */
	List<String> currencyMasteList();

	/**
	 * Function call to get the unit master list
	 * 
	 * @return
	 */
	List<String> currencyUnitList();

	/**
	 * Function call to delete vendors
	 * 
	 * @param organization
	 * @return
	 */
	boolean deleteVendor(List<Organization> organization);

}

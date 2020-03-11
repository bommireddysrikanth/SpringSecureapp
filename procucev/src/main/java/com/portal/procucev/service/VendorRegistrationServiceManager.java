package com.portal.procucev.service;

import com.portal.procucev.model.Poc;
import com.portal.procucev.model.VendorInvitation;

/**
 * 
 * @author venu gopal
 *
 */
public interface VendorRegistrationServiceManager {

	/**
	 * This method is to send a mail invitation to vendor
	 * 
	 * @param invitation
	 * @return
	 */
	boolean requestRegistration(VendorInvitation invitation);

	/**
	 * Method to send a mail to the vendor point of contacts
	 * 
	 * @param invitation
	 * @return
	 */
	boolean sendMailToPoc(Poc invitation);

}

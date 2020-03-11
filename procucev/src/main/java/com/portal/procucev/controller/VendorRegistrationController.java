package com.portal.procucev.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.procucev.customexception.AppException;
import com.portal.procucev.model.Poc;
import com.portal.procucev.model.VendorInvitation;
import com.portal.procucev.service.VendorRegistrationServiceManager;
import com.portal.procucev.utils.ApplicationConstants;

/**
 * 
 * @author venu gopal
 *
 */
@RestController
@RequestMapping("/rest/vendorRegistration")
public class VendorRegistrationController {
	static Logger logger = LoggerFactory.getLogger(VendorRegistrationController.class);

	@Autowired
	VendorRegistrationServiceManager vendorRegService;

	/**
	 * Method to send an invitation mail to the vendor
	 * 
	 * @param invitation
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/requestRegistration")
	public ResponseEntity<?> sendRegistrationMail(@RequestBody VendorInvitation invitation) {
		boolean status = vendorRegService.requestRegistration(invitation);
		String statusCode = status ? String.valueOf(ApplicationConstants.SUCCESS)
				: String.valueOf(ApplicationConstants.FAILURE);
		String msg = status ? String.format(ApplicationConstants.MAIL_SENT_SUCCESS, "")
				: String.format(ApplicationConstants.MAIL_SENT_UNSUCCESS, "");
		AppException response = new AppException(statusCode, msg, null, null);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	/**
	 * Method to send a mail to the vendor related point of contacts
	 * 
	 * @param invitation
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/requestPocRegistration")
	public ResponseEntity<?> sendMailPoc(@RequestBody Poc invitation) {
		boolean status = vendorRegService.sendMailToPoc(invitation);
		String statusCode = status ? String.valueOf(ApplicationConstants.SUCCESS)
				: String.valueOf(ApplicationConstants.FAILURE);
		String msg = status ? String.format(ApplicationConstants.MAIL_SENT_SUCCESS, "")
				: String.format(ApplicationConstants.MAIL_SENT_UNSUCCESS, "");
		AppException response = new AppException(statusCode, msg, null, null);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}

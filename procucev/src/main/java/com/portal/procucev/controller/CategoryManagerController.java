package com.portal.procucev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.procucev.customexception.AppException;
import com.portal.procucev.model.Organization;
import com.portal.procucev.model.PR;
import com.portal.procucev.model.Query;
import com.portal.procucev.service.CategoryManagerService;
import com.portal.procucev.utils.ApplicationConstants;

/**
 * @author jaswanth.vasadhi
 *
 *         This class handles the category manager screen
 *
 */
@RestController
@RequestMapping("/rest/categoryManager")

public class CategoryManagerController {

	@Autowired
	CategoryManagerService categoryManagerService;

	/**
	 * @param org accepts the organization bean as input
	 * @return PR list based on organization and org status id(1,2,3) like
	 *         client_approved ,category_manager_rejected..
	 * 
	 * @throws AppException
	 */
	@PostMapping(value = "/getPRbyCategoryIdAndOrgStatus", produces = "application/json", consumes = "application/json")
	public ResponseEntity<?> getAllVendorDetailsByStatus(@RequestBody Organization org) throws AppException {

		List<PR> prList = categoryManagerService.getPRbyCategoryIdAndOrgStatus(org);

		return new ResponseEntity<>(prList, HttpStatus.OK);

	}
	
	@PostMapping(value = "/getPRAcceptORReject")
	public ResponseEntity<?> getPRAcceptORReject(@RequestBody PR pr) throws AppException {

		boolean prList = categoryManagerService.getPRAcceptORReject(pr);

		String statusCode = prList ? String.valueOf(ApplicationConstants.SUCCESS)
				: String.valueOf(ApplicationConstants.FAILURE);
		String msg = prList ? String.format(ApplicationConstants.PR_Accepted, "")
				: String.format(ApplicationConstants.PR_Accepted, "");
		AppException response = new AppException(statusCode, msg, null, null);
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}
	
	@PostMapping(value = "/CreateQuery")
	public ResponseEntity<?> CreateQuery(@RequestBody Query query) throws AppException {

		boolean prList = categoryManagerService.CreateQuery(query);

		String statusCode = prList ? String.valueOf(ApplicationConstants.SUCCESS)
				: String.valueOf(ApplicationConstants.FAILURE);
		String msg = prList ? String.format(ApplicationConstants.Query, "")
				: String.format(ApplicationConstants.Query, "");
		AppException response = new AppException(statusCode, msg, null, null);
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}
	
	
}

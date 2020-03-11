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
import com.portal.procucev.service.CategoryManagerService;

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
}

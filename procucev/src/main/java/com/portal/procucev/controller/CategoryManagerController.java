package com.portal.procucev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.procucev.model.Organization;
import com.portal.procucev.model.PR;
import com.portal.procucev.service.CategoryManagerService;

@RestController
@RequestMapping("/rest/categoryManager")
public class CategoryManagerController {

	@Autowired
	CategoryManagerService categoryManagerService;

	@PostMapping(value = "/getPRbyCategoryIdAndOrgStatus", produces = "application/json", consumes = "application/json")
	public List<PR> getAllVendorDetailsByStatus(@RequestBody Organization org) {

		List<PR> prList = categoryManagerService.getPRbyCategoryIdAndOrgStatus(org);

		return prList;
		
	}
}

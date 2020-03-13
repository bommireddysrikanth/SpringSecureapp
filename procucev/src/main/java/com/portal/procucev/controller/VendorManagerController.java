package com.portal.procucev.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.procucev.customexception.AppException;
import com.portal.procucev.dto.VendorDetailsByStatus;
import com.portal.procucev.model.OrgStatus;
import com.portal.procucev.model.RfqVendor;
import com.portal.procucev.service.VendorManagerService;

@RestController
@RequestMapping("/rest/vendorManager")
@CrossOrigin
public class VendorManagerController {

	@Autowired
	VendorManagerService vendorManagerService;

	/**
	 * Returns all vendor details by status
	 * 
	 * @param status
	 * @return
	 */
	@PostMapping(value = "/getAllVendorsByStatus", produces = "application/json", consumes = "application/json")
	public List<VendorDetailsByStatus> getAllVendorDetailsByStatus(OrgStatus status) {
		List<VendorDetailsByStatus> vendorDetailsBystatus = new ArrayList<VendorDetailsByStatus>();
		try {
			vendorDetailsBystatus = vendorManagerService.getAllVendorDetailsByStatus(status);
		} catch (AppException e) {
			throw new AppException(e.getErrorCode(), e.getErrorMessage(), e.getExceptiontype(), e.getStatus());
		}
		return vendorDetailsBystatus;
	}

	/**
	 * Returns all RFQs of a vendor by vendorId(orgId)
	 * 
	 * @param vendor
	 * @return
	 */
	@PostMapping(value = "/getAllRFQsByVendor", produces = "application/json", consumes = "application/json")
	public List<RfqVendor> getAllVendorDetailsByStatus(RfqVendor vendor) {
		List<RfqVendor> rfqvendorDetails = new ArrayList<>();
		try {
			rfqvendorDetails = vendorManagerService.getRFQDetailsByVendor(vendor.getOrg());
		} catch (AppException e) {
			throw new AppException(e.getErrorCode(), e.getErrorMessage(), e.getExceptiontype(), e.getStatus());
		}
		return rfqvendorDetails;
	}

}

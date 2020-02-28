package com.portal.procucev.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.procucev.dao.OrgDao;
import com.portal.procucev.dao.QuotationsDao;
import com.portal.procucev.dao.VendorRFQDao;
import com.portal.procucev.dto.VendorDetailsByStatus;
import com.portal.procucev.model.Organization;
import com.portal.procucev.model.Qoutation;
import com.portal.procucev.model.RfqVendor;
import com.portal.procucev.service.VendorManagerService;
import com.portal.procucev.utils.ApplicationConstants;

@Service
public class VendorManagerServiceImpl implements VendorManagerService {
	
	@Autowired
	OrgDao orgDao;
	
	@Autowired
	VendorRFQDao vendorRfqDao;

	@Autowired 
	QuotationsDao quotationsDao;
	@Override
	public List<VendorDetailsByStatus> getAllVendorDetailsByStatus(String status) {

		// "1" is the type id for vendor in the organization table
		List<VendorDetailsByStatus> approvedVendors = new ArrayList<VendorDetailsByStatus>();
		List<VendorDetailsByStatus> registrationPendingVendors = new ArrayList<VendorDetailsByStatus>();
		List<VendorDetailsByStatus> approvalPendingVendors = new ArrayList<VendorDetailsByStatus>();
		int orgTypeForVendor = ApplicationConstants.orgTypeForVendor;
		List<Organization> vendorsList = orgDao.getAllVendors(orgTypeForVendor);
		
			for (Organization organization : vendorsList) {
				
				if(organization.getOrgStatus().getStatusType().equalsIgnoreCase("approved")){
					
					VendorDetailsByStatus vendor = new VendorDetailsByStatus();
					vendor.setVendorName(organization.getOrganizationName());
					List<RfqVendor> rfqCount = getVendorRFQCountById(organization.getOrganizationId());
					vendor.setRfqSent(rfqCount.size());
					List<Qoutation> quotes = getQuotationsById(organization.getOrganizationId());
					vendor.setQuotationsRecieved(quotes.size());
					
				}
				}
		
		
		return null;
	}

	/**
	 * Get quotations by org 
	 * @param organizationId
	 */
	private List<Qoutation> getQuotationsById(int organizationId) {
		List<Qoutation> quotations = quotationsDao.findById(organizationId);
		return quotations;
	}

	/**
	 * Get RFQ's sent to a vendor by id
	 * @param organizationId
	 */
	private List<RfqVendor> getVendorRFQCountById(int organizationId) {
		List<RfqVendor> rfqForVendors = vendorRfqDao.findById(organizationId);
		return rfqForVendors;
	}

	
}

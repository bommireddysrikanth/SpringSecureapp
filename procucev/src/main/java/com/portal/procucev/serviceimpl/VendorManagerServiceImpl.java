package com.portal.procucev.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.portal.procucev.customexception.AppException;
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
		if (status.equalsIgnoreCase("approved")) {
			for (Organization organization : vendorsList) {
				if (organization.getOrgStatus().getStatusType().equalsIgnoreCase("approved")) {
					VendorDetailsByStatus vendor = new VendorDetailsByStatus();
					vendor.setVendorName(organization.getOrganizationName());
					List<RfqVendor> rfqCount = getVendorRFQCountById(organization.getOrganizationId());
					vendor.setRfqSent(rfqCount.size());
					List<Qoutation> quotes = getQuotationsById(organization.getOrganizationId());
					vendor.setQuotationsRecieved(quotes.size());
					// TODO - fetching count of queries those to be answered by procucve vendor
					// manager to vendor
					approvedVendors.add(vendor);
				}
			}

		}

		return approvedVendors;
	}

	/**
	 * Get quotations by org
	 * 
	 * @param organizationId
	 */
	private List<Qoutation> getQuotationsById(int organizationId) {
		List<Qoutation> quotations = quotationsDao.findById(organizationId);
		return quotations;
	}

	/**
	 * Get RFQ's sent to a vendor by id
	 * 
	 * @param organizationId
	 */
	private List<RfqVendor> getVendorRFQCountById(int organizationId) {
		List<RfqVendor> rfqForVendors = vendorRfqDao.findById(organizationId);
		return rfqForVendors;
	}

	@Override
	public List<RfqVendor> getRFQDetailsByVendor(int orgId) {
		List<RfqVendor> vendorRFQ = new ArrayList<RfqVendor>();
		try {
			vendorRFQ = getVendorRFQCountById(orgId);
		} catch (AppException e) {
			throw new AppException(500, "No RFQ's found", "Database exception", "Ok");
		}
		return vendorRFQ;
	}

	@Override
	public void getAllQueriesOfVendor(int orgId) {

	}

}

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
import com.portal.procucev.model.OrgStatus;
import com.portal.procucev.model.OrgType;
import com.portal.procucev.model.Organization;
import com.portal.procucev.model.Quotation;
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
	public List<VendorDetailsByStatus> getAllVendorDetailsByStatus(OrgStatus status) {

		// "1" is the type id for vendor in the organization table
		List<VendorDetailsByStatus> approvedVendors = new ArrayList<VendorDetailsByStatus>();
		List<VendorDetailsByStatus> registrationPendingVendors = new ArrayList<VendorDetailsByStatus>();
		List<VendorDetailsByStatus> approvalPendingVendors = new ArrayList<VendorDetailsByStatus>();
		OrgType orgTypeForVendor = new OrgType();
		orgTypeForVendor.setId(ApplicationConstants.orgTypeForVendor);
		// orgTypeForVendor.setOrgTypesId(ApplicationConstants.orgTypeForVendor);

		List<Organization> vendorsList = orgDao.findByorgType(orgTypeForVendor);
		if (status.getStatus().equalsIgnoreCase("approved")) {
			for (Organization organization : vendorsList) {
				if (organization.getOrgStatus().getStatus().equalsIgnoreCase("approved")) {
					VendorDetailsByStatus vendor = new VendorDetailsByStatus();
					vendor.setVendorName(organization.getOrganizationName());
					List<RfqVendor> rfqCount = getVendorRFQCountById(organization);
					vendor.setRfqSent(rfqCount.size());
					List<Quotation> quotes = getQuotationsById(organization.getId());
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
	private List<Quotation> getQuotationsById(int organizationId) {
		List<Quotation> quotations = quotationsDao.findById(organizationId);
		return quotations;
	}

	/**
	 * Get RFQ's sent to a vendor by id
	 * 
	 * @param organizationId
	 */
	private List<RfqVendor> getVendorRFQCountById(Organization organizationId) {
		List<RfqVendor> rfqForVendors = vendorRfqDao.findByOrganization(organizationId);
		return rfqForVendors;
	}

	@Override
	public List<RfqVendor> getRFQDetailsByVendor(Organization orgId) {
		List<RfqVendor> vendorRFQ = new ArrayList<RfqVendor>();
		try {
			vendorRFQ = getVendorRFQCountById(orgId);
		} catch (AppException e) {
			throw new AppException(HttpStatus.INTERNAL_SERVER_ERROR.value(), ApplicationConstants.No_RFQ_FOUND,
					ApplicationConstants.DATABASE_EXCEPTION, ApplicationConstants.SUCCESS);
		}
		return vendorRFQ;
	}

	@Override
	public void getAllQueriesOfVendor(int orgId) {

	}

}

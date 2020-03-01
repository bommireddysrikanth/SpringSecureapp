package com.portal.procucev.service;

import java.util.List;

import com.portal.procucev.dto.VendorDetailsByStatus;
import com.portal.procucev.model.OrgStatus;
import com.portal.procucev.model.Organization;
import com.portal.procucev.model.RfqVendor;

public interface VendorManagerService {

	public List<VendorDetailsByStatus> getAllVendorDetailsByStatus(OrgStatus status);
	
	public List<RfqVendor> getRFQDetailsByVendor(Organization organization);
	
	public void getAllQueriesOfVendor(int orgId);
}

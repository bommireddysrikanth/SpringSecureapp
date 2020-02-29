package com.portal.procucev.service;

import java.util.List;

import com.portal.procucev.dto.VendorDetailsByStatus;
import com.portal.procucev.model.RfqVendor;

public interface VendorManagerService {

	public List<VendorDetailsByStatus> getAllVendorDetailsByStatus(String status);
	
	public List<RfqVendor> getRFQDetailsByVendor(int orgId);
	
	public void getAllQueriesOfVendor(int orgId);
}

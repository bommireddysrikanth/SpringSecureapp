package com.portal.procucev.service;

import java.util.List;

import com.portal.procucev.dto.VendorDetailsByStatus;

public interface VendorManagerService {

	public List<VendorDetailsByStatus> getAllVendorDetailsByStatus(String status);
}

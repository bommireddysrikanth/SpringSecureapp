package com.portal.procucev.serviceimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;

import com.portal.procucev.customexception.AppException;
import com.portal.procucev.dao.VendorDao;
import com.portal.procucev.model.Organization;
import com.portal.procucev.service.VendorService;
import com.portal.procucev.utils.ApplicationConstants;

public class VendorServiceImpl implements VendorService {
	@Autowired
	VendorDao vendorDao;
	private static Logger logger = LoggerFactory.getLogger(VendorServiceImpl.class);

	@Override
	public boolean userRegistration(Organization newVendor) {
		boolean status = false;
		try {
			vendorDao.save(newVendor);
			status = true;
		} catch (Exception e) {
			return status;
		}
		return status;
	}

	@Override
	public List<Organization> fetchAllVendors() {
		List<Organization> vendorList = vendorDao.findAll();
		if (!CollectionUtils.isEmpty(vendorList)) {
			return vendorList;
		} else {
			logger.error("No vendors available in the database");
			throw new AppException(HttpStatus.NO_CONTENT.value(), ApplicationConstants.NO_DATA_FOUND,
					ApplicationConstants.BUSSINESS_EXCEPTION, ApplicationConstants.FAILURE);
		}
	}

}

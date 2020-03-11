package com.portal.procucev.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.portal.procucev.customexception.AppException;
import com.portal.procucev.dao.VendorDao;
import com.portal.procucev.model.CurrencyMaster;
import com.portal.procucev.model.CurrencyUnit;
import com.portal.procucev.model.Organization;
import com.portal.procucev.service.VendorService;
import com.portal.procucev.utils.ApplicationConstants;

@Service
public class VendorServiceImpl implements VendorService {
	@Autowired
	VendorDao vendorDao;

	static Logger logger = LoggerFactory.getLogger(VendorServiceImpl.class);

	@Override
	public boolean userRegistration(Organization newVendor) {
		boolean status = false;
		try {
			vendorDao.save(newVendor);
			status = true;
			return status;
		} catch (Exception e) {
			return status;
		}
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

	@Override
	public List<String> currencyMasteList() {
		List<CurrencyMaster> currencyList = vendorDao.fetchCurrencyList();
		if (!CollectionUtils.isEmpty(currencyList)) {
			List<String> list = currencyList.stream().map(CurrencyMaster::getCurrencyType).collect(Collectors.toList());
			return list;
		} else {
			logger.error("No vendors available in the database");
			throw new AppException(HttpStatus.NO_CONTENT.value(), ApplicationConstants.NO_DATA_FOUND,
					ApplicationConstants.BUSSINESS_EXCEPTION, ApplicationConstants.FAILURE);
		}
	}

	@Override
	public List<String> currencyUnitList() {
		List<CurrencyUnit> unitList = vendorDao.fetchUnitList();
		if (!CollectionUtils.isEmpty(unitList)) {
			List<String> list = unitList.stream().map(CurrencyUnit::getCurrencyUnitsType).collect(Collectors.toList());
			return list;
		} else {
			logger.error("No vendors available in the database");
			throw new AppException(HttpStatus.NO_CONTENT.value(), ApplicationConstants.NO_DATA_FOUND,
					ApplicationConstants.BUSSINESS_EXCEPTION, ApplicationConstants.FAILURE);
		}
	}

	@Override
	public boolean deleteVendor(List<Organization> organization) {
		boolean status = false;
		try {
			vendorDao.delete(organization);
			status = true;
			return status;
		} catch (Exception e) {
			return status;
		}
	}

}

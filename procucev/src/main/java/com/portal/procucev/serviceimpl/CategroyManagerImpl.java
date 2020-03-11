package com.portal.procucev.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.portal.procucev.customexception.AppException;
import com.portal.procucev.dao.PRDaoManager;
import com.portal.procucev.model.Organization;
import com.portal.procucev.model.PR;
import com.portal.procucev.service.CategoryManagerService;
import com.portal.procucev.utils.ApplicationConstants;

@Service
public class CategroyManagerImpl implements CategoryManagerService {

	@Autowired
	PRDaoManager prDaoManager;

	@Override
	public List<PR> getPRbyCategoryIdAndOrgStatus(Organization org) {
		List<PR> prListByOrgId = new ArrayList<PR>();
		List<PR> prListByOrgIdAndOrgStatus = new ArrayList<PR>();

		try {
			// if (org.getOrgType().getOrgTypesId() == 3)
			prListByOrgId = prDaoManager.findByOrg(org);

			if (!prListByOrgId.isEmpty()) {
				for (PR pr : prListByOrgId) {

					if (pr.getStatus().getId() == org.getOrgStatus().getId()) {
						prListByOrgIdAndOrgStatus.add(pr);
					}
				}

			} else {
				throw new AppException(HttpStatus.OK.value(), ApplicationConstants.NO_DATA_FOUND,
						ApplicationConstants.BUSSINESS_EXCEPTION, ApplicationConstants.SUCCESS);

			}

			if (prListByOrgIdAndOrgStatus.isEmpty()) {
				throw new AppException(HttpStatus.OK.value(), ApplicationConstants.NO_DATA_FOUND,
						ApplicationConstants.BUSSINESS_EXCEPTION, ApplicationConstants.SUCCESS);
			}
		} catch (Exception e) {
			throw new AppException(HttpStatus.METHOD_FAILURE.value(), e.getMessage(),
					ApplicationConstants.BUSSINESS_EXCEPTION, ApplicationConstants.FAILURE);
		}
		return prListByOrgIdAndOrgStatus;
	}

}

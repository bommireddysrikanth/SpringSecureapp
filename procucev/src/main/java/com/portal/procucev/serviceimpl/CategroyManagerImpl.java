package com.portal.procucev.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.portal.procucev.customexception.AppException;
import com.portal.procucev.dao.PRDaoManager;
import com.portal.procucev.dao.QueryDaoManager;
import com.portal.procucev.model.Organization;
import com.portal.procucev.model.PR;
import com.portal.procucev.model.Query;
import com.portal.procucev.model.Rfq;
import com.portal.procucev.service.CategoryManagerService;
import com.portal.procucev.utils.ApplicationConstants;

@Service
public class CategroyManagerImpl implements CategoryManagerService {

	@Autowired
	PRDaoManager prDaoManager;
	
	@Autowired
	QueryDaoManager queryDaoManager;

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
	
	
	/**
	 * Save PR by Accept or reject
	 * @author Srikanth
	 */
	@Override
	public boolean getPRAcceptORReject(PR pr) {
		
		boolean status = false;
		try {
			
				prDaoManager.save(pr);
			
			
			status = true;
		} catch (Exception e) {
			return status;
		}
		return status;
		
		

	}
	/**
	 * get Query List By PR ID
	 * @author srikanth
	 */

	@Override
	public List<List<Query>> getPRquery(PR pr) {

		List<PR> prList = prDaoManager.findById(pr.getId());
		List<List<Query>> queryList = prList.stream().map(PR::getQuerys).collect(Collectors.toList());
		if (!CollectionUtils.isEmpty(queryList)) {
			return queryList;
		} else {
			throw new AppException(HttpStatus.NO_CONTENT.value(), ApplicationConstants.NO_DATA_FOUND,
					ApplicationConstants.BUSSINESS_EXCEPTION, ApplicationConstants.FAILURE);
		}

	}
	
	/**
	 * get list of RFQ by PR
	 * @author srikanth
	 */
	@Override
	public List<List<Rfq>> getRfqbyPR(PR pr) {

		List<PR> prList = prDaoManager.findById(pr.getId());
		List<List<Rfq>> Rfqlist = prList.stream().map(PR::getRFQ).collect(Collectors.toList());
		if (!CollectionUtils.isEmpty(Rfqlist)) {
			return Rfqlist;
		} else {
			throw new AppException(HttpStatus.NO_CONTENT.value(), ApplicationConstants.NO_DATA_FOUND,
					ApplicationConstants.BUSSINESS_EXCEPTION, ApplicationConstants.FAILURE);
		}
	}
	
	/**
	 * Create Query
	 * 
	 */
	
	@Override
	public boolean CreateQuery(Query query ){
		boolean status = false;
		try {
			queryDaoManager.saveAndFlush(query);
			status = true;
		} catch (Exception e) {
			return status;
		}
		return status;
		
	}

}

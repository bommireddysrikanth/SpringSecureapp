/**
 * 
 */
package com.portal.procucev.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.portal.procucev.customexception.AppException;
import com.portal.procucev.dao.PRDaoManager;
import com.portal.procucev.model.PR;
import com.portal.procucev.service.PRServiceManager;
import com.portal.procucev.utils.ApplicationConstants;

/**
 * @author Chiru
 *
 */
@Service
public class PRServiceManagerImpl implements PRServiceManager {

	private static final Logger log = LoggerFactory.getLogger(PRServiceManagerImpl.class);

	@Autowired
	PRDaoManager prDaoManager;

	@Override
	public PR savePR(PR probject) {

		prDaoManager.save(probject);

		return null;
	}

	@Override
	public List<PR> getAllPR() {
		Iterable<PR> priterable = prDaoManager.findAll();
		List<PR> listofprs = new ArrayList<PR>();
		priterable.forEach(listofprs::add);
		return listofprs;
	}

	@Override
	public List<PR> getAllPRByClient(PR prObject) {

		List<PR> prlist = new ArrayList<PR>();

		// quering PR based on the org input
		prlist = prDaoManager.findByOrg(prObject.getOrg());

		return prlist;
	}

	@Override
	public PR getPRbyID(PR pr) {

		PR prdetails = prDaoManager.findByOrgAndPrId(pr.getOrg(), pr.getPrId());

		if (prdetails == null) {

			throw new AppException(HttpStatus.NOT_FOUND.value(),
					String.format(ApplicationConstants.PR_NOT_FOUND, pr.getPrId()),
					ApplicationConstants.SERVICE_LEVEL_EXCEPTION, ApplicationConstants.FAILURE);
		}

		return prdetails;
	}

}

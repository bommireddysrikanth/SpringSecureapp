package com.portal.procucev.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.procucev.dao.PRDaoManager;
import com.portal.procucev.model.Organization;
import com.portal.procucev.model.PR;
import com.portal.procucev.service.CategoryManagerService;


@Service
public class CategroyManagerImpl implements CategoryManagerService {

	@Autowired
	PRDaoManager prDaoManager;

	@Override
	public List<PR> getPRbyCategoryIdAndOrgStatus(Organization org) {
		List<PR> prlist = new ArrayList<PR>();
		if (org.getOrgType().getOrgTypesId() == 3)
			prlist = prDaoManager.findByOrg(org);
		return prlist;
	}

}

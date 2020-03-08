package com.portal.procucev.service;

import java.util.List;

import com.portal.procucev.model.Organization;
import com.portal.procucev.model.PR;

public interface CategoryManagerService {
	List<PR> getPRbyCategoryIdAndOrgStatus(Organization org);

}

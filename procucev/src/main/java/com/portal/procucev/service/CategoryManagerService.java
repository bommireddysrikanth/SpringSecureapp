package com.portal.procucev.service;

import java.util.List;

import com.portal.procucev.model.Organization;
import com.portal.procucev.model.PR;
import com.portal.procucev.model.Query;
import com.portal.procucev.model.Rfq;



public interface CategoryManagerService {
	List<PR> getPRbyCategoryIdAndOrgStatus(Organization org);

	//boolean getPRAcceptORReject(PR pr);

	List<List<Query>> getPRquery(PR pr);

	List<List<Rfq>> getRfqbyPR(PR pr);

	boolean CreateQuery(Query query);

	boolean getPRAcceptORReject(PR pr);

}

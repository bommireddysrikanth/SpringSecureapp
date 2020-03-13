package com.portal.procucev.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.portal.procucev.model.OrgStatus;
import com.portal.procucev.model.Organization;
import com.portal.procucev.model.PR;

@Repository
public interface PRDaoManager extends ProcucevDao<PR, Serializable> {

	/**
	 * Get PR by Organization id
	 * 
	 * @param org
	 * @return
	 */
	List<PR> findByOrg(Organization org);

	/**
	 * Get PR details by Organization and PR ID
	 * 
	 * @param org
	 * @param prId
	 * @return
	 */
	PR findByOrgAndId(Organization org, int Id);

	 List<PR> findByStatus(OrgStatus status);

	List<PR> findById(int id);

}

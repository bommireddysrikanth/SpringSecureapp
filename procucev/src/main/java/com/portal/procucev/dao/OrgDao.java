package com.portal.procucev.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.portal.procucev.model.Organization;

@Repository
public interface OrgDao extends CrudRepository<Organization, Long> {

	@Query("Select * from organization where org_types_id=?1")
	List<Organization> getAllVendors(int orgTypeForVendor);

}

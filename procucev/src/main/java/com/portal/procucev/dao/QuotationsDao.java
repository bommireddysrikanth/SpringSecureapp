package com.portal.procucev.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.portal.procucev.model.Organization;
import com.portal.procucev.model.Quotation;

@Repository
public interface QuotationsDao extends CrudRepository<Quotation, Long> {

	// @Query("select * from qoutation where org_id=?1")
	List<Quotation> findByQoutationId(int organizationId);

	List<Quotation> findByOrgId(Organization org);

}

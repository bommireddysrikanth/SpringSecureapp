package com.portal.procucev.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.portal.procucev.model.RfqVendor;
@Repository
public interface VendorRFQDao extends CrudRepository<RfqVendor, Long> {

	@Query("select * from rfq_vendor where org_id=?1")
	List<RfqVendor> findById(int organizationId);

}

package com.portal.procucev.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.portal.procucev.model.Qoutation;

@Repository
public interface QuotationsDao extends CrudRepository<Qoutation, Long>{

	@Query("select * from qoutation where org_id=?1")
	List<Qoutation> findById(int organizationId);

	
}

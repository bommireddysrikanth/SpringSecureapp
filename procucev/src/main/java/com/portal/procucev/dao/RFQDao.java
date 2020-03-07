package com.portal.procucev.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.portal.procucev.model.Rfq;

@Repository("rfqDao")
public interface RFQDao extends JpaRepository<Rfq, Integer>, JpaSpecificationExecutor<Rfq> {

	List<Rfq> findByRfqId(int id);

}

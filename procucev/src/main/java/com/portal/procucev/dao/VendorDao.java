package com.portal.procucev.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.portal.procucev.model.CurrencyMaster;
import com.portal.procucev.model.CurrencyUnit;
import com.portal.procucev.model.Organization;

@Repository("vendorDao")
public interface VendorDao extends JpaRepository<Organization, Integer> {

	@Query(value = "select * from currency_master", nativeQuery = true)
	List<CurrencyMaster> fetchCurrencyList();

	@Query(value = "select * from currency_units", nativeQuery = true)
	List<CurrencyUnit> fetchUnitList();

}

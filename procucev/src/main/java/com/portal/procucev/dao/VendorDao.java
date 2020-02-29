package com.portal.procucev.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portal.procucev.model.Organization;

@Repository("vendorDao")
public interface VendorDao extends JpaRepository<Organization, Integer> {

}

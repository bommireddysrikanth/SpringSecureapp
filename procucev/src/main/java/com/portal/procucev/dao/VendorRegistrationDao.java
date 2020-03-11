package com.portal.procucev.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portal.procucev.model.VendorInvitation;

@Repository("vendorRegistrationDao")
public interface VendorRegistrationDao extends JpaRepository<VendorInvitation, Integer> {

}

package com.portal.procucev.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.portal.procucev.dao.VendorRegistrationDao;
import com.portal.procucev.model.Poc;
import com.portal.procucev.model.VendorInvitation;
import com.portal.procucev.service.VendorRegistrationServiceManager;
import com.portal.procucev.utils.MailUtility;

@Service
public class VendorRegistrationServiceManagerImpl implements VendorRegistrationServiceManager {

	@Autowired
	JavaMailSender javaMailSender;

	@Autowired
	VendorRegistrationDao vendorRegistrationDao;

	@Value("${mailFrom}")
	String mailFom;

	@Value("${host}")
	String host;

	@Override
	public boolean requestRegistration(VendorInvitation invitation) {
		boolean status = false;
		try {
			invitation.setStatus("Waiting");
			vendorRegistrationDao.save(invitation);
			MailUtility.mailingVerificationLink(invitation, javaMailSender, mailFom, host);
			status = true;
			return status;
		} catch (Exception e) {
			return status;
		}
	}

	@Override
	public boolean sendMailToPoc(Poc invitation) {
		boolean status = false;
		try {
			// vendorRegistrationDao.save(invitation);
			MailUtility.mailingVerificationLinkToPoc(invitation, javaMailSender, mailFom, host);
			status = true;
			return status;
		} catch (Exception e) {
			return status;
		}
	}

}

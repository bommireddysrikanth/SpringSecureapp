package com.portal.procucev.utils;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.portal.procucev.model.Poc;
import com.portal.procucev.model.VendorInvitation;

public class MailUtility {
	static final Logger LOGGER = LoggerFactory.getLogger(MailUtility.class);

	public static void mailingVerificationLink(VendorInvitation invitation, JavaMailSender javaMailSender, String from,
			String hostName) {

		String verificationTemplate = "<!DOCTYPE html>\n" + "<html>\n" + "<body>\n" + "\n" + "Hi "
				+ invitation.getOrgName() + ", <br><br>\n" + "\n"
				+ "<b>Please click the below link to create your account at Procucev Portal.</b>\n" + "\n"
				+ "<p><a href=\"http://" + hostName + "/#/home/user/login?userName=" + invitation.getOrgName()
				+ "&token=" + invitation.getToken() + "\">Create your account !!</a></p>\n" + "<b>Thanks, <br></b>\n"
				+ "\n" + "<b>Procucev Admin</b>\n" + "\n" + "\n" + "</body>\n" + "</html>";

		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
		try {
			mimeMessageHelper.setTo(invitation.getEmail());
			mimeMessageHelper.setFrom(from); // from Address
			mimeMessageHelper.setSubject("Procucev Portal Account Creation !!");
			mimeMessageHelper.setText(verificationTemplate, true);
			javaMailSender.send(mimeMessage);
		} catch (Exception e) {
			LOGGER.error("Error in sending creation mail -- " + e.getMessage());
		}
		LOGGER.info("Sent verifiation mail successfully");
	}

	public static void mailingVerificationLinkToPoc(Poc invitation, JavaMailSender javaMailSender, String from,
			String hostName) {

		String verificationTemplate = "<!DOCTYPE html>\n" + "<html>\n" + "<body>\n" + "\n" + "Hi "
				+ invitation.getPocFirstName() + ", <br><br>\n" + "\n"
				+ "<b>Please click the below link to create your account at Procucev Portal.</b>\n" + "\n"
				+ "<p><a href=\"http://" + hostName + "/#/home/user/login?userName=" + invitation.getPocFirstName()
				+ "&token="/* + invitation.getToken() */ + "\">Create your account !!</a></p>\n"
				+ "<b>Thanks, <br></b>\n" + "\n" + "<b>Procucev Admin</b>\n" + "\n" + "\n" + "</body>\n" + "</html>";

		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
		try {
			mimeMessageHelper.setTo(invitation.getEmail());
			mimeMessageHelper.setFrom(from); // from Address
			mimeMessageHelper.setSubject("Procucev Portal Account Verification !!");
			mimeMessageHelper.setText(verificationTemplate, true);
			javaMailSender.send(mimeMessage);
		} catch (Exception e) {
			LOGGER.error("Error in sending creation mail -- " + e.getMessage());
		}
		LOGGER.info("Sent verifiation mail successfully");
	}

}

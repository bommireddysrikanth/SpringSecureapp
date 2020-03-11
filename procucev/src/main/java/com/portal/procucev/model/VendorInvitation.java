package com.portal.procucev.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * The persistent class for the vendor_invitation database table.
 * 
 */
@Entity
@Table(name = "vendor_invitation")
public class VendorInvitation extends Procucev {

	private static final long serialVersionUID = 1L;

	@Column(name = "org_name")
	private String orgName;

	@Column(name = "phone")
	private String phone;

	@Column(name = "email")
	private String email;

	@Transient
	private String token;

	@Column(name = "`invitation sent_by`")
	private String invitation_sentBy;

	@Column(name = "invitation_user_id")
	private String invitationUserId;

	@Column(name = "link_expiry_ts")
	private String linkExpiryTs;

	private String status;

	public String getInvitation_sentBy() {
		return this.invitation_sentBy;
	}

	public void setInvitation_sentBy(String invitation_sentBy) {
		this.invitation_sentBy = invitation_sentBy;
	}

	public String getInvitationUserId() {
		return this.invitationUserId;
	}

	public void setInvitationUserId(String invitationUserId) {
		this.invitationUserId = invitationUserId;
	}

	public String getLinkExpiryTs() {
		return this.linkExpiryTs;
	}

	public void setLinkExpiryTs(String linkExpiryTs) {
		this.linkExpiryTs = linkExpiryTs;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
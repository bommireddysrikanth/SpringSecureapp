package com.portal.procucev.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the vendor_invitation database table.
 * 
 */
@Entity
@Table(name = "vendor_invitation")
public class VendorInvitation extends Procucev implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "vendor_invitation_id")
	private int vendorInvitationId;

	@Column(name = "`invitation sent_by`")
	private String invitation_sentBy;

	@Column(name = "invitation_user_id")
	private String invitationUserId;

	@Column(name = "link_expary_ts")
	private String linkExparyTs;

	private String status;

	public int getVendorInvitationId() {
		return this.vendorInvitationId;
	}

	public void setVendorInvitationId(int vendorInvitationId) {
		this.vendorInvitationId = vendorInvitationId;
	}

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

	public String getLinkExparyTs() {
		return this.linkExparyTs;
	}

	public void setLinkExparyTs(String linkExparyTs) {
		this.linkExparyTs = linkExparyTs;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
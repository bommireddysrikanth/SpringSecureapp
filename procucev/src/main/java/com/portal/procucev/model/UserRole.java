package com.portal.procucev.model;

import javax.persistence.*;

/**
 * The persistent class for the user_role database table.
 * 
 */
@Entity
@Table(name = "user_role")
@NamedQuery(name = "UserRole.findAll", query = "SELECT u FROM UserRole u")
public class UserRole extends Procucev {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Role roleId;

	@ManyToOne
	private User userId;

	public UserRole() {
	}

	public Role getRoleId() {
		return roleId;
	}

	public void setRoleId(Role roleId) {
		this.roleId = roleId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	

}
package com.portal.procucev.model;

import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@Table(name = "role")
@NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r")
public class Role extends Procucev {
	private static final long serialVersionUID = 1L;

	@Column(name = "role_type")
	private String roleType;

	// bi-directional many-to-one association to PermissionRole
	@OneToMany(mappedBy = "role")
	private List<PermissionRole> permissionRoles;

	public Role() {
	}

	public String getRoleType() {
		return this.roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public List<PermissionRole> getPermissionRoles() {
		return this.permissionRoles;
	}

	public void setPermissionRoles(List<PermissionRole> permissionRoles) {
		this.permissionRoles = permissionRoles;
	}

	public PermissionRole addPermissionRole(PermissionRole permissionRole) {
		getPermissionRoles().add(permissionRole);
		permissionRole.setRole(this);

		return permissionRole;
	}

	public PermissionRole removePermissionRole(PermissionRole permissionRole) {
		getPermissionRoles().remove(permissionRole);
		permissionRole.setRole(null);

		return permissionRole;
	}

}
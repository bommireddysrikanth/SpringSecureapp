package com.portal.procucev.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the permission_role database table.
 * 
 */
@Entity
@Table(name="permission_role")
@NamedQuery(name="PermissionRole.findAll", query="SELECT p FROM PermissionRole p")
public class PermissionRole extends Procucev {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="permission_role_id")
	private int permissionRoleId;

	//bi-directional many-to-one association to Permission
	@ManyToOne
	@JoinColumn(name="permission_id")
	private Permission permission;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="role_id")
	private Role role;

	public PermissionRole() {
	}

	public int getPermissionRoleId() {
		return this.permissionRoleId;
	}

	public void setPermissionRoleId(int permissionRoleId) {
		this.permissionRoleId = permissionRoleId;
	}

	public Permission getPermission() {
		return this.permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
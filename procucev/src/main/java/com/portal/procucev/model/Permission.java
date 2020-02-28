package com.portal.procucev.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the permissions database table.
 * 
 */
@Entity
@Table(name="permissions")
@NamedQuery(name="Permission.findAll", query="SELECT p FROM Permission p")
public class Permission implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="permissions_id")
	private int permissionsId;

	@Column(name="permissions_type")
	private String permissionsType;

	//bi-directional many-to-one association to PermissionRole
	@OneToMany(mappedBy="permission")
	private List<PermissionRole> permissionRoles;

	public Permission() {
	}

	public int getPermissionsId() {
		return this.permissionsId;
	}

	public void setPermissionsId(int permissionsId) {
		this.permissionsId = permissionsId;
	}

	public String getPermissionsType() {
		return this.permissionsType;
	}

	public void setPermissionsType(String permissionsType) {
		this.permissionsType = permissionsType;
	}

	public List<PermissionRole> getPermissionRoles() {
		return this.permissionRoles;
	}

	public void setPermissionRoles(List<PermissionRole> permissionRoles) {
		this.permissionRoles = permissionRoles;
	}

	public PermissionRole addPermissionRole(PermissionRole permissionRole) {
		getPermissionRoles().add(permissionRole);
		permissionRole.setPermission(this);

		return permissionRole;
	}

	public PermissionRole removePermissionRole(PermissionRole permissionRole) {
		getPermissionRoles().remove(permissionRole);
		permissionRole.setPermission(null);

		return permissionRole;
	}

}
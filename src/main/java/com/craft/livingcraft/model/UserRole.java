package com.craft.livingcraft.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class UserRole 
{
	@Id
    private int roleId;
	private int userId;
	
	@OneToOne
	@JoinColumn(name="userId",updatable=false,insertable=false,nullable=false)
	private User user;
	
	@OneToOne
	@JoinColumn(name="roleId",updatable=false,insertable=false,nullable=false)
	private Role role;

	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
   
	
}

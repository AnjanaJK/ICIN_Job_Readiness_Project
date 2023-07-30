package com.icin.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admin_id")
	private int adminId;
	
	@Column(name = "admin_username")
	private String adminUsername;
	
	@Column(name = "admin_password")
	private String adminPassword;
	
	@Column(name = "admin_role")
	private String role = "Admin";
	
//	-------------------------------------------------------
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public Admin(int adminId, String adminUsername, String adminPassword, String role) {
		super();
		this.adminId = adminId;
		this.adminUsername = adminUsername;
		this.adminPassword = adminPassword;
		this.role = role;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminUsername() {
		return adminUsername;
	}

	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminUsername=" + adminUsername + ", adminPassword=" + adminPassword
				+ ", role=" + role + "]";
	}
	
}

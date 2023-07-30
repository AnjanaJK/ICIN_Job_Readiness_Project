package com.icin.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class UserLogin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "login_id")
	private int loginId;
	
	@ManyToOne
    @JoinColumn(name = "accountNo", referencedColumnName = "account_no")
    private User user;
	
	@Column(name = "user_password")
	private String userPassword;
	
	@Column(name = "trn_password")
	private String trnPassword;

//------------------------------------------------------------------
	
	public UserLogin() {
		// TODO Auto-generated constructor stub
	}

	

	public UserLogin(int loginId, User user, String userPassword, String trnPassword) {
		super();
		this.loginId = loginId;
		this.user = user;
		this.userPassword = userPassword;
		this.trnPassword = trnPassword;
	}

	public String getTrnPassword() {
		return trnPassword;
	}

	public void setTrnPassword(String trnPassword) {
		this.trnPassword = trnPassword;
	}

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}



	@Override
	public String toString() {
		return "UserLogin [loginId=" + loginId + ", user=" + user + ", userPassword=" + userPassword + ", trnPassword="
				+ trnPassword + "]";
	}

	

}

package com.icin.Entity;

import java.util.List;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "account_no")
//    private Long accountNo;
//	@Id
//    @GeneratedValue(generator = "accountNumberGenerator")
//    @GenericGenerator(name = "accountNumberGenerator", strategy = "com.icin.Config.CustomAccountNumberGenerator")
//    @Column(name = "account_no")
//    private String accountNo;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid;

    @Column(name = "account_no", unique = true)
    private String accountNo;
	
	@Column(name="account_type")
	private String accountType;	// Savings
	
	@Column(name="user_firstname")
	private String userFirstName;

	@Column(name="user_lastname")
	private String userLastName;
	
	@Column(name="user_email")
	private String userEmail;
	
	@Column(name="user_phone_no")
	private String userPhoneNo;
	
	@Column(name="user_address")
	private String userAddress;
	
	@Column(name="user_location")
	private String userLocation;
	
	@Column(name="user_status")
	private int userStatus = 0;	// Active/Deactive
	
	@Column(name="role")
	private String role;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<UserLogin> logins;
	
	@OneToMany(mappedBy = "accountNo", cascade = CascadeType.ALL)
	private List<CheckBookReq> requests;
	
//	@OneToMany(mappedBy = "sender", cascade = CascadeType.ALL)
//    private List<UserTrn> senderTransactions;

//    @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL)
//    private List<UserTrn> receiverTransactions;
    
    private Double currentBalance;
	
	
//------------------------------------------------------------------
	
	public User() {
		// TODO Auto-generated constructor stub
	}	


	public User(Long userid, String accountNo, String accountType, String userFirstName, String userLastName,
		String userEmail, String userPhoneNo, String userAddress, String userLocation, int userStatus, String role,
		List<UserLogin> logins, List<CheckBookReq> requests, List<UserTrn> senderTransactions,
		List<UserTrn> receiverTransactions, Double currentBalance) {
		super();
		this.userid = userid;
		this.accountNo = accountNo;
		this.accountType = accountType;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userEmail = userEmail;
		this.userPhoneNo = userPhoneNo;
		this.userAddress = userAddress;
		this.userLocation = userLocation;
		this.userStatus = userStatus;
		this.role = role;
		this.logins = logins;
		this.requests = requests;
//		this.senderTransactions = senderTransactions;
//		this.receiverTransactions = receiverTransactions;
		this.currentBalance = currentBalance;
	}

	public Double getCurrentBalance() {
		return currentBalance;
	}


	public void setCurrentBalance(Double currentBalance) {
		this.currentBalance = currentBalance;
	}


//	public List<UserTrn> getSenderTransactions() {
//		return senderTransactions;
//	}
//
//
//	public void setSenderTransactions(List<UserTrn> senderTransactions) {
//		this.senderTransactions = senderTransactions;
//	}
//
//
//	public List<UserTrn> getReceiverTransactions() {
//		return receiverTransactions;
//	}
//
//
//	public void setReceiverTransactions(List<UserTrn> receiverTransactions) {
//		this.receiverTransactions = receiverTransactions;
//	}


	public Long getUserid() {
		return userid;
	}


	public void setUserid(Long userid) {
		this.userid = userid;
	}


	public List<CheckBookReq> getRequests() {
		return requests;
	}


	public void setRequests(List<CheckBookReq> requests) {
		this.requests = requests;
	}


	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAccountNo() {
		return accountNo;
	}
	
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	
	public String getAccountType() {
		return accountType;
	}
	
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	public String getUserFirstName() {
		return userFirstName;
	}
	
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	
	public String getUserLastName() {
		return userLastName;
	}
	
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	
	public String getUserEmail() {
		return userEmail;
	}
	
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	public String getUserPhoneNo() {
		return userPhoneNo;
	}
	
	public void setUserPhoneNo(String userPhoneNo) {
		this.userPhoneNo = userPhoneNo;
	}
	
	public String getUserAddress() {
		return userAddress;
	}
	
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	
	public String getUserLocation() {
		return userLocation;
	}
	
	public void setUserLocation(String userLocation) {
		this.userLocation = userLocation;
	}
	
	public int getUserStatus() {
		return userStatus;
	}
	
	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}


	public List<UserLogin> getLogins() {
		return logins;
	}
	
	public void setLogins(List<UserLogin> logins) {
		this.logins = logins;
	}


	@Override
	public String toString() {
		return "User [userid=" + userid + ", accountNo=" + accountNo + ", accountType=" + accountType
				+ ", userFirstName=" + userFirstName + ", userLastName=" + userLastName + ", userEmail=" + userEmail
				+ ", userPhoneNo=" + userPhoneNo + ", userAddress=" + userAddress + ", userLocation=" + userLocation
				+ ", userStatus=" + userStatus + ", role=" + role + ", logins=" + logins + ", requests=" + requests
				+ ", currentBalance=" + currentBalance + "]";
	}


//	@Override
//	public String toString() {
//		return "User [userid=" + userid + ", accountNo=" + accountNo + ", accountType=" + accountType
//				+ ", userFirstName=" + userFirstName + ", userLastName=" + userLastName + ", userEmail=" + userEmail
//				+ ", userPhoneNo=" + userPhoneNo + ", userAddress=" + userAddress + ", userLocation=" + userLocation
//				+ ", userStatus=" + userStatus + ", role=" + role + ", logins=" + logins + ", requests=" + requests
//				+ ", senderTransactions=" + senderTransactions + ", receiverTransactions=" + receiverTransactions
//				+ ", currentBalance=" + currentBalance + "]";
//	}

	
}

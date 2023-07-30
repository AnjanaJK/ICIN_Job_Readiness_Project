package com.icin.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CheckBookReq {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sno;
	
	@ManyToOne
    @JoinColumn(name = "accountNo", referencedColumnName = "account_no")
	private User accountNo;
	
	@Column(name="account_type")
	private String accountType;
	
	@Column(name="description")
	private String description;
	
	@Column(name="req_status")
	private int requestStatus;
	
//	------------------------------------------------------------------------
	
	public CheckBookReq() {
		// TODO Auto-generated constructor stub
	}

	public CheckBookReq(int sno, User accountNo, String accountType, String description, int requestStatus) {
		super();
		this.sno = sno;
		this.accountNo = accountNo;
		this.accountType = accountType;
		this.description = description;
		this.requestStatus = requestStatus;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public User getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(User accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(int requestStatus) {
		this.requestStatus = requestStatus;
	}

	@Override
	public String toString() {
		return "CheckBookReq [sno=" + sno + ", accountNo=" + accountNo + ", accountType=" + accountType + ", description="
				+ description + ", requestStatus=" + requestStatus + "]";
	}
	
	

}

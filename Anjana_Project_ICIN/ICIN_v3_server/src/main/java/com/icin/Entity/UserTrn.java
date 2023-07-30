package com.icin.Entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class UserTrn {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
//	@ManyToOne
//    @JoinColumn(name = "receiver_account_no", referencedColumnName = "account_no")
    @Column(name="receiver_account_no")
	private String receiver;

//    @ManyToOne
//    @JoinColumn(name = "", referencedColumnName = "account_no")
    @Column(name="sender_account_no")
    private String sender;
	
	@Column(name="balance")
	private Double balance;
	
	@Column(name="trn_amt")
	private Double trnAmt;
	
	@Column(name="trn_type")
	private String trnType;
	
	@Column(name="trn_date")
	private LocalDate trnDate;
	
	@Column(name="trn_time")
	private LocalTime trnTime;
	
	@Column(name="description")
	private String description;
	
//	--------------------------------------------------------------------------
	
	public UserTrn() {
		// TODO Auto-generated constructor stub
	}
	
	


	public UserTrn(int id, String receiver, String sender, Double balance, Double trnAmt, String trnType, LocalDate trnDate,
		LocalTime trnTime, String description) {
	super();
	this.id = id;
	this.receiver = receiver;
	this.sender = sender;
	this.balance = balance;
	this.trnAmt = trnAmt;
	this.trnType = trnType;
	this.trnDate = trnDate;
	this.trnTime = trnTime;
	this.description = description;
}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getTrnAmt() {
		return trnAmt;
	}

	public void setTrnAmt(Double trnAmt) {
		this.trnAmt = trnAmt;
	}

	
	public String getTrnType() {
		return trnType;
	}




	public void setTrnType(String trnType) {
		this.trnType = trnType;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public LocalDate getTrnDate() {
		return trnDate;
	}

	public void setTrnDate(LocalDate trnDate) {
		this.trnDate = trnDate;
	}

	public LocalTime getTrnTime() {
		return trnTime;
	}

	public void setTrnTime(LocalTime trnTime) {
		this.trnTime = trnTime;
	}




	@Override
	public String toString() {
		return "UserTrn [id=" + id + ", receiver=" + receiver + ", sender=" + sender + ", balance=" + balance
				+ ", trnAmt=" + trnAmt + ", trnType=" + trnType + ", trnDate=" + trnDate + ", trnTime=" + trnTime
				+ ", description=" + description + "]";
	}

	
	
	
}

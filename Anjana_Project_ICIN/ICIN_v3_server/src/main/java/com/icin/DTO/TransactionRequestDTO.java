package com.icin.DTO;

public class TransactionRequestDTO {
	private String receiverAccountNo;
    private String senderAccountNo;
    private String trnPassword;
    private Double trnAmount;
    private String description;
    
	public String getReceiverAccountNo() {
		return receiverAccountNo;
	}
	public void setReceiverAccountNo(String receiverAccountNo) {
		this.receiverAccountNo = receiverAccountNo;
	}
	public String getSenderAccountNo() {
		return senderAccountNo;
	}
	public void setSenderAccountNo(String senderAccountNo) {
		this.senderAccountNo = senderAccountNo;
	}
	public String getTrnPassword() {
		return trnPassword;
	}
	public void setTrnPassword(String trnPassword) {
		this.trnPassword = trnPassword;
	}
	public Double getTrnAmount() {
		return trnAmount;
	}
	public void setTrnAmount(Double trnAmount) {
		this.trnAmount = trnAmount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
    
    
}

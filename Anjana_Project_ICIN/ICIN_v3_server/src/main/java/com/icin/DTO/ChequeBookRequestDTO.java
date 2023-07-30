package com.icin.DTO;

public class ChequeBookRequestDTO {
	
	private String accountType;
    private String description;
    
    public ChequeBookRequestDTO() {
		// TODO Auto-generated constructor stub
	}

	public ChequeBookRequestDTO(String accountType, String description) {
		super();
		this.accountType = accountType;
		this.description = description;
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
    
    
    
}
package com.icin.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icin.Entity.Admin;
import com.icin.Entity.CheckBookReq;
import com.icin.Repository.IAdminRepo;
import com.icin.Repository.IUserChequeReqRepo;

@Service
public class AdminService {
	
	@Autowired
	private IAdminRepo adminRepo;
	
	@Autowired
	private IUserChequeReqRepo checkBookRepo;

	public Admin findUser(String adminUsername, String adminPassword) {
		return adminRepo.findByAdminUsernameAndAdminPassword(adminUsername,adminPassword);
	}

	public List<Object[]> getAllRequestsAdmin() {
		return checkBookRepo.findAllRequests();
	}

}

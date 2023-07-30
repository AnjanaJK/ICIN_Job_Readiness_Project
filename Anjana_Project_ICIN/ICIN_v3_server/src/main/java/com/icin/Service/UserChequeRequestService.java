package com.icin.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icin.Entity.CheckBookReq;
import com.icin.Entity.User;
import com.icin.Repository.IUserChequeReqRepo;
import com.icin.Repository.IUserRepo;

@Service
public class UserChequeRequestService {
	@Autowired
	private IUserChequeReqRepo userRequestRepo;
	
	@Autowired
	private IUserRepo userRepo;

//	public List<Object[]> getAllRequestsAdmin() {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	public List<Object[]> getMyRequests(String accountNum) {
//		User user = userRepo.findByAccountNo(accountNum);
//		return userRequestRepo.findMyRequests(user);
//	}

//	public String generateNewRequest(String accNo, String accType, String desc) {
		
		
//		req.setAccountNo(accNo);
//		return userChequeRequestRepo.save();
//	}

}

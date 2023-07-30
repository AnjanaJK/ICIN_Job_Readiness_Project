package com.icin.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icin.Entity.CheckBookReq;
import com.icin.Entity.User;
import com.icin.Entity.UserLogin;
import com.icin.Repository.IUserChequeReqRepo;
import com.icin.Repository.IUserLogin;
import com.icin.Repository.IUserRepo;

@Service
public class UserService {

	@Autowired
	private IUserLogin userloginRepo;
	@Autowired
	private IUserRepo userRepo;
	
	@Autowired
	private IUserChequeReqRepo reqRepo;
	
	public List<Object[]> getAllData() {
		return userRepo.getAllData();
	}

	public boolean updateStatus(String itemId, int statusValue) {
		User userOptional = userRepo.findByAccountNo(itemId);
        if (userOptional!=null) {
        	userOptional.setUserStatus(statusValue);
            userRepo.save(userOptional);
            return true; // Return true if the item was found and updated successfully
        } else {
            return false; // Return false if the item with the given itemId was not found
        }
	}

	public List<Object[]> getMyData(String accountNo) {
		return userRepo.getMyData(accountNo);
	}

	public boolean updateRequestStatus(int itemId, int statusValue) {
		CheckBookReq req = reqRepo.findBySno(itemId);
		if (req!=null) {
			req.setRequestStatus(statusValue);
			reqRepo.save(req);
			return true; // Return true if the item was found and updated successfully
		} else {
    		return false; // Return false if the item with the given itemId was not found
    	}
	}

	

	
	
	
	
	
//	======================================================================

//	public boolean loginUser(String accountNo, String userPassword) {
//		 User user = userRepo.findByAccountNo(accountNo);
//
//	        if (user != null) {
//	            UserLogin userLogin = userloginRepo.findByUserAndUserPassword(user, userPassword);
//	            if (userLogin != null) {
//	                return true; // Login successful
//	            }
//	        }
//
//	        return false; // Login failed
//	} 
	
//	public UserLogin findUser(User user, String userPassword) {
//		return userloginRepo.findByUserAndUserPassword(user,userPassword);
//	}
//
//	public UserLogin findUser(String accountNo, String userPassword) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}

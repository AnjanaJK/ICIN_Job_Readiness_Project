package com.icin.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icin.Entity.UserLogin;
import com.icin.Repository.IUserLogin;

@Service
public class UserLoginService {
	
	@Autowired
	private IUserLogin userLoginRepo;
	
	public String findUser(String accountNo, String userPassword) {
	    String userLogin = userLoginRepo.findByUserLoginUserAccountNoAndUserPassword(accountNo, userPassword);
	    return userLogin; // Return true if a matching record is found, false otherwise
	}

}

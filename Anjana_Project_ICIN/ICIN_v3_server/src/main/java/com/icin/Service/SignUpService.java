package com.icin.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icin.Entity.User;
import com.icin.Entity.UserLogin;
import com.icin.Repository.IUserLogin;
import com.icin.Repository.IUserRepo;


@Service
public class SignUpService {

	@Autowired
	private IUserRepo userRepo;
	
	@Autowired
	private IUserLogin loginRepo;
	
	public User signup(User user, UserLogin userlogin) {
		
		
		 // Save the user to the USER table
        User savedUser = userRepo.save(user);
        
        // Associate the user with the address before saving it to the USERADDRESS table
        userlogin.setUser(savedUser);
        loginRepo.save(userlogin);
        return savedUser;
	}

}


// =============================================
//public UserLogin findUser(String accountNo, String userPassword) {
//return loginRepo.findByAccountNoAndUserPassword(accountNo,userPassword);
//}

//public boolean findUser(String accountNo, String userPassword) {
//// Find the user by account number from the UserLogin entity
//UserLogin userLogin = loginRepo.findByUser(accountNo);
//
//// Check if the user exists and the provided password matches the stored password
//if (userLogin != null && userLogin.getUserPassword().equals(userPassword)) {
//    return true; // Login successful
//}
//
//return false; // Login failed
//}


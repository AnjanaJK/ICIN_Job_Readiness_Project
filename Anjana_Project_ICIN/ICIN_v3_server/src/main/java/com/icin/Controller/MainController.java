package com.icin.Controller;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.icin.DTO.ChequeBookRequestDTO;
import com.icin.DTO.LoginRequest;
import com.icin.DTO.SignUpRequest;
import com.icin.DTO.TransactionRequestDTO;
import com.icin.Entity.Admin;
import com.icin.Entity.CheckBookReq;
import com.icin.Entity.User;
import com.icin.Entity.UserLogin;
import com.icin.Entity.UserTrn;
import com.icin.Repository.ICheckBookReqRepository;
import com.icin.Repository.IUserChequeReqRepo;
import com.icin.Repository.IUserLogin;
import com.icin.Repository.IUserRepo;
import com.icin.Repository.IUserTrn;
import com.icin.Service.AdminService;
import com.icin.Service.SignUpService;
import com.icin.Service.UserChequeRequestService;
import com.icin.Service.UserService;
import com.icin.Service.UserLoginService;


@RestController
@CrossOrigin(origins="http://localhost:4200")
public class MainController {
	@Autowired
	private SignUpService signupService;
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserLoginService userLoginService;
	
	@Autowired
	private IUserRepo userRepo;
	
	@Autowired
	private IUserLogin userloginRepo;
	
	@Autowired
	private UserChequeRequestService userChequeRequestService;
	
	@Autowired
	private ICheckBookReqRepository checkBookReqRepository;
	
	@Autowired
	private IUserChequeReqRepo userRequestRepo;
	
	@Autowired
	private IUserTrn userTrnRepo;
	
	private static final String ACCOUNT_NO_PREFIX = "ACC";
	
	@PutMapping("/updateStatus/{itemId}")
    public ResponseEntity<?> updateStatus(@PathVariable String itemId, @RequestBody int statusValue) {
//		System.out.println(statusValue);
//		System.out.println(itemId + " | " + statusValue);
        boolean updated = userService.updateStatus(itemId, statusValue);
        if (updated) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
//		return null;
    }
	
	@PutMapping("/updateRequestStatus/{itemId}")
    public ResponseEntity<?> updateRequestStatus(@PathVariable int itemId, @RequestBody int statusValue) {
//		System.out.println(statusValue);
//		System.out.println(itemId + " | " + statusValue);	// sno | 0/1
        boolean updated = userService.updateRequestStatus(itemId, statusValue);
        if (updated) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
//		return null;
    }
//	====================================
//	====================================
//	====================================
//	====================================
	
	@PostMapping("/loginAdmin")
    public ResponseEntity<Admin> loginAdmin(@RequestBody Admin adminData) {
        System.out.println(adminData);

        // check if user is available in the db
        Admin admin = adminService.findUser(adminData.getAdminUsername(), adminData.getAdminPassword());

        if (admin != null && admin.getAdminPassword().equals(adminData.getAdminPassword())) {
            return ResponseEntity.ok(admin);
        } else {
        	System.out.println(admin);
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
	
	@PostMapping("/loginUser")
	public ResponseEntity<?> loginUser(@RequestBody LoginRequest userData) {
		String accNo = userData.getAccountNo();
		String pass = userData.getUserPassword();
		String result = userLoginService.findUser(accNo, pass);
		System.out.println(result);
//		return null;
		String[] userDataArray = result.split(",");

		Map<String, Object> responseData = new HashMap<>();
		responseData.put("userDataArray", userDataArray);
		if (!result.isEmpty()) {
			return ResponseEntity.ok(responseData); // Authentication successful
		} else {
		    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); // Authentication failed
		}
	}
	
//	====================================
//	====================================
//	====================================
//	====================================
	
	@PostMapping("/create")
	public ResponseEntity<Map<String, String>> createUser(@RequestBody SignUpRequest signUpRequest){
		User user = new User();
        user.setUserFirstName(signUpRequest.getUserFirstName());
        user.setUserLastName(signUpRequest.getUserLastName());
        user.setUserEmail(signUpRequest.getUserEmail());
        user.setUserPhoneNo(signUpRequest.getUserPhoneNo());
        user.setUserAddress(signUpRequest.getUserAddress());
        user.setUserLocation(signUpRequest.getUserLocation());
        user.setRole("Customer");
        user.setAccountType("Savings");
        user.setUserStatus(0);	// Deactive
        user.setCurrentBalance(10000.00);
        // Generate the account number
        String accountNumber = generateAccountNumber();

        // Set the generated account number to the user
        user.setAccountNo(accountNumber);
        
        UserLogin userlogin = new UserLogin();
        userlogin.setUserPassword(signUpRequest.getUserPassword());
        userlogin.setTrnPassword(signUpRequest.getTrnPassword());
        

        System.out.println(signUpRequest.getUserPassword());
        System.out.println(user.getAccountNo());
        
        
        signupService.signup(user, userlogin);
        
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("accountNumber", accountNumber);
        
        return ResponseEntity.ok(responseBody);
	}
	
	private String generateAccountNumber() {
        // Get the last account number from the database
        String lastAccountNumber = userRepo.findTopByOrderByAccountNoDesc()
                .map(User::getAccountNo)
                .orElse(ACCOUNT_NO_PREFIX + "0000");

        // Extract the numeric part of the account number and increment it by 1
        int numericPart = Integer.parseInt(lastAccountNumber.substring(ACCOUNT_NO_PREFIX.length()));
        int nextAccountNumber = numericPart + 1;

        return ACCOUNT_NO_PREFIX + String.format("%04d", nextAccountNumber);
    }
	
	
	@GetMapping("/showAll")
	public ResponseEntity<List<Object[]>> viewAll(){
		List<Object[]> allUsers = userService.getAllData();
		return new ResponseEntity<>(allUsers, HttpStatus.OK);		
	}
	
	@GetMapping("/myInfo/{accountNo}")
	public ResponseEntity<List<Object[]>> viewMyInfo(@PathVariable String accountNo){
		List<Object[]> myData = userService.getMyData(accountNo);
		return new ResponseEntity<>(myData, HttpStatus.OK);		
	}
	
	@PostMapping("/chequeBookRequest/{accountNum}")
	public ResponseEntity<?> sendRequest(@PathVariable String accountNum, @RequestBody ChequeBookRequestDTO  requestBody){
		 // Retrieve the User entity using accountNo from the session variable
        User user = userRepo.findByAccountNo(accountNum);

        if (user == null) {
            // Handle if user not found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }

        // Create a new CheckBookRequest entity
        CheckBookReq requestEntity = new CheckBookReq();
        requestEntity.setAccountNo(user); // Link the User entity using the foreign key
        requestEntity.setAccountType(requestBody.getAccountType());
        requestEntity.setDescription(requestBody.getDescription());
        requestEntity.setRequestStatus(0);

        // Save the entity to the database
        checkBookReqRepository.save(requestEntity);

        return ResponseEntity.ok().build();
	}
	
	
	@GetMapping("/myRequests/{accountNum}")
	public ResponseEntity<List<Object[]>> getCheckBookRequestsByAccountNo(@PathVariable String accountNum) {
        List<Object[]> checkBookRequests = userRequestRepo.findByAccountNoAccountNo(accountNum);

        if (checkBookRequests.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        System.out.println("got the Query");
        return ResponseEntity.ok(checkBookRequests);
    }
	
	
	// ADMIN: Show all cheque-book requests
	@GetMapping("/showAllRequests")
	public ResponseEntity<List<Object[]>> viewAllRequests() {
		List<Object[]> allRequests = adminService.getAllRequestsAdmin();
		return new ResponseEntity<>(allRequests, HttpStatus.OK);	
    }
	
	
	// USER: Send Money
	@PostMapping("/processTransaction")
	public ResponseEntity<String> sendTransaction(@RequestBody TransactionRequestDTO requestBody) {
		
		Optional<UserLogin> findUser = userloginRepo.findByUserAccountNo(requestBody.getSenderAccountNo());
		
		// -- check if user exists
		if (findUser != null) {
			UserLogin foundUserDetails = findUser.get();
			System.out.println("Trn Pass = " + foundUserDetails.getTrnPassword());
			
			// --- if trnPassword matches
			if (foundUserDetails.getTrnPassword().equals(requestBody.getTrnPassword())) {
				System.out.println("--- Password Matches");
				// Passwords match, proceed with the transaction logic
				// Fetch details from form data
	              String receiverAccountNo = requestBody.getReceiverAccountNo();
	              String senderAccountNo = requestBody.getSenderAccountNo();
	              String trnPassword = requestBody.getTrnPassword();
	              Double trnAmount = requestBody.getTrnAmount();
	              String description = requestBody.getDescription();
              	
	            // Find the sender and receiver User entities based on account numbers
		          User sender = userRepo.findByAccountNo(requestBody.getSenderAccountNo());
		          User receiver = userRepo.findByAccountNo(requestBody.getReceiverAccountNo());
		          
		          if (sender == null || receiver == null) {
		          	System.out.println("Sender/Receiver null");
		          	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Transaction failed: User not found");
		          }
		          else {
		        	  // --- If sender/receiver is found
		        	  // Create UserTrn entity and set its values

		        	  // ---- if sender's balance is below 1000.00, then insufficient funds error
		        	  if(sender.getCurrentBalance() < 1000 || sender.getCurrentBalance() < trnAmount) {
		        		  // 403 Forbidden: The server understood the request, but the server refuses to authorize it (even with valid credentials).
		        		  return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Transaction failed: Insufficient funds in your A/C");
		        	  }
		        	  else {
		        		  String debitType = "Debit";
				            if("Debit".equals(debitType)) {
				            	Double newSenderBalance = sender.getCurrentBalance() - trnAmount;
					          	sender.setCurrentBalance(newSenderBalance);
					          	UserTrn debitTransaction = new UserTrn();
					          	debitTransaction.setSender(sender.getAccountNo());
					          	debitTransaction.setReceiver(receiver.getAccountNo());
					          	debitTransaction.setBalance(newSenderBalance);
					          	debitTransaction.setTrnAmt(trnAmount);
					          	debitTransaction.setTrnType(debitType);
					          	debitTransaction.setTrnDate(LocalDate.now());
					          	debitTransaction.setTrnTime(LocalTime.now());
					          	debitTransaction.setDescription(description);
					          	userTrnRepo.save(debitTransaction);
				             }
				            
				            String creditType = "Credit";
				            if("Credit".equals(creditType)) {
				            	Double newReceiverBalance = receiver.getCurrentBalance() + trnAmount;
				                receiver.setCurrentBalance(newReceiverBalance);
				                UserTrn creditTransaction = new UserTrn();
				                creditTransaction.setSender(sender.getAccountNo());
				                creditTransaction.setReceiver(receiver.getAccountNo());
				                creditTransaction.setBalance(newReceiverBalance);
				                creditTransaction.setTrnAmt(trnAmount);
				                creditTransaction.setTrnType(creditType);
				                creditTransaction.setTrnDate(LocalDate.now());
				                creditTransaction.setTrnTime(LocalTime.now());
				                creditTransaction.setDescription(description);
				                userTrnRepo.save(creditTransaction);
				            }
				            System.out.println("TRN SUCCESS!");
				            userRepo.save(sender);
				            userRepo.save(receiver);
				            System.out.println("Saved!");
				            return ResponseEntity.status(HttpStatus.OK).body("{\"message\": \"Transaction successful!\"}");
		        	  }
			           
		          }
			}
			// --- if trnPassword does not match
			else {
				System.out.println("PASSWORD INCORRECT!");
            	// Passwords don't match, transaction failed
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Transaction failed: Password does not match");
			}
		}
		// -- if user does not exist
		else {
			// UserLogin not found, transaction failed
			System.out.println("Something went wrong");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Transaction failed: User not found");
		}
	
	}
	
	
	@GetMapping("/myTransactions/{accountNum}")
	public ResponseEntity<List<Object[]>> getUserTrn(@PathVariable String accountNum) {
        List<Object[]> myTrn = userTrnRepo.findByAccountNo(accountNum);

        if (myTrn.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        System.out.println("got the Query");
        return ResponseEntity.ok(myTrn);
    }
	

}

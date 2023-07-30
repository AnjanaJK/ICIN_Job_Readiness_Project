package com.icin.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.icin.Entity.User;
import com.icin.Entity.UserLogin;

public interface IUserRepo extends JpaRepository<User, Long> {

	Optional<User> findTopByOrderByAccountNoDesc();

	@Query("SELECT u.accountNo, u.userFirstName, u.userLastName, u.userStatus FROM User u ")
	List<Object[]> getAllData();

	User findByAccountNo(String itemId);

	@Query("SELECT u.accountNo, u.accountType, u.userFirstName, u.userLastName, u.userAddress, u.userLocation, u.userEmail, u.userPhoneNo, u.userStatus, u.currentBalance "
			+ "FROM User u "
			+ "WHERE u.accountNo = :accountNo")
	List<Object[]> getMyData(@Param("accountNo") String accountNo);

}

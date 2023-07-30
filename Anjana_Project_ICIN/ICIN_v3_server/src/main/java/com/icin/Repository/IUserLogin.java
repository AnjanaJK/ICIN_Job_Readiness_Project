package com.icin.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.icin.Entity.User;
import com.icin.Entity.UserLogin;

public interface IUserLogin extends JpaRepository<UserLogin, Integer>{

	UserLogin findByUserAndUserPassword(User user, String userPassword);

	@Query("SELECT u.accountNo, ul.userPassword, u.role, u.userFirstName, u.userLastName, u.userStatus "
			+ "FROM User u "
			+ "JOIN UserLogin ul "
			+ "ON u.accountNo = ul.user.accountNo "
			+ "WHERE ul.user.accountNo = :accountNo AND ul.userPassword = :userPassword")
	String findByUserLoginUserAccountNoAndUserPassword(@Param("accountNo") String accountNo, @Param("userPassword") String userPassword);

	Optional<UserLogin> findByUserAccountNo(String senderAccountNo);

}

//UserLogin findByAccountNoAndUserPassword(String accountNo, String userPassword);

//UserLogin findByUser(String accountNo);

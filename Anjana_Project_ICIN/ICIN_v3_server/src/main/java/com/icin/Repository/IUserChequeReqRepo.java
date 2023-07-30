package com.icin.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.icin.Entity.CheckBookReq;
import com.icin.Entity.User;

@Repository
public interface IUserChequeReqRepo extends JpaRepository<CheckBookReq, Integer> {
	
	@Query("SELECT c.sno, u.accountNo, c.accountType, c.description, c.requestStatus "
			+ "FROM CheckBookReq c "
			+ "JOIN User u "
			+ "ON c.accountNo.accountNo = u.accountNo "
			+ "WHERE u.accountNo = :accountNo")
	List<Object[]> findByAccountNoAccountNo(@Param("accountNo") String accountNo);
	
	
	@Query("SELECT c.sno, u.accountNo, u.userFirstName, u.userLastName, c.accountType, c.description, c.requestStatus "
			+ "FROM CheckBookReq c "
			+ "JOIN User u "
			+ "ON c.accountNo.accountNo = u.accountNo")
	List<Object[]> findAllRequests();


	CheckBookReq findBySno(int itemId);


}


//@Query("SELECT c.sno, c.accountNo, c.accountType, c.description, c.requestStatus "
//+ "FROM CheckBookReq c "
//+ "WHERE c.accountNo = :accountNo")
//List<Object[]> findMyRequests(@Param("accountNo") User user);

//List<CheckBookReq> findMyRequests(User user);

//List<CheckBookReq> findByUserAccountNo(User user);

//@Query(SELECT)
//CheckBookReq findByAccountNo();

//select c.sno, c.req_status, u.account_no
//from check_book_req as c
//join user as u
//on c.account_no = u.account_no
//where u.account_no = 'ACC0008';
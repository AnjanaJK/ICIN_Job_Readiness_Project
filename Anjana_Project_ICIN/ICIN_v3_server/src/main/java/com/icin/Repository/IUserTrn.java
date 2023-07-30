package com.icin.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.icin.Entity.UserTrn;

public interface IUserTrn extends JpaRepository<UserTrn, Integer>{

	@Query("SELECT trn.id, trn.trnDate, trn.sender, trn.receiver, trn.trnAmt, trn.balance, trn.trnType, trn.description "
			+ "FROM UserTrn trn "
			+ "WHERE trn.sender = :accountNum AND trnType = 'Debit' "
			+ "OR trn.receiver = :accountNum AND trnType = 'Credit'")
	List<Object[]> findByAccountNo(@Param("accountNum") String accountNum);
	
}


/*
 * select * from user_trn 
 * where sender_account_no = 'ACC0010' AND trn_type = 'Debit'
 * OR receiver_account_no = 'ACC0010' AND trn_type = 'Credit';
 */
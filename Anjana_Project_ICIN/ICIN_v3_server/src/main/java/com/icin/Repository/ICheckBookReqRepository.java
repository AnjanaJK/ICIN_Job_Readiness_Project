package com.icin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icin.Entity.CheckBookReq;

public interface ICheckBookReqRepository extends JpaRepository<CheckBookReq, Integer> {

}

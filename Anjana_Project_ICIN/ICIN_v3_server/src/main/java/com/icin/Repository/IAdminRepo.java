package com.icin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icin.Entity.Admin;

public interface IAdminRepo extends JpaRepository<Admin, Integer> {

	Admin findByAdminUsernameAndAdminPassword(String adminUsername, String adminPassword);

}

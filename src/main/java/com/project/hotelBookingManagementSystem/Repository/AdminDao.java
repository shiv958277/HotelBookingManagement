package com.project.hotelBookingManagementSystem.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.hotelBookingManagementSystem.Models.Admin;

public interface AdminDao extends JpaRepository<Admin,Integer>{
	Optional<Admin> findByEmail(String email);
}

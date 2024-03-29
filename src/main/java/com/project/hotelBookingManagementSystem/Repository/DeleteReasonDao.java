package com.project.hotelBookingManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.hotelBookingManagementSystem.Models.DeleteReason;

public interface DeleteReasonDao extends JpaRepository<DeleteReason, Long>{

}

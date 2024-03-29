package com.project.hotelBookingManagementSystem.Service;

import com.project.hotelBookingManagementSystem.Exceptions.AdminException;
import com.project.hotelBookingManagementSystem.Models.Admin;

public interface AdminService {
	public Admin registerAdmin(Admin admin) throws AdminException;
	
}

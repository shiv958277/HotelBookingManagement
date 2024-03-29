package com.project.hotelBookingManagementSystem.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.hotelBookingManagementSystem.Models.Admin;
import com.project.hotelBookingManagementSystem.Service.AdminService;

import lombok.AllArgsConstructor;


/**
 * @author Shivani_Verma
 * @version 1.0
 * @package com.project.hotelBookingManagementSystem.Controller
 * @project hotelBookingManagementSystem
 * @since   28-Mar-2024
 */
@RestController
@RequestMapping("/staywell/admins")
@AllArgsConstructor
public class AdminController {

	private AdminService adminService;
	
	@PostMapping("/register")
	public ResponseEntity<Admin> registerAdmin(@RequestBody Admin admin){
		
		Admin res = adminService.registerAdmin(admin);
		
		return new ResponseEntity<Admin>(res,HttpStatus.CREATED);
	}
}

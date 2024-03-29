package com.project.hotelBookingManagementSystem.Service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.hotelBookingManagementSystem.Enums.Role;
import com.project.hotelBookingManagementSystem.Exceptions.AdminException;
import com.project.hotelBookingManagementSystem.Models.Admin;
import com.project.hotelBookingManagementSystem.Repository.AdminDao;
import com.project.hotelBookingManagementSystem.Service.AdminService;
import com.project.hotelBookingManagementSystem.Service.CustomDetailsService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
@Transactional
public class AdminServiceImpl implements AdminService {

	private AdminDao aDao;
	private PasswordEncoder passwordEncoder;
	@Autowired
	CustomDetailsService customerUser;

	@Override
	public Admin registerAdmin(Admin admin) throws AdminException {
		Optional<Admin> adminExist = aDao.findByEmail(admin.getEmail());

		if (adminExist.isPresent()) {
			throw new AdminException("Admin already registered with this email!");
		}
		System.err.println(admin.getPassword());
		String hashedPassword = passwordEncoder.encode(admin.getPassword());
		admin.setPassword(hashedPassword);
		admin.setRole(Role.ROLE_ADMIN);
		customerUser.loadUserByUsername(admin.getEmail());
		return aDao.save(admin);
	}
}

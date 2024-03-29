package com.project.hotelBookingManagementSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.hotelBookingManagementSystem.Models.Admin;
import com.project.hotelBookingManagementSystem.Models.Customer;
import com.project.hotelBookingManagementSystem.Models.Hotel;
import com.project.hotelBookingManagementSystem.Repository.AdminDao;
import com.project.hotelBookingManagementSystem.Repository.CustomerDao;
import com.project.hotelBookingManagementSystem.Repository.HotelDao;


/**
 * @author Shivani_Verma
 * @version 1.0
 * @package com.project.hotelBookingManagementSystem.Controller
 * @project hotelBookingManagementSystem
 * @since   28-Mar-2024
 */
@RestController
@RequestMapping("/staywell")
public class LoginController {
    @Autowired
    private AdminDao adminDao;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private HotelDao hotelDao;

    @PostMapping("/admins/login")
    public ResponseEntity<Admin> getLoggedInAdminDetailsHandler(Authentication auth) {
    	System.err.println("--"+auth);
        Admin admin = adminDao.findByEmail(auth.getName())
                .orElseThrow(() -> new BadCredentialsException("Invalid Username or password"));
        return new ResponseEntity<>(admin, HttpStatus.ACCEPTED);
    }

    @PostMapping("/customers/login")
    public ResponseEntity<Customer> getLoggedInCustomerDetailsHandler(Authentication auth) {
        Customer customer = customerDao.findByEmail(auth.getName())
                .orElseThrow(() -> new BadCredentialsException("Invalid Username or password"));
        return new ResponseEntity<>(customer, HttpStatus.ACCEPTED);
    }

    @PostMapping("/hotels/login")
    public ResponseEntity<Hotel> getLoggedInHotelDetailsHandler(Authentication auth) {
        Hotel hotel = hotelDao.findByHotelEmail(auth.getName())
                .orElseThrow(() -> new BadCredentialsException("Invalid Username or password"));
        return new ResponseEntity<>(hotel, HttpStatus.ACCEPTED);
    }
    
}    

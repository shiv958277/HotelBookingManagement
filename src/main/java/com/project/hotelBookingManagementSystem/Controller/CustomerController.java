package com.project.hotelBookingManagementSystem.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.hotelBookingManagementSystem.Dto.Request.CustomerRequest;
import com.project.hotelBookingManagementSystem.Dto.Request.UpdatePasswordRequest;
import com.project.hotelBookingManagementSystem.Dto.Request.UpdateRequest;
import com.project.hotelBookingManagementSystem.Dto.Response.CustomerResponse;
import com.project.hotelBookingManagementSystem.Service.CustomerService;

import lombok.AllArgsConstructor;

/**
 * @author Shivani_Verma
 * @version 1.0
 * @package com.project.hotelBookingManagementSystem.Controller
 * @project hotelBookingManagementSystem
 * @since   28-Mar-2024
 */
@RestController
@RequestMapping("/staywell/customers")
@AllArgsConstructor
public class CustomerController {

	private CustomerService customerService;

	@PostMapping("/register")
	public ResponseEntity<CustomerResponse> registerCustomer(@RequestBody CustomerRequest customerRequest) {
		CustomerResponse res = customerService.registerCustomer(customerRequest);
		return new ResponseEntity<>(res, HttpStatus.CREATED);
	}

	@PutMapping("/update/name")
	public ResponseEntity<String> updateName(@RequestBody UpdateRequest updateRequest) {
		String res = customerService.updateName(updateRequest);
		return new ResponseEntity<>(res, HttpStatus.OK);

	}

	@PutMapping("/update/password")
	public ResponseEntity<String> updatePassword(@RequestBody UpdatePasswordRequest updatePasswordRequest) {
		String res = customerService.updatePassword(updatePasswordRequest);
		return new ResponseEntity<>(res, HttpStatus.OK);

	}

	@PutMapping("/update/phone")
	public ResponseEntity<String> updatePhone(@RequestBody UpdateRequest updateRequest) {
		String res = customerService.updatePhone(updateRequest);
		return new ResponseEntity<>(res, HttpStatus.OK);

	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteCustomer(@RequestBody UpdateRequest updateRequest) {
		String res = customerService.deleteCustomer(updateRequest);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@GetMapping("/view-profile")
	public ResponseEntity<CustomerResponse> getCustomerById() {
		CustomerResponse res = customerService.viewProfile();
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@GetMapping("/get/to-be-deleted")
	public ResponseEntity<List<CustomerResponse>> getAllCustomer() {
		List<CustomerResponse> res = customerService.getToBeDeletedCustomers();
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

}

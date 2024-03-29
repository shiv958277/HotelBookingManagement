package com.project.hotelBookingManagementSystem.Service;

import java.util.List;

import com.project.hotelBookingManagementSystem.Dto.Request.CustomerRequest;
import com.project.hotelBookingManagementSystem.Dto.Request.UpdatePasswordRequest;
import com.project.hotelBookingManagementSystem.Dto.Request.UpdateRequest;
import com.project.hotelBookingManagementSystem.Dto.Response.CustomerResponse;

public interface CustomerService {

	public CustomerResponse registerCustomer(CustomerRequest customerRequest);

	public String updateName(UpdateRequest updateRequest);

	public String updatePassword(UpdatePasswordRequest updatePasswordRequest);

	public String updatePhone(UpdateRequest updateRequest);

	public String deleteCustomer(UpdateRequest updateRequest);

	public List<CustomerResponse> getToBeDeletedCustomers();

	public CustomerResponse viewProfile();

}

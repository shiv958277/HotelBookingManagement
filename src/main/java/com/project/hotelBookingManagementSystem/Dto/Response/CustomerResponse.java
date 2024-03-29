package com.project.hotelBookingManagementSystem.Dto.Response;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.hotelBookingManagementSystem.Enums.Gender;
import com.project.hotelBookingManagementSystem.Models.Address;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author Shivani_Verma
 * @version 1.0
 * @package com.project.hotelBookingManagementSystem.Dto.Response
 * @project hotelBookingManagementSystem
 * @since   28-Mar-2024
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerResponse {

	private Long customerId;

	private String name;

	private String email;

	private String phone;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate dob;

	private Address address;

	@JsonFormat(pattern = "dd-MM-yyyy HH:mm")
	private LocalDateTime registrationDateTime;

}

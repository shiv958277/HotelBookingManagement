package com.project.hotelBookingManagementSystem.Dto.Request;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.hotelBookingManagementSystem.Dto.Payment;

import jakarta.validation.Valid;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author Shivani_Verma
 * @version 1.0
 * @package com.project.hotelBookingManagementSystem.Dto.Request
 * @project hotelBookingManagementSystem
 * @since   28-Mar-2024
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationRequest {

	@FutureOrPresent
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate checkinDate;

	@FutureOrPresent
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate checkoutDate;

	@Min(1)
	private Integer noOfPerson;

	@Valid
	private Payment payment;

}

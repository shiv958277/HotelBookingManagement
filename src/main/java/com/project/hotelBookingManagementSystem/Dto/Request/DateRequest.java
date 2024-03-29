package com.project.hotelBookingManagementSystem.Dto.Request;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
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
public class DateRequest {

	@NotNull @FutureOrPresent
	@JsonFormat(pattern = "dd-MM-yyyy")
	LocalDate checkIn;

	@NotNull @FutureOrPresent
	@JsonFormat(pattern = "dd-MM-yyyy")
	LocalDate checkOut;

}

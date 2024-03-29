package com.project.hotelBookingManagementSystem.Dto.Response;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.hotelBookingManagementSystem.Dto.Payment;
import com.project.hotelBookingManagementSystem.Enums.ReservationStatus;

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
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationResponse {

	private Long reservationId;

	private String customerName;

	private Integer roomNumber;

	private String hotelName;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate checkinDate;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate checkoutDate;

	private Integer noOfPerson;

	private Payment payment;

	private ReservationStatus status;

}

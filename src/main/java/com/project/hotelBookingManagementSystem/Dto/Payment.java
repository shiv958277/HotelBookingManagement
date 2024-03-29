package com.project.hotelBookingManagementSystem.Dto;

import com.project.hotelBookingManagementSystem.Enums.PaymentType;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author Shivani_Verma
 * @version 1.0
 * @package com.project.hotelBookingManagementSystem.Dto
 * @project hotelBookingManagementSystem
 * @since   28-Mar-2024
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

	@NotNull
	@Enumerated(EnumType.STRING)
	private PaymentType paymentType;

	@NotNull @NotEmpty @NotBlank
	private String txnId;

}

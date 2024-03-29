package com.project.hotelBookingManagementSystem.Dto.Request;

import java.math.BigDecimal;

import com.project.hotelBookingManagementSystem.Enums.RoomType;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
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
public class RoomRequest {

	@NotNull
	private char[] password;

	@Min(1)
	private Integer roomNumber;

	@NotNull
	@Enumerated(EnumType.STRING)
	private RoomType roomType;

	@Min(1)
	private Integer noOfPerson;

	@Min(100)
	private BigDecimal price;

	@NotNull
	private Boolean available;

}

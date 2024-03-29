package com.project.hotelBookingManagementSystem.Dto.Response;

import java.math.BigDecimal;

import com.project.hotelBookingManagementSystem.Enums.RoomType;

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
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomResponse {

	private Long roomId;

	private Integer roomNumber;

	@Enumerated(EnumType.STRING)
	private RoomType roomType;

	private Integer noOfPerson;

	private BigDecimal price;

	private Boolean available;

}

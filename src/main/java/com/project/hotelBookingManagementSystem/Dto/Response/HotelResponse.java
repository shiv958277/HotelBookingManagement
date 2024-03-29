package com.project.hotelBookingManagementSystem.Dto.Response;

import java.util.List;

import com.project.hotelBookingManagementSystem.Enums.HotelType;
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
public class HotelResponse {

	private Long hotelId;

	private String name;

	private String hotelTelephone;

	private Address address;

	@Enumerated(EnumType.STRING)
	private HotelType hotelType;

	private List<String> amenities;

}

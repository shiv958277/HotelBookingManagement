package com.project.hotelBookingManagementSystem.Dto.Request;

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
public class UpdatePasswordRequest {

	@NotNull
	private char[] newPassword;

	@NotNull
	private char[] currentPassword;

}

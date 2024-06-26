package com.project.hotelBookingManagementSystem.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.hotelBookingManagementSystem.Dto.Request.HotelRequest;
import com.project.hotelBookingManagementSystem.Dto.Request.UpdatePasswordRequest;
import com.project.hotelBookingManagementSystem.Dto.Request.UpdateRequest;
import com.project.hotelBookingManagementSystem.Dto.Response.HotelResponse;
import com.project.hotelBookingManagementSystem.Service.HotelService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;


/**
 * @author Shivani_Verma
 * @version 1.0
 * @package com.project.hotelBookingManagementSystem.Controller
 * @project hotelBookingManagementSystem
 * @since   28-Mar-2024
 */
@RestController
@RequestMapping("/staywell/hotels")
@AllArgsConstructor
public class HotelController {

	private HotelService hotelService;

	@PostMapping("/register")
	public ResponseEntity<HotelResponse> registerHotel(@Valid @RequestBody HotelRequest hotelRequest) {
		return new ResponseEntity<>(hotelService.registerHotel(hotelRequest), HttpStatus.CREATED);
	}

	@PutMapping("/update/name")
	public ResponseEntity<String> updateName(@RequestBody UpdateRequest updateDetailsRequest) {
		return new ResponseEntity<>(hotelService.updateName(updateDetailsRequest), HttpStatus.ACCEPTED);
	}

	@PutMapping("/update/password")
	public ResponseEntity<String> updatePassword(@RequestBody UpdatePasswordRequest updatePasswordRequest) {
		String res = hotelService.updatePassword(updatePasswordRequest);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@PutMapping("/update/phone")
	public ResponseEntity<String> updatePhone(@RequestBody UpdateRequest updateDetailsRequest) {
		return new ResponseEntity<>(hotelService.updatePhone(updateDetailsRequest), HttpStatus.ACCEPTED);
	}

	@PutMapping("/update/telephone")
	public ResponseEntity<String> updateTelephone(@RequestBody UpdateRequest updateDetailsRequest) {
		return new ResponseEntity<>(hotelService.updateTelephone(updateDetailsRequest), HttpStatus.ACCEPTED);
	}

	@PutMapping("/update/hoteltype")
	public ResponseEntity<String> updateHotelType(@RequestBody UpdateRequest updateDetailsRequest) {
		return new ResponseEntity<>(hotelService.updateHotelType(updateDetailsRequest), HttpStatus.ACCEPTED);
	}

	@GetMapping("/get/by-id/{hotelId}")
	public ResponseEntity<HotelResponse> getHotelById(@PathVariable("hotelId") long hotelId) {
		return new ResponseEntity<>(hotelService.getHotelById(hotelId), HttpStatus.FOUND);
	}

	@GetMapping("/near-me")
	public ResponseEntity<List<HotelResponse>> getHotelsNearMe() {
		ResponseEntity<List<HotelResponse>> responseEntity = new ResponseEntity<>(hotelService.getHotelsNearMe(),
				HttpStatus.FOUND);
		return responseEntity;
	}

	@GetMapping("/in-city/{city}")
	public ResponseEntity<List<HotelResponse>> getHotelsInCity(@PathVariable String city) {
		ResponseEntity<List<HotelResponse>> responseEntity = new ResponseEntity<>(hotelService.getHotelsInCity(city),
				HttpStatus.FOUND);
		return responseEntity;
	}

}

package com.project.hotelBookingManagementSystem.Service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.hotelBookingManagementSystem.Dto.Request.HotelRequest;
import com.project.hotelBookingManagementSystem.Dto.Request.UpdatePasswordRequest;
import com.project.hotelBookingManagementSystem.Dto.Request.UpdateRequest;
import com.project.hotelBookingManagementSystem.Dto.Response.HotelResponse;
import com.project.hotelBookingManagementSystem.Enums.HotelType;
import com.project.hotelBookingManagementSystem.Enums.Role;
import com.project.hotelBookingManagementSystem.Exceptions.CustomerException;
import com.project.hotelBookingManagementSystem.Exceptions.HotelException;
import com.project.hotelBookingManagementSystem.Models.Address;
import com.project.hotelBookingManagementSystem.Models.Customer;
import com.project.hotelBookingManagementSystem.Models.Hotel;
import com.project.hotelBookingManagementSystem.Repository.CustomerDao;
import com.project.hotelBookingManagementSystem.Repository.HotelDao;
import com.project.hotelBookingManagementSystem.Service.HotelService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
@Transactional
public class HotelServiceImpl implements HotelService {

	private HotelDao hotelDao;
	private CustomerDao customerDao;
	private PasswordEncoder passwordEncoder;

	@Override
	public HotelResponse registerHotel(HotelRequest hotelRequest) {

		log.info("Performing email validation");
		if (isEmailExists(hotelRequest.getHotelEmail())) {
			throw new HotelException("This email is already registered. Please use a different email to register.");
		}

		log.info("Verifying Hotel name");
		if (hotelWithNameAlreadyExitsInYourCity(hotelRequest.getName(), hotelRequest.getAddress())) {
			throw new HotelException("Hotel already exits in your city with name : " + hotelRequest.getName());
		}

		Hotel hotel = buildHotel(hotelRequest);
		hotelDao.save(hotel);

		log.info("Registration successfull");
		return buildHotelResponse(hotel);
	}

	@Override
	public String updateName(UpdateRequest updateRequest) {
		Hotel currentHotel = getCurrentLoggedInHotel();

		log.info("Verifying credentials");
		String password = new String(updateRequest.getPassword());
		if (!passwordEncoder.matches(password, currentHotel.getPassword())) {
			throw new HotelException("Wrong credentials!");
		}
		hotelDao.setNameOfHotel(currentHotel.getHotelId(), updateRequest.getField());

		log.info("Updation successfull");
		return "Updated hotel name successfully";
	}

	@Override
	public String updatePassword(UpdatePasswordRequest updatePasswordRequest) {
		Hotel currentHotel = getCurrentLoggedInHotel();

		log.info("Verifying credentials");
		String currentPassword = new String(updatePasswordRequest.getCurrentPassword());
		if (!passwordEncoder.matches(currentPassword, currentHotel.getPassword())) {
			throw new HotelException("Wrong credentials!");
		}

		log.info("Validating new password");
		String newPassword = new String(updatePasswordRequest.getNewPassword());
		if (!matchesRegex(newPassword)) {
			throw new CustomerException("New password validation failed!");
		}

		hotelDao.setHotelPassword(currentHotel.getHotelId(), passwordEncoder.encode(newPassword));

		log.info("Updation successfull");
		return "Password updated successfully!";
	}

	@Override
	public String updatePhone(UpdateRequest updateRequest) {
		Hotel currentHotel = getCurrentLoggedInHotel();

		log.info("Verifying credentials");
		String password = new String(updateRequest.getPassword());
		if (!passwordEncoder.matches(password, currentHotel.getPassword())) {
			throw new HotelException("Wrong credentials!");
		}
		hotelDao.setPhoneOfHotel(currentHotel.getHotelId(), updateRequest.getField());

		log.info("Updation successfull");
		return "Updated hotel phone successfully";
	}

	@Override
	public String updateTelephone(UpdateRequest updateRequest) {
		Hotel currentHotel = getCurrentLoggedInHotel();

		log.info("Verifying credentials");
		String password = new String(updateRequest.getPassword());
		if (!passwordEncoder.matches(password, currentHotel.getPassword())) {
			throw new HotelException("Wrong credentials!");
		}
		hotelDao.setTelephoneOfHotel(currentHotel.getHotelId(), updateRequest.getField());

		log.info("Updation successfull");
		return "Updated hotel telephone successfully";
	}

	@Override
	public String updateHotelType(UpdateRequest updateRequest) {
		Hotel hotel = getCurrentLoggedInHotel();

		log.info("Verifying credentials");
		String password = new String(updateRequest.getPassword());
		if (!passwordEncoder.matches(password, hotel.getPassword())) {
			throw new HotelException("Wrong credentials!");
		}
		hotelDao.setHotelType(hotel.getHotelId(), HotelType.valueOf(updateRequest.getField()));

		log.info("Updation successfull");
		return "Updated hotel type successfully";
	}

	@Override
	public HotelResponse getHotelById(Long id) {
		Optional<Hotel> optional = hotelDao.findById(id);
		if (optional.isPresent())
			return buildHotelResponse(optional.get());
		throw new HotelException("No hotel found with id " + id);
	}

	@Override
	public List<HotelResponse> getHotelsNearMe() {
		Customer customer = getCurrentLoggedInCustomer();
		System.out.println(111);
		List<Hotel> hotels = hotelDao.getHotelByCity(customer.getAddress().getCity());
		System.out.println(222);
		if (hotels.isEmpty())
			throw new HotelException("Hotels Not Found In Your Area!");
		return hotels.stream().map(this::buildHotelResponse).collect(Collectors.toList());
	}

	@Override
	public List<HotelResponse> getHotelsInCity(String city) {
		List<Hotel> hotels = hotelDao.getHotelByCity(city);
		if (hotels.isEmpty())
			throw new HotelException("Hotels Not Found In Your Area!");
		return hotels.stream().map(this::buildHotelResponse).collect(Collectors.toList());
	}

	private boolean isEmailExists(String email) {
		return customerDao.findByEmail(email).isPresent() || hotelDao.findByHotelEmail(email).isPresent();
	}

	private Hotel getCurrentLoggedInHotel() {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		return hotelDao.findByHotelEmail(email).get();
	}

	private Customer getCurrentLoggedInCustomer() {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		return customerDao.findByEmail(email).get();
	}

	private boolean hotelWithNameAlreadyExitsInYourCity(String name, Address address) {
		Optional<Hotel> opt = hotelDao.getHotelByNameAndCity(name, address.getCity());
		if (opt.isPresent())
			return true;
		return false;
	}

	private boolean matchesRegex(String input) {
		if(input.length()<8)
			return false;
		String regex = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
		return Pattern.compile(regex).matcher(input).matches();
	}

	private Hotel buildHotel(HotelRequest hotelRequest) {
		return Hotel.builder()
				.name(hotelRequest.getName())
				.hotelEmail(hotelRequest.getHotelEmail()).password(passwordEncoder.encode(new String(hotelRequest.getPassword())))
				.hotelPhone(hotelRequest.getHotelPhone())
				.hotelTelephone(hotelRequest.getHotelTelephone())
				.role(Role.ROLE_HOTEL)
				.hotelType(hotelRequest.getHotelType())
				.address(hotelRequest.getAddress())
				.amenities(hotelRequest.getAmenities())
				.rooms(new ArrayList<>()).reservations(new ArrayList<>()).feedbacks(new ArrayList<>())
				.build();
	}

	private HotelResponse buildHotelResponse(Hotel hotel) {
		return HotelResponse.builder()
				.hotelId(hotel.getHotelId())
				.name(hotel.getName())
				.hotelTelephone(hotel.getHotelTelephone())
				.address(hotel.getAddress())
				.hotelType(hotel.getHotelType())
				.amenities(hotel.getAmenities())
				.build();
	}
}

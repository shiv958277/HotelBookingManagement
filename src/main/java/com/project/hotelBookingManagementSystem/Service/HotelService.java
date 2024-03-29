package com.project.hotelBookingManagementSystem.Service;

import java.util.List;

import com.project.hotelBookingManagementSystem.Dto.Request.HotelRequest;
import com.project.hotelBookingManagementSystem.Dto.Request.UpdatePasswordRequest;
import com.project.hotelBookingManagementSystem.Dto.Request.UpdateRequest;
import com.project.hotelBookingManagementSystem.Dto.Response.HotelResponse;

public interface HotelService {

	public HotelResponse registerHotel(HotelRequest hotelRequest);

	public String updateName(UpdateRequest updateRequest);

	public String updatePassword(UpdatePasswordRequest updatePasswordRequest);

	public String updatePhone(UpdateRequest updateRequest);

	public String updateTelephone(UpdateRequest updateRequest);

	public String updateHotelType(UpdateRequest updateRequest);

	public HotelResponse getHotelById(Long id);

	public List<HotelResponse> getHotelsNearMe();

	public List<HotelResponse> getHotelsInCity(String city);

}

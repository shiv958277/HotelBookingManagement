package com.project.hotelBookingManagementSystem.Service;

import java.util.List;

import com.project.hotelBookingManagementSystem.Dto.Request.DateRequest;
import com.project.hotelBookingManagementSystem.Dto.Request.RoomRequest;
import com.project.hotelBookingManagementSystem.Dto.Request.UpdateRequest;
import com.project.hotelBookingManagementSystem.Dto.Response.RoomResponse;

public interface RoomService {

	public RoomResponse addRoom(RoomRequest roomRequest);

	public String updateRoomType(UpdateRequest updateRequest, Long roomId);

	public String updateNoOfPerson(UpdateRequest updateRequest, Long roomId);

	public String updatePrice(UpdateRequest updateRequest, Long roomId);

	public String updateAvailable(UpdateRequest updateRequest, Long roomId);

	public String removeRoom(UpdateRequest updateRequest);

	public List<RoomResponse> getAllAvailableRoomsByHotelId(Long hotelId, DateRequest dateRequest);

	public List<RoomResponse> getAllRoomsByHotel();

}

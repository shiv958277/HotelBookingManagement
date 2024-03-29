package com.project.hotelBookingManagementSystem.Service;

import java.util.List;

import com.project.hotelBookingManagementSystem.Dto.Request.ReservationRequest;
import com.project.hotelBookingManagementSystem.Dto.Response.ReservationResponse;

public interface ReservationService {

	public ReservationResponse createReservation(Long roomId, ReservationRequest reservationRequest);

	public String cancelReservation(Long reservationId);

	public List<ReservationResponse> getAllReservationsOfHotel();

	public List<ReservationResponse> getAllReservationsOfCustomer();

	public ReservationResponse getReservationById(Long ReservationId);

}

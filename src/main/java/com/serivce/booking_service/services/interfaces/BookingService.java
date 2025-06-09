package com.serivce.booking_service.services.interfaces;

import com.serivce.booking_service.controllers.model.Requests.CreateBookingRequest;

import java.util.UUID;

public interface BookingService{

    public String createBooking(CreateBookingRequest request);

    public String returnBooking(int bookingId);

    public String updateBooking(CreateBookingRequest request);

    public String deleteBooking(UUID userId, int movieId);
}
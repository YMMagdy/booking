package com.serivce.booking_service.services.interfaces;

import com.serivce.booking_service.controllers.model.Requests.CreateBookingRequest;
import com.serivce.booking_service.model.Booking;

import java.util.UUID;

public interface BookingService{

    public Booking createBooking(CreateBookingRequest request);

    public String returnBooking(int bookingId);

    public String updateBooking(CreateBookingRequest request);

    public String deleteBooking(UUID userId, int movieId);
}
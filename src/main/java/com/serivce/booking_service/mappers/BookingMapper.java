package com.serivce.booking_service.mappers;

import com.serivce.booking_service.controllers.model.Requests.CreateBookingRequest;
import com.serivce.booking_service.model.Booking;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookingMapper {
    Booking createBookingToBookingModel(CreateBookingRequest createBookingRequest);
}
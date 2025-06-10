package com.serivce.booking_service.controllers.mapper;

import com.serivce.booking_service.controllers.model.Requests.CreateBookingRequest;
import com.serivce.booking_service.controllers.model.Responses.CreateBookingResponse;
import com.serivce.booking_service.model.Booking;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookingControllerMapper {
    CreateBookingResponse createBookingResponseToCreateBookingResponse(Booking booking);
}
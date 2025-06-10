package com.serivce.booking_service.controllers;

import com.serivce.booking_service.controllers.mapper.BookingControllerMapper;
import com.serivce.booking_service.controllers.model.Requests.CreateBookingRequest;
import com.serivce.booking_service.controllers.model.Responses.CreateBookingResponse;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authorization.method.AuthorizeReturnObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.serivce.booking_service.services.interfaces.BookingService;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/booking")
class BookingController{

    @Autowired
    public BookingService bookingService;

    @Autowired
    private BookingControllerMapper bookingControllerMapper;

    @PostMapping("/create")
    public CreateBookingResponse createBooking(@RequestBody CreateBookingRequest request){
        return bookingControllerMapper.createBookingResponseToCreateBookingResponse(bookingService.createBooking(request));
    }

    @GetMapping("/{id}")
    public String getBooking(@PathVariable("id") int bookingId){
        try {
            return bookingService.returnBooking(bookingId);
        }
        catch (Exception EntityNotFoundException){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }
        }
    }

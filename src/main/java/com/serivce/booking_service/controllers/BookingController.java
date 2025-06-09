package com.serivce.booking_service.controllers;

import com.serivce.booking_service.controllers.model.Requests.CreateBookingRequest;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authorization.method.AuthorizeReturnObject;
import org.springframework.web.bind.annotation.*;
import com.serivce.booking_service.services.interfaces.BookingService;

@RestController
@RequestMapping("/booking")
class BookingController{

    @Autowired
    public BookingService bookingService;

    @PostMapping("/create")
    public String createBooking(@RequestBody CreateBookingRequest request){
        return bookingService.createBooking(request);
    }

    @GetMapping("/{id}")
    public String getBooking(@PathVariable("id") int bookingId){
        return bookingService.returnBooking(bookingId);
    }

}

package com.serivce.booking_service.controllers.model.Requests;

import java.util.UUID;

public class CreateBookingRequest{
    public UUID userId;
    public int[] seatIds;
    public int movieId;
}
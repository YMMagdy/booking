package com.serivce.booking_service.controllers.model.Requests;

import java.util.UUID;

public class UpdateBookingRequest {
    public UUID userId;
    public int[] seatIds;
    public int movieId;
}
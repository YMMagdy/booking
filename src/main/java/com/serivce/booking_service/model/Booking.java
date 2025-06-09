package com.serivce.booking_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
public class Booking {
    public UUID userId;
    public int[] seatIds;
    public int movieId;
}

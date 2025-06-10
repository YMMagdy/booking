package com.serivce.booking_service.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public int bookingId;
    public UUID userId;
    public int[] seatIds;
    public int movieId;
}

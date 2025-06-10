package com.serivce.booking_service.Repository;

import com.serivce.booking_service.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository  extends JpaRepository<Booking, Integer>{
}

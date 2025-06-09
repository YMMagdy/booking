package com.serivce.booking_service.services.impelementation;
import com.serivce.booking_service.controllers.model.Requests.CreateBookingRequest;
import com.serivce.booking_service.mappers.CreateBookingToBookingModel;
import com.serivce.booking_service.services.interfaces.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
class BookingServiceImpl implements BookingService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private CreateBookingToBookingModel bookingMapper;

    @Override
    public String createBooking(CreateBookingRequest request) {
        kafkaTemplate.send("notification",bookingMapper.createBookingToBookingModel(request).toString());
        return bookingMapper.createBookingToBookingModel(request).toString();
    }

    @Override
    public String returnBooking(int bookingId) {
        return "Booking " + bookingId;
    }

    @Override
    public String updateBooking(CreateBookingRequest request) {
        return "";
    }

    @Override
    public String deleteBooking(UUID userId, int movieId) {
        return "";
    }
}

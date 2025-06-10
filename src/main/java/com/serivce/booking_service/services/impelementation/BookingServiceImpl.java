package com.serivce.booking_service.services.impelementation;
import com.serivce.booking_service.Repository.BookingRepository;
import com.serivce.booking_service.controllers.mapper.BookingControllerMapper;
import com.serivce.booking_service.controllers.model.Requests.CreateBookingRequest;
import com.serivce.booking_service.controllers.model.Responses.CreateBookingResponse;
import com.serivce.booking_service.mappers.BookingMapper;
import com.serivce.booking_service.model.Booking;
import com.serivce.booking_service.services.interfaces.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.net.http.HttpClient;
import java.util.UUID;

@Service
class BookingServiceImpl implements BookingService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private BookingMapper bookingMapper;

    @Autowired
    private BookingControllerMapper bookingControllerMapper;

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Booking createBooking(CreateBookingRequest request) {
        kafkaTemplate.send("notification",bookingMapper.createBookingToBookingModel(request).toString());
        return bookingRepository.save(bookingMapper.createBookingToBookingModel(request));
    }

    @Override
    public String returnBooking(int bookingId) {
        return bookingRepository.getReferenceById(bookingId).toString();
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

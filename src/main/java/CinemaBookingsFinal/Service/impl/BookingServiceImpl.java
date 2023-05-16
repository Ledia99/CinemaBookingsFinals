package CinemaBookingsFinal.Service.impl;

import CinemaBookingsFinal.Domain.dto.Booking.BookingDTO;
import CinemaBookingsFinal.Domain.dto.Booking.BookingUpdateDTO;
import CinemaBookingsFinal.Domain.dto.Movie.MovieDTO;
import CinemaBookingsFinal.Domain.entity.Booking;
import CinemaBookingsFinal.Domain.entity.Movie;
import CinemaBookingsFinal.Domain.exception.ResourceNotFoundException;
import CinemaBookingsFinal.Domain.mapper.BookingMapper;
import CinemaBookingsFinal.Domain.mapper.MovieMapper;
import CinemaBookingsFinal.Repository.BookingRepository;
import CinemaBookingsFinal.Service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private BookingRepository bookingRepository;
    @Override
    public List<BookingDTO> getAllBookings() {
        return bookingRepository.findAll().stream().map(BookingMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Booking getBookingById (Integer id) {
        return bookingRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(String
                        .format("Booking with id %s not found",id)));

    }
    @Override
    public void deleteBookingById(Integer id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Booking with id %s not found", id)));
        bookingRepository.delete(booking);
    }

//    @Override
//    public BookingDTO updateBooking(Integer id, BookingUpdateDTO req) {
//        Booking toUpdate = bookingRepository.findById(id)
//                .orElseThrow(()-> new ResourceNotFoundException(String
//                        .format("Booking with id %s not found",id)));
//        return BookingMapper.toDto(bookingRepository
//                .save(BookingMapper.toEntityUpdate(toUpdate,req)));
//    }
    @Override
    public BookingDTO pushBooking(BookingDTO b){
        Booking booking = BookingMapper.toEntity(b);

        Booking savedBooking = bookingRepository.save(booking);
        BookingDTO savedBookingDTO = BookingMapper.toDto(savedBooking);
        return savedBookingDTO;
    }
}

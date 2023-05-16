package CinemaBookingsFinal.Service.impl;

import CinemaBookingsFinal.Domain.dto.Booking.BookingDTO;
import CinemaBookingsFinal.Domain.dto.Booking.BookingUpdateDTO;
import CinemaBookingsFinal.Domain.dto.Movie.MovieDTO;
import CinemaBookingsFinal.Domain.dto.Screening.ScreeningDTO;
import CinemaBookingsFinal.Domain.entity.Booking;
import CinemaBookingsFinal.Domain.entity.Movie;
import CinemaBookingsFinal.Domain.entity.Screening;
import CinemaBookingsFinal.Domain.entity.User;
import CinemaBookingsFinal.Domain.exception.ResourceNotFoundException;
import CinemaBookingsFinal.Domain.mapper.BookingMapper;
import CinemaBookingsFinal.Domain.mapper.MovieMapper;
import CinemaBookingsFinal.Repository.BookingRepository;
import CinemaBookingsFinal.Service.BookingService;
import CinemaBookingsFinal.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private BookingRepository bookingRepository;
    private UserService userService;
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
    public Void deleteBookingById(Integer id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Booking with id %s not found", id)));
        bookingRepository.delete(booking);
        return null;
    }


    @Override
    public BookingDTO pushBooking(Jwt jwt, Screening s){
        User u = userService.getUserFromToken(jwt);
        Booking booking = BookingMapper.createBooking(u,s);
        Booking savedBooking = bookingRepository.save(booking);
        BookingDTO savedBookingDTO = BookingMapper.toDto(savedBooking);
        return savedBookingDTO;
    }

//    @Override
//    public BookingDTO updateBooking(BookingUpdateDTO updatedBooking, Integer id) {
//        Booking toUpdate = bookingRepository.findById(id)
//                .orElseThrow(()-> new ResourceNotFoundException(String
//                        .format("Booking with id %s not found",id)));
//        return BookingMapper.toDto(bookingRepository
//                .save(BookingMapper.toEntityUpdate(toUpdate,updatedBooking)));
//    }
//@Override
//public BookingUpdateDTO updateBooking(BookingUpdateDTO updatedBooking, Integer id) {
//    Booking toUpdate = bookingRepository.findById(id)
//            .orElseThrow(()-> new ResourceNotFoundException(String
//                    .format("Booking with id %s not found",id)));
//    return BookingMapper.toUpdateDto(bookingRepository
//            .save(BookingMapper.toEntityUpdate(toUpdate,updatedBooking)));
//}
}

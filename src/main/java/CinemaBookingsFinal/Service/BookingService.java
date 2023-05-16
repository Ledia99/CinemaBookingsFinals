package CinemaBookingsFinal.Service;

import CinemaBookingsFinal.Domain.dto.Booking.BookingDTO;
import CinemaBookingsFinal.Domain.dto.Booking.BookingUpdateDTO;
import CinemaBookingsFinal.Domain.dto.Screening.ScreeningDTO;
import CinemaBookingsFinal.Domain.entity.Booking;
import CinemaBookingsFinal.Domain.entity.Screening;
import org.springframework.security.oauth2.jwt.Jwt;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface BookingService {
    List<BookingDTO> getAllBookings();

    Booking getBookingById(Integer booking_id);

    BookingDTO pushBooking(Jwt jwt, Screening s);

//    BookingDTO updateBooking(BookingUpdateDTO updatedBooking, Integer id);

    Void deleteBookingById(Integer booking_id);
}

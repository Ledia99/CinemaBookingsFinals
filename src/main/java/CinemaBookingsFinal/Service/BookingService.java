package CinemaBookingsFinal.Service;

import CinemaBookingsFinal.Domain.dto.Booking.BookingDTO;
import CinemaBookingsFinal.Domain.dto.Booking.BookingUpdateDTO;
import CinemaBookingsFinal.Domain.entity.Booking;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface BookingService {
    List<BookingDTO> getAllBookings();

    Booking getBookingById(Integer booking_id);

    BookingDTO pushBooking(BookingDTO newBooking);

//    BookingDTO updateBooking(BookingUpdateDTO updatedBooking, Integer id);

    void deleteBookingById(Integer booking_id);
}

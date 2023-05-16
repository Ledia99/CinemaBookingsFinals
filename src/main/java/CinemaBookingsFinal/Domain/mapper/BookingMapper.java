package CinemaBookingsFinal.Domain.mapper;

import CinemaBookingsFinal.Domain.dto.Booking.BookingDTO;
import CinemaBookingsFinal.Domain.dto.Booking.BookingUpdateDTO;
import CinemaBookingsFinal.Domain.dto.User.UserUpdateDTO;
import CinemaBookingsFinal.Domain.entity.Booking;
import CinemaBookingsFinal.Domain.entity.Screening;
import CinemaBookingsFinal.Domain.entity.User;

import java.time.LocalTime;

public class BookingMapper {

    public static BookingDTO toDto(Booking booking){
        return BookingDTO.builder()
                .id(booking.getId())
                .screening(booking.getScreening() != null
                ? ScreeningMapper.toDto(booking.getScreening()):null)
                .user(UserMapper.toDto(booking.getUser()))
                .bookingTime(booking.getBookingTime())
                .build();
    }
    public static Booking toEntity(BookingDTO bookingDTO) {
        return Booking.builder()
                .id(bookingDTO.getId())
                .screening(ScreeningMapper.toEntity(bookingDTO.getScreening()))
                .user(UserMapper.toEntity(bookingDTO.getUser()))
                .bookingTime(bookingDTO.getBookingTime())
                .build();
    }
    public static Booking toEntityUpdate(Booking b, BookingUpdateDTO bup){
         b.setBookingTime(bup.getBookTime());
         b.setScreening((bup.getScreening()));
        return b;
    }
    public static Booking toEntityBooking(BookingDTO b, Screening s)
    {
        return Booking.builder()
                .bookingTime(b.getBookingTime())
                .screening(s)
                .build();
    }


    public static Booking createBooking(User u, Screening screening) {
        Booking b = new Booking();
        b.setUser(u);
        b.setBookingTime(LocalTime.now());
        b.setScreening(screening);
        return b;
    }

}

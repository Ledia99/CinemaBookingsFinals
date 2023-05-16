package CinemaBookingsFinal.Domain.mapper;

import CinemaBookingsFinal.Domain.dto.Booking.BookingDTO;
import CinemaBookingsFinal.Domain.dto.Booking.BookingUpdateDTO;
import CinemaBookingsFinal.Domain.dto.Movie.MovieDTO;
import CinemaBookingsFinal.Domain.dto.Screening.ScreeningDTO;
import CinemaBookingsFinal.Domain.dto.Screening.ScreeningUpdateDTO;
import CinemaBookingsFinal.Domain.entity.Booking;
import CinemaBookingsFinal.Domain.entity.Movie;
import CinemaBookingsFinal.Domain.entity.Screening;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class ScreeningMapper {
    public static ScreeningDTO toDto(Screening sc) {
        return ScreeningDTO.builder()
                .id(sc.getId())
                .movie(sc.getMovie() != null
                        ? MovieMapper.toDto(sc.getMovie()) : null)
                .start_time(sc.getStartTime())
                .end_time(sc.getEndTime())
                .price(sc.getPrice())
                .bookings(sc.getBookings().stream().map(scb -> BookingMapper.toDto(scb)).collect(Collectors.toList()))
                .build();

    }

    public static Screening toEntity(ScreeningDTO screeningDTO) {
        return Screening.builder()
                .id(screeningDTO.getId())
                .movie(screeningDTO.getMovie() != null
                        ? MovieMapper.toEntity(screeningDTO.getMovie()) : null)
                .startTime(screeningDTO.getStart_time())
                .endTime(screeningDTO.getEnd_time())
                .price(screeningDTO.getPrice())
                .bookings(screeningDTO.getBookings().stream().map(sbo -> BookingMapper.toEntity(sbo)).collect(Collectors.toList()))
                .build();
    }

    public static Screening toEntityUpdate(Screening s, ScreeningUpdateDTO up) {
        s.setStartTime(up.getStart_time());
        s.setEndTime(up.getEnd_time());
        s.setPrice(up.getPrice());
        return s;
    }

}

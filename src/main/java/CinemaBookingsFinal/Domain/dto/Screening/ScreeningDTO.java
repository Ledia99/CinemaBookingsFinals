package CinemaBookingsFinal.Domain.dto.Screening;


import CinemaBookingsFinal.Domain.dto.Booking.BookingDTO;
import CinemaBookingsFinal.Domain.dto.Cinema.CinemaDTO;
import CinemaBookingsFinal.Domain.dto.Movie.MovieDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ScreeningDTO {
    private Integer id;
    private MovieDTO movie;
    private LocalTime start_time;
    private LocalTime end_time;
    private Boolean isFull;
    private Double price;
    private List<BookingDTO> bookings;


}

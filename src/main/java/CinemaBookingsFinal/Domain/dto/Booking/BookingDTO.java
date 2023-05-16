package CinemaBookingsFinal.Domain.dto.Booking;

import CinemaBookingsFinal.Domain.dto.Screening.ScreeningDTO;
import CinemaBookingsFinal.Domain.dto.User.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.*;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BookingDTO {
    private Integer id;
    private ScreeningDTO screening;
    private UserDTO user;
    private LocalTime bookingTime;

}

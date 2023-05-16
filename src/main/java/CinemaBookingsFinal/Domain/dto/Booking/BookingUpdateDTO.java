package CinemaBookingsFinal.Domain.dto.Booking;

import CinemaBookingsFinal.Domain.dto.Screening.ScreeningDTO;
import CinemaBookingsFinal.Domain.entity.Screening;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BookingUpdateDTO {
    private LocalTime bookTime;
    private Screening screening;
}

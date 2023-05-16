package CinemaBookingsFinal.Domain.dto.Screening;


import CinemaBookingsFinal.Domain.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ScreeningUpdateDTO {

    private LocalTime start_time;
    private LocalTime end_time;
    private Double price;
}

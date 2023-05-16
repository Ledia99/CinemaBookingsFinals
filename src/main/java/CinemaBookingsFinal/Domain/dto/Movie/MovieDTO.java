package CinemaBookingsFinal.Domain.dto.Movie;

import CinemaBookingsFinal.Domain.dto.Screening.ScreeningDTO;
import CinemaBookingsFinal.Domain.entity.Screening;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieDTO {

    private Integer id;
    private String title;
    private String genre;
    private Integer duration;

}


package CinemaBookingsFinal.Domain.dto.Cinema;


import CinemaBookingsFinal.Domain.dto.Screening.ScreeningDTO;
import CinemaBookingsFinal.Domain.entity.Screening;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CinemaDTO {
    private Integer id;
    private String name;
    private Integer seatCount;
    private List<ScreeningDTO> screenings;
}

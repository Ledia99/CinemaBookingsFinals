package CinemaBookingsFinal.Service;

import CinemaBookingsFinal.Domain.dto.Screening.ScreeningDTO;
import CinemaBookingsFinal.Domain.dto.Screening.ScreeningUpdateDTO;
import CinemaBookingsFinal.Domain.entity.*;

import java.time.LocalDate;
import java.util.List;

public interface ScreeningService {

    List<ScreeningDTO> getAllScreenings();

    Screening getScreeningById(Integer id);

    ScreeningDTO addScreening(ScreeningDTO newScreening);

}

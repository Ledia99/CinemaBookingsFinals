package CinemaBookingsFinal.Domain.mapper;

import CinemaBookingsFinal.Domain.dto.Cinema.CinemaDTO;
import CinemaBookingsFinal.Domain.dto.User.UserDTO;
import CinemaBookingsFinal.Domain.entity.Cinema;
import CinemaBookingsFinal.Domain.entity.User;

import java.util.stream.Collectors;

public class CinemaMapper {
    public static CinemaDTO toDto(Cinema cinema)
    {
        return CinemaDTO.builder()
                .id(cinema.getId())
                .name(cinema.getName())
                .seatCount(cinema.getSeatCount())
                .screenings(cinema.getScreenings().stream().map(sc -> ScreeningMapper.toDto(sc))
                        .collect(Collectors.toList()))
                .build();
    }
    public static Cinema toEntity(CinemaDTO cinemaDTO){
        return Cinema.builder()
                .id(cinemaDTO.getId())
                .name(cinemaDTO.getName())
                .seatCount(cinemaDTO.getSeatCount())
                .screenings(cinemaDTO.getScreenings().stream().map(scr -> ScreeningMapper.toEntity(scr)).collect(Collectors.toList()))
                .build();
    }

}

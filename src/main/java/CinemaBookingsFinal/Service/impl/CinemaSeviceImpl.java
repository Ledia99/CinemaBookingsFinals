package CinemaBookingsFinal.Service.impl;

import CinemaBookingsFinal.Domain.entity.Cinema;
import CinemaBookingsFinal.Domain.entity.Movie;
import CinemaBookingsFinal.Domain.exception.ResourceNotFoundException;
import CinemaBookingsFinal.Repository.CinemaRepository;
import CinemaBookingsFinal.Service.CinemaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CinemaSeviceImpl implements CinemaService {
    private final CinemaRepository cinemaRepository;
    @Override
    public Cinema getCinemaById (Integer id) {
        return cinemaRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(String
                        .format("Cinema with id %s not found",id)));

    }
}

package CinemaBookingsFinal.Service.impl;

import CinemaBookingsFinal.Domain.dto.Movie.MovieDTO;
import CinemaBookingsFinal.Domain.entity.Movie;
import CinemaBookingsFinal.Domain.exception.ResourceNotFoundException;
import CinemaBookingsFinal.Domain.mapper.MovieMapper;
import CinemaBookingsFinal.Repository.MovieRepository;
import CinemaBookingsFinal.Service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    @Override
    public List<MovieDTO> getAllMovies() {
        return movieRepository.findAll().stream().map(MovieMapper::toDto).collect(Collectors.toList());
    }
    @Override
    public Movie getMovieById (Integer id) {
        return movieRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(String
                        .format("Movie with id %s not found",id)));

    }
    @Override
    public Void deleteMovie(Integer id) {
        movieRepository.deleteById(id);
    return null;
    }

    @Override
    public MovieDTO pushMovie(MovieDTO movieDTO) {
        Movie movie = movieRepository.findById(movieDTO.getId()).orElse(null);
        if(movie != null){throw new ResourceNotFoundException(String.format("Movie exists"));}
        return MovieMapper.toDto(movieRepository.save(MovieMapper.toEntity(movieDTO)));
    }

}

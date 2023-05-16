package CinemaBookingsFinal.Service;

import CinemaBookingsFinal.Domain.dto.Movie.MovieDTO;
import CinemaBookingsFinal.Domain.entity.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.util.List;

public interface MovieService {

    List<MovieDTO> getAllMovies();

    Movie getMovieById(Integer movie_id);

    MovieDTO pushMovie(MovieDTO newMovie);

    Void deleteMovie(Integer movie_id);

}

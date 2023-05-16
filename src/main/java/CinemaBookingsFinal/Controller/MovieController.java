package CinemaBookingsFinal.Controller;

import CinemaBookingsFinal.Domain.dto.Movie.MovieDTO;
import CinemaBookingsFinal.Domain.entity.Movie;
import CinemaBookingsFinal.Domain.mapper.MovieMapper;
import CinemaBookingsFinal.Domain.mapper.UserMapper;
import CinemaBookingsFinal.Service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RequiredArgsConstructor
@RestControllerAdvice
@RequestMapping("/movie")
public class MovieController {
    private final MovieService movieService;

    @GetMapping("/{id}")
    public ResponseEntity<Movie> findById(@PathVariable Integer id) {
        Movie movie = movieService.getMovieById(id);
        return ResponseEntity.ok(movie);

    }

    @RolesAllowed("ADMIN")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMovieById(@PathVariable Integer id) {
        return ResponseEntity.ok(movieService.deleteMovie(id));
    }

}
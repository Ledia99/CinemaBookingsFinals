package CinemaBookingsFinal.Controller;

import CinemaBookingsFinal.Domain.entity.Cinema;
import CinemaBookingsFinal.Domain.entity.Movie;
import CinemaBookingsFinal.Service.CinemaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RequiredArgsConstructor
@RestControllerAdvice
@RequestMapping("/movie")
public class CinemaController {
private final CinemaService cinemaService;

    @GetMapping("/cinema/{id}")
    public ResponseEntity<Cinema> findById(@PathVariable Integer id) {
        Cinema c = cinemaService.getCinemaById(id);
        return ResponseEntity.ok(c);

    }
}

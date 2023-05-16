package CinemaBookingsFinal.Controller;

import CinemaBookingsFinal.Domain.dto.Booking.BookingDTO;
import CinemaBookingsFinal.Domain.entity.Booking;
import CinemaBookingsFinal.Domain.entity.Screening;
import CinemaBookingsFinal.Service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RequiredArgsConstructor
@RestControllerAdvice
@RequestMapping("/bookings")
public class BookingController {
    private final BookingService bookingService;

    @GetMapping("/{id}")
    public ResponseEntity<Booking> findById(@PathVariable Integer id) {
        Booking b = bookingService.getBookingById(id);
        return ResponseEntity.ok(b);
    }
    @RolesAllowed("ADMIN")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBookingById(@PathVariable Integer id) {
        return ResponseEntity.ok(bookingService.deleteBookingById(id));
    }
    @PostMapping
    public ResponseEntity<BookingDTO> pushBooking(@AuthenticationPrincipal Jwt jwt, @RequestBody Screening s){
        return ResponseEntity.ok(bookingService.pushBooking(jwt,s));
    }
}

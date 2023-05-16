package CinemaBookingsFinal.Controller;

import CinemaBookingsFinal.Domain.dto.Booking.BookingDTO;
import CinemaBookingsFinal.Domain.dto.Booking.BookingUpdateDTO;
import CinemaBookingsFinal.Domain.dto.User.UserUpdateDTO;
import CinemaBookingsFinal.Domain.entity.Booking;
import CinemaBookingsFinal.Domain.entity.Screening;
import CinemaBookingsFinal.Domain.mapper.BookingMapper;
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
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBookingById(@PathVariable Integer id) {
        return ResponseEntity.ok(bookingService.deleteBookingById(id));
    }
    @PostMapping
    public ResponseEntity<BookingDTO> pushBooking(@AuthenticationPrincipal Jwt jwt, @RequestBody Screening s){
        return ResponseEntity.ok(bookingService.pushBooking(jwt,s));
    }
//    @PutMapping("/update/{id}")
//    public ResponseEntity<BookingDTO> updateBooking(@PathVariable Integer id, @RequestBody BookingUpdateDTO req){
//        BookingUpdateDTO u = bookingService.updateBooking(req,id);
//        return ResponseEntity.ok(BookingMapper.toUpdateDto(u));
//    }
}

package CinemaBookingsFinal.Controller;

import CinemaBookingsFinal.Domain.dto.Screening.ScreeningDTO;
import CinemaBookingsFinal.Domain.entity.Movie;
import CinemaBookingsFinal.Domain.entity.Screening;
import CinemaBookingsFinal.Service.ScreeningService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RequiredArgsConstructor
@RestControllerAdvice
@RequestMapping("/screening")
public class ScreeningController {

    private final ScreeningService screeningService;

    @GetMapping("/list")
    public ResponseEntity<List<ScreeningDTO>> getAllScreenings(){
        return ResponseEntity.ok(screeningService.getAllScreenings());
    }
//    @RolesAllowed("ADMIN")
//    @PostMapping("/admin/{}")
//    public ResponseEntity<ScreeningDTO> addScreening(@PathVariable Integer categoryId,
//                                                 @RequestBody ProductDTO req ){
//        return ResponseEntity.ok(productService.addProduct(categoryId,req));
//    }
@GetMapping("/{id}")
public ResponseEntity<Screening> findById(@PathVariable Integer id) {
    Screening sc = screeningService.getScreeningById(id);
    return ResponseEntity.ok(sc);

}
}

package CinemaBookingsFinal.Repository;

import CinemaBookingsFinal.Domain.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface BookingRepository extends JpaRepository<Booking, Integer> {

    List<Booking> findAllByUserEmail(String email);
}

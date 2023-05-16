package CinemaBookingsFinal.Repository;

import CinemaBookingsFinal.Domain.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CinemaRepository extends JpaRepository<Cinema, Integer> {
}


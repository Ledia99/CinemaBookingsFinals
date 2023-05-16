package CinemaBookingsFinal.Repository;

import CinemaBookingsFinal.Domain.entity.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ScreeningRepository extends JpaRepository<Screening, Integer> {}


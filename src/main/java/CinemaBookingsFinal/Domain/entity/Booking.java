package CinemaBookingsFinal.Domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "booking")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "booking_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "screening_id")
    private Screening screening;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "booking_time")
    private LocalTime bookingTime;

    @Column(name = "is_booked")
    private boolean isBooked;

    @Column(name = "is_active")
    private boolean isActive;


}

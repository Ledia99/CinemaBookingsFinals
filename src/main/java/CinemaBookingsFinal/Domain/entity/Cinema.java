package CinemaBookingsFinal.Domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.*;
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "cinema")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Cinema {
    @Id
    @GeneratedValue
    @Column(name = "cinema_id")
    private Integer id;

    @Column(name = "seat_count")
    private Integer seatCount;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "cinema", cascade = CascadeType.ALL)
    private List<Screening> screenings;
}
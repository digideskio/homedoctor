package tikaso.joosakur.homedoctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tikaso.joosakur.homedoctor.domain.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>, ReservationRepositoryCustom {
    
}

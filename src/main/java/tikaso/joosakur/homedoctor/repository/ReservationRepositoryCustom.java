package tikaso.joosakur.homedoctor.repository;

import java.util.List;
import tikaso.joosakur.homedoctor.domain.Doctor;
import tikaso.joosakur.homedoctor.domain.Reservation;

public interface ReservationRepositoryCustom {
    List<Reservation> findReservations(int year, int month, int day, Doctor doctor);
}

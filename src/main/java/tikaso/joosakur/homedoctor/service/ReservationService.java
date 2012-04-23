package tikaso.joosakur.homedoctor.service;

import java.util.List;
import tikaso.joosakur.homedoctor.domain.Customer;
import tikaso.joosakur.homedoctor.domain.Doctor;
import tikaso.joosakur.homedoctor.domain.Reservation;

public interface ReservationService {
    
    public Reservation createOrUpdate(Reservation reservation);
    
    public Reservation create(Reservation reservation, Customer customer, Doctor doctor);
    
    public Reservation findById(Long id);
    
    public List<Reservation> findAllReservations();
    
    public List<Reservation> findAllFutureReservations(List<Reservation> reservations);
    
    public List<Reservation> findAllPastReservations(List<Reservation> reservations);

    public void cancelReservation(Long id);
    
    
}

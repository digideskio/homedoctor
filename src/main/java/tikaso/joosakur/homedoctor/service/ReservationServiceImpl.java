package tikaso.joosakur.homedoctor.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tikaso.joosakur.homedoctor.domain.Customer;
import tikaso.joosakur.homedoctor.domain.Doctor;
import tikaso.joosakur.homedoctor.domain.Reservation;
import tikaso.joosakur.homedoctor.repository.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService{
    
    @Autowired
    private ReservationRepository reservationRepository;
    
    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private DoctorService doctorService;
    
    @Autowired
    private DateService dateService;
    
    @Override
    @Transactional
    public Reservation createOrUpdate(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    @Transactional
    public Reservation create(Reservation reservation, Customer customer, Doctor doctor) {
        reservation.setCustomer(customer);
        customer.getReservations().add(reservation);
        
        reservation.setDoctor(doctor);
        doctor.getReservations().add(reservation);
        
        reservation = createOrUpdate(reservation);
        customerService.createOrUpdate(customer);
        doctorService.createOrUpdate(doctor);
        
        return reservation;
    }

    @Override
    public List<Reservation> findAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public List<Reservation> findAllFutureReservations(List<Reservation> reservations) {
        List<Reservation> futureReservations = new ArrayList<Reservation>();
        for (Reservation res : reservations){
            if(dateService.isInFuture(res.getOrderYear(), res.getOrderMonth(), res.getOrderDay(), res.getStartHour()))
                futureReservations.add(res);
        }
        Collections.sort(futureReservations, new ReservationTimeAscending());
        return futureReservations;
    }

    @Override
    public List<Reservation> findAllPastReservations(List<Reservation> reservations) {
        List<Reservation> pastReservations = new ArrayList<Reservation>();
        for (Reservation res : reservations){
            if(dateService.isInPast(res.getOrderYear(), res.getOrderMonth(), res.getOrderDay(), res.getStartHour()))
                pastReservations.add(res);
        }
        Collections.sort(pastReservations, new ReservationTimeAscending());
        return pastReservations;
    }

    @Override
    public Reservation findById(Long id) {
        return reservationRepository.findOne(id);
    }

    @Override
    public void cancelReservation(Long id) {
        Reservation reservation = findById(id);
        if(reservation==null || dateService.isInPast(reservation.getOrderYear(), reservation.getOrderMonth(), 
                                                     reservation.getOrderDay(), reservation.getStartHour())) 
            return;
        
        Doctor doctor = reservation.getDoctor();
        Customer customer = reservation.getCustomer();
        doctor.getReservations().remove(reservation);
        customer.getReservations().remove(reservation);
        reservationRepository.delete(id);
        doctorService.createOrUpdate(doctor);
        customerService.createOrUpdate(customer);
    }

    private static class ReservationTimeAscending implements Comparator<Reservation> {
        @Override
        public int compare(Reservation o1, Reservation o2) {
            if (o1.getOrderYear() < o2.getOrderYear()) return -1;
            if (o1.getOrderYear() > o2.getOrderYear()) return 1;
            if (o1.getOrderMonth() < o2.getOrderMonth()) return -1;
            if (o1.getOrderMonth() > o2.getOrderMonth()) return 1;
            if (o1.getOrderDay() < o2.getOrderDay()) return -1;
            if (o1.getOrderDay() > o2.getOrderDay()) return 1;
            if (o1.getStartHour() < o2.getStartHour()) return -1;
            if (o1.getStartHour() > o2.getStartHour()) return 1;
            return 0;
        }
    }
    
    private static class ReservationTimeDescending implements Comparator<Reservation> {
        @Override
        public int compare(Reservation o1, Reservation o2) {
            return -(new ReservationTimeAscending()).compare(o1, o2);
        }
    }
    
    

}

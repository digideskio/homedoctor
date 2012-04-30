package tikaso.joosakur.homedoctor.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tikaso.joosakur.homedoctor.domain.Doctor;
import tikaso.joosakur.homedoctor.domain.Reservation;
import tikaso.joosakur.homedoctor.repository.DoctorRepository;
import tikaso.joosakur.homedoctor.repository.ReservationRepository;

@Service
public class DoctorServiceImpl implements DoctorService{
    
    @Autowired
    private DoctorRepository doctorRepository;
    
    @Autowired
    private ReservationRepository reservationRepository;
    
    @Override
    @Transactional
    public Doctor createOrUpdate(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor find(String username) {
        return doctorRepository.findByUsername(username);
    }

    @Override
    public List<Doctor> findAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor findById(Long id) {
        return doctorRepository.findOne(id);
    }

    @Override
    public List<Integer> getFreeTimes(int year, int month, int day, Doctor doctor) {
        List<Integer> freeTimes = new ArrayList<Integer>();
        for (int i = 8; i < 16; i++) {
            freeTimes.add(i);
        }
        
        List<Integer> takenTimes = new ArrayList<Integer>();
        for(Reservation reservation : reservationRepository.findReservations(year, month, day, doctor)){
            takenTimes.add(reservation.getStartHour());
        }
        
        freeTimes.removeAll(takenTimes);
        
        return freeTimes;
    }

}

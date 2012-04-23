package tikaso.joosakur.homedoctor.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tikaso.joosakur.homedoctor.domain.Doctor;
import tikaso.joosakur.homedoctor.domain.Reservation;
import tikaso.joosakur.homedoctor.repository.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService{
    
    @Autowired
    private DoctorRepository doctorRepository;
    
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
        List<Integer> times = new ArrayList<Integer>();
        for (int i = 8; i < 16; i++) {
            times.add(i);
        }
        
        List<Reservation> reservations = doctor.getReservations();
        List<Integer> takenTimes = new ArrayList<Integer>();
        for(Reservation reservation : reservations){
            if(reservation.getOrderYear() != year || reservation.getOrderMonth() != month || reservation.getOrderDay() != day)
                continue;
            takenTimes.add(reservation.getStartHour());
        }
        
        times.removeAll(takenTimes);
        
        return times;
    }

}

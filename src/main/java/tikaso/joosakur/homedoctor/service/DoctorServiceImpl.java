package tikaso.joosakur.homedoctor.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tikaso.joosakur.homedoctor.domain.Doctor;
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

}

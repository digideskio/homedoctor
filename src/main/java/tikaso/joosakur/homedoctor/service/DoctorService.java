package tikaso.joosakur.homedoctor.service;

import java.util.List;
import tikaso.joosakur.homedoctor.domain.Doctor;

public interface DoctorService {
    
    public Doctor createOrUpdate(Doctor doctor);
        
    public Doctor find(String username);
    
    public List<Doctor> findAllDoctors();
}

package tikaso.joosakur.homedoctor.service;

import java.util.List;
import tikaso.joosakur.homedoctor.domain.Doctor;

public interface DoctorService {
    
    public Doctor createOrUpdate(Doctor doctor);
        
    public Doctor find(String username);
    
    public Doctor findById(Long id);
    
    public List<Doctor> findAllDoctors();
    
    public List<Integer> getFreeTimes(int year, int month, int day, Doctor doctor);
}

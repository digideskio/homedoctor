package tikaso.joosakur.homedoctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tikaso.joosakur.homedoctor.domain.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    public Doctor findByUsername(String username);
}

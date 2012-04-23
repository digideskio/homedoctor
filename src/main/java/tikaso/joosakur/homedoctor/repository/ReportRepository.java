package tikaso.joosakur.homedoctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tikaso.joosakur.homedoctor.domain.Report;

public interface ReportRepository extends JpaRepository<Report, Long> {
    
}

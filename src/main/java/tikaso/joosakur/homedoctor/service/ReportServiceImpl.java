package tikaso.joosakur.homedoctor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tikaso.joosakur.homedoctor.domain.Report;
import tikaso.joosakur.homedoctor.repository.ReportRepository;

@Service
public class ReportServiceImpl implements ReportService{
    
    @Autowired
    private ReportRepository reportRepository;

    @Override
    @Transactional
    public Report createOrUpdate(Report report) {
        return reportRepository.save(report);
    }

    @Override
    public Report findById(Long id) {
        return reportRepository.findOne(id);
    }
    
}

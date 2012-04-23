package tikaso.joosakur.homedoctor.service;

import tikaso.joosakur.homedoctor.domain.Report;

public interface ReportService {
    
    public Report createOrUpdate(Report report);
    
    public Report findById(Long id);
}

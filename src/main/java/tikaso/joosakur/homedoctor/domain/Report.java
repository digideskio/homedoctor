package tikaso.joosakur.homedoctor.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import tikaso.joosakur.homedoctor.formvalidation.ReportFormObject;

@Entity
public class Report {
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    protected Long id;
    
    String report;
    String treatmentInstructions;

    public Report() {
    }

    public Report(ReportFormObject formObj) {
        this.report = formObj.getReport();
        this.treatmentInstructions = formObj.getTreatmentInstructions();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public String getTreatmentInstructions() {
        return treatmentInstructions;
    }

    public void setTreatmentInstructions(String treatmentInstructions) {
        this.treatmentInstructions = treatmentInstructions;
    }
    
    
}

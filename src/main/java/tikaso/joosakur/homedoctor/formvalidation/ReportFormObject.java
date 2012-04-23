package tikaso.joosakur.homedoctor.formvalidation;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class ReportFormObject {

    @Size(min=0, max=1000, message="Please use at most 1000 characters.")
    @Pattern(regexp="[a-zA-Z0-9 äöÄÖ\\.\\,\\!\\p{Space}\\-\\:\\?\\(\\)\\/\\%\\']*", message="You have used some unaccepted characters.")
    private String report;

    @Size(min=0, max=1000, message="Please use at most 1000 characters.")
    @Pattern(regexp="[a-zA-Z0-9 äöÄÖ\\.\\,\\!\\p{Space}\\-\\:\\?\\(\\)\\/\\%\\']*", message="You have used some unaccepted characters.")
    private String treatmentInstructions;
    
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

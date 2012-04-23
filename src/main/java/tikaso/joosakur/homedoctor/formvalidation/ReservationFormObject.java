package tikaso.joosakur.homedoctor.formvalidation;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class ReservationFormObject {

    private int day;
    private int month;
    private int year;
    @NotNull(message="If there are no free times, please go back and choose another day or another doctor.")
    @Min(value=1, message="If there are no free times, please go back and choose another day or another doctor.")
    private int startHour;
    private Long doctorId;
    @Size(min=0, max=1000, message="Please use at most 1000 characters.")
    @Pattern(regexp="[a-zA-Z0-9 äöÄÖ\\.\\,\\!\\p{Space}\\-\\:\\?\\(\\)\\/\\%\\']*", message="You have used some unaccepted characters.")
    private String message;

    public ReservationFormObject() {
    }
    
    public ReservationFormObject(int day, int month, int year, Long doctorId) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.doctorId = doctorId;
    }

    public ReservationFormObject(int day, int month, int year, int startHour, Long doctorId, String message) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.startHour = startHour;
        this.doctorId = doctorId;
        this.message = message;
    }
    
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    
    
}
